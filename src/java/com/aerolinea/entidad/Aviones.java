package com.aerolinea.entidad;
// Generated 24-jun-2018 10:23:22 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Aviones generated by hbm2java
 */
@Entity
@Table(name = "aviones", catalog = "aerolinea"
)
public class Aviones implements java.io.Serializable {

    @Min(value = 1, message = "Seleccione avion")
    private Integer idavion;
    private int capacidad;
    @NotEmpty
    private String descripcion;
    private Set<Vuelos> vueloses = new HashSet<Vuelos>(0);

    public Aviones() {
    }

    public Aviones(int capacidad, String descripcion) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }

    public Aviones(int capacidad, String descripcion, Set<Vuelos> vueloses) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.vueloses = vueloses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idavion", unique = true, nullable = false)
    public Integer getIdavion() {
        return this.idavion;
    }

    public void setIdavion(Integer idavion) {
        this.idavion = idavion;
    }

    @Column(name = "capacidad", nullable = false)
    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Column(name = "descripcion", nullable = false, length = 70)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aviones")
    public Set<Vuelos> getVueloses() {
        return this.vueloses;
    }

    public void setVueloses(Set<Vuelos> vueloses) {
        this.vueloses = vueloses;
    }

}
