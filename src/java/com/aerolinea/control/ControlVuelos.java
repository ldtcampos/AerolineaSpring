package com.aerolinea.control;

import com.aerolinea.dao.AeropuertoDaoImpl;
import com.aerolinea.dao.AvionDaoImpl;
import com.aerolinea.dao.VueloDaoImpl;
import com.aerolinea.entidad.Aviones;
import com.aerolinea.entidad.Aeropuertos;
import com.aerolinea.entidad.Vuelos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controlVuelos")
@SessionScoped
public class ControlVuelos implements Serializable {

    private Vuelos vuelo;
    private Aeropuertos origen;
    private Aeropuertos destino;
    private Aviones avion;
    private List<Vuelos> vuelos;
    private List<Aviones> aviones;
    private List<Aeropuertos> origenes;
    private List<Aeropuertos> destinos;
    @ManagedProperty("#{VueloDaoImpl}")
    private VueloDaoImpl vueloDaoImpl;
    @ManagedProperty("#{AeropuertoDaoImpl}")
    private AeropuertoDaoImpl aeropuertoDaoImpl;
    @ManagedProperty("#{AvionDaoImpl}")
    private AvionDaoImpl avionDaoImpl;
//busqueda
    private Date fecha1;
    private Date fecha2;
    private Integer idorigen;
    private Integer iddestino;

    @PostConstruct
    public void init() {
        try {
            vuelo = vueloDaoImpl.create();
            origen = aeropuertoDaoImpl.create();
            destino = aeropuertoDaoImpl.create();
            avion = avionDaoImpl.create();
        } catch (Exception e) {
        }
    }

    public ControlVuelos() {
    }

    public String preparaNuevo() {
        try {
            vuelo = vueloDaoImpl.create();
            origen = aeropuertoDaoImpl.create();
            destino = aeropuertoDaoImpl.create();
            avion = avionDaoImpl.create();
        } catch (Exception e) {
        }
        return "FormVuelos.xhtml?faces-redirect=true";
    }

    public String guardarVuelo() throws Exception {
        vuelo.setAeropuertosByIddestino(destino);
        vuelo.setAeropuertosByIdorigen(origen);
        vuelo.setAviones(avion);
        vueloDaoImpl.saveOrUpdate(vuelo);
        return "ListadoVuelos.xhtml?faces-redirect=true";
    }

    public Vuelos getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelos vuelo) {
        this.vuelo = vuelo;
    }

    public Aeropuertos getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuertos origen) {
        this.origen = origen;
    }

    public Aeropuertos getDestino() {
        return destino;
    }

    public void setDestino(Aeropuertos destino) {
        this.destino = destino;
    }

    public Aviones getAvion() {
        return avion;
    }

    public void setAvion(Aviones avion) {
        this.avion = avion;
    }

    public List<Vuelos> getVuelos() throws Exception {
        String o, d;
        idorigen = idorigen == null ? 0 : idorigen;
        iddestino = iddestino == null ? 0 : iddestino;
        vuelos = vueloDaoImpl.listarVuelos(fecha1, fecha2,
                idorigen, iddestino);
        return vuelos;
    }

    public void setVuelos(List<Vuelos> vuelos) {
        this.vuelos = vuelos;
    }

    public List<Aviones> getAviones() throws Exception {
        aviones = avionDaoImpl.findAll();
        return aviones;
    }

    public void setAviones(List<Aviones> aviones) {
        this.aviones = aviones;
    }

    public List<Aeropuertos> getOrigenes() throws Exception {
        origenes = aeropuertoDaoImpl.findAll();

        return origenes;
    }

    public void setOrigenes(List<Aeropuertos> origenes) {
        this.origenes = origenes;
    }

    public List<Aeropuertos> getDestinos() throws Exception {
        destinos = aeropuertoDaoImpl.findAll();
        return destinos;
    }

    public void setDestinos(List<Aeropuertos> destinos) {
        this.destinos = destinos;
    }

    public VueloDaoImpl getVueloDaoImpl() {
        return vueloDaoImpl;
    }

    public void setVueloDaoImpl(VueloDaoImpl vueloDaoImpl) {
        this.vueloDaoImpl = vueloDaoImpl;
    }

    public AeropuertoDaoImpl getAeropuertoDaoImpl() {
        return aeropuertoDaoImpl;
    }

    public void setAeropuertoDaoImpl(AeropuertoDaoImpl aeropuertoDaoImpl) {
        this.aeropuertoDaoImpl = aeropuertoDaoImpl;
    }

    public AvionDaoImpl getAvionDaoImpl() {
        return avionDaoImpl;
    }

    public void setAvionDaoImpl(AvionDaoImpl avionDaoImpl) {
        this.avionDaoImpl = avionDaoImpl;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public Integer getIddestino() {
        return iddestino;
    }

    public void setIddestino(Integer iddestino) {
        this.iddestino = iddestino;
    }
}
