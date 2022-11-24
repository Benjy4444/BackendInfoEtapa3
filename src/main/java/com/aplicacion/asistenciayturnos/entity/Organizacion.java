package com.aplicacion.asistenciayturnos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity

//Las siguientes anotaciones reemplazan a la creación de constructores
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@ToString

//La siguiente anotacion llama a la base de datos correspondiente
@Table(name="organizacion")
public class Organizacion /* implements Serializable */ {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="idorganizacion")
    private Long idorganizacion;

    @Getter @Setter @Column(name="cuit")
    private Long cuit;

    @Getter @Setter @Column(name="nombre")
    private String nombre;

    @Getter @Setter @Column(name="direccion")
    private String direccion;

    @Getter @Setter @Column(name="telefono")
    private Integer telefono;

    @Getter @Setter @Column(name="correo")
    private String correo;

    @Getter @Setter @Column(name="alta")
    private Date alta;

    @Getter @Setter @Column(name="activo")
    private Boolean activo;

    @Getter @Setter @Column(name="clave")
    private String clave;

    @OneToMany(mappedBy="organizacion")
    private Set<Evento> evento;

    /* Reemplazado por la anotación arriba de la clase @ToString
    @Override
    public String toString() {
        return "User [Id = " + idorganizacion + ", CUIT = " + cuit + ", Nombre = " + nombre + ", Dirección = " + direccion
                + ", Teléfono = " + telefono + ", Correo = " + correo + ", Alta = " + alta
                + ", Activo = " + activo + ", Clave = " + clave +  "]";
    } */

}
