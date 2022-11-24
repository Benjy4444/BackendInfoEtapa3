package com.aplicacion.asistenciayturnos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import static javax.persistence.CascadeType.ALL;

@Entity

//Las siguientes anotaciones reemplazan a la creación de constructores
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@ToString

//La siguiente anotacion llama a la base de datos correspondiente
@Table(name="evento")
public class Evento /* implements Serializable */ {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="idevento")
    private Long idevento;


    //@Getter @Setter @Column(name="idorganizacion")
    //private Long idorganizacion;
    //@OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "idorganizacion", nullable = false)
    //private List<Organizacion> organizacion;

    @Getter @Setter @Column(name="fecha")
    private Date fecha;

    @Getter @Setter @Column(name="ubicacion")
    private String ubicacion;

    @Getter @Setter @Column(name="activo")
    private Boolean activo;

    @Getter @Setter @Column(name="tipo")
    private Boolean tipo;

    @ManyToOne
    @JoinColumn(name = "idorganizacion")
    //@Column(name="idorganizacion")
    private Organizacion organizacion; //Esto devuelve JSON en lugar de idorganizacion
    //private Long idorganizacion;

    //Agregado el OneToMany en Organizacion... apareció esto acá
    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
    ///----------------------------------------------

    /* Reemplazado por la anotación arriba de la clase @ToString
    @Override
    public String toString() {
        return "User [Id = " + idevento + ", Organizacion = " + organizacion.getId() + ", Fecha = " + fecha + ", Ubicación = " + ubicacion
                + ", Activo = " + activo + ", Tipo = " + tipo +  "]";
    } */

}