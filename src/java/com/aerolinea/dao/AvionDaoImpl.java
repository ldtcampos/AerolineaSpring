package com.aerolinea.dao;

import com.aerolinea.entidad.Aviones;
import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component("AvionDaoImpl")
public class AvionDaoImpl extends GenericDaoImpl<Aviones, Integer> implements AvionDao, Serializable {
}
