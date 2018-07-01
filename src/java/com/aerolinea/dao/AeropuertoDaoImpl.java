package com.aerolinea.dao;

import com.aerolinea.entidad.Aeropuertos;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component("AeropuertoDaoImpl")
public class AeropuertoDaoImpl extends GenericDaoImpl<Aeropuertos, Integer> implements AeropuertoDao, Serializable {
}
