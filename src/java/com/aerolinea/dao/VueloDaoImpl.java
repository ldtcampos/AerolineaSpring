package com.aerolinea.dao;

import com.aerolinea.entidad.Vuelos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component("VueloDaoImpl")
public class VueloDaoImpl extends GenericDaoImpl<Vuelos, Integer> implements VueloDao, Serializable {

    public List<Vuelos> listarVuelos(Date fecha1, Date fecha2, Integer idorigen, Integer iddestino) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = " select v from Vuelos v join fetch v.aeropuertosByIdorigen "
                    + " join fetch v.aeropuertosByIddestino join fetch v.aviones "
                    + " where v.idvuelo>0 ";
            System.out.println(hql);
            if (fecha1 != null && fecha2 != null) {
                hql += " and v.fecha between :f1 and :f2";
            }
            if (iddestino != 0 && idorigen != 0) {
                hql += " and v.aeropuertosByIdorigen.idaeropuerto =:idorigen and v.aeropuertosByIddestino.idaeropuerto = :iddestino";
            }
            Query query = session.createQuery(hql);
            if (fecha1 != null && fecha2 != null) {
                query.setParameter("f1", fecha1);
                query.setParameter("f2", fecha2);
            }

            if (iddestino != 0 && idorigen != 0) {
                query.setParameter("idorigen", idorigen);
                query.setParameter("iddestino", iddestino);
            }
            List<Vuelos> entities = query.list();
            session.getTransaction().commit();
            return entities;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            }
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }
}
