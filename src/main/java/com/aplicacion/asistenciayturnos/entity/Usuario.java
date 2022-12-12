package com.aplicacion.asistenciayturnos.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="usuario")
public class Usuario /* implements Serializable */ {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="idusuario")
    private Long idusuario;

    @Getter @Setter @Column(name="dni")
    private Long dni;

    @Getter @Setter @Column(name="nombre")
    private String nombre;

    @Getter @Setter @Column(name="apellido")
    private String apellido;

    @Getter @Setter @Column(name="direccion")
    private String direccion;

    @Getter @Setter @Column(name="telefono")
    private Long telefono;

    @Getter @Setter @Column(name="correo")
    private String correo;

    @Getter @Setter @Column(name="activo")
    private Boolean activo;

    @Getter @Setter @Column(name="clave")
    private String clave;

    @JoinTable(name = "usuario_turno",
            joinColumns = @JoinColumn(name = "idusuario", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "idturno",nullable = false))

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Turno> turnos = new ArrayList<>();

    @JsonIgnore
    public List<Turno> getTurnos() {
        return turnos;
    }
    @JsonIgnore
    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    /* Reemplazado por la anotación arriba de la clase @ToString
    @Override
    public String toString() {
        return "Usuario [Id = " + idusuario + ", DNI = " + dni + ", Nombre = " + nombre + ", Apellido = " + apellido + ", Dirección = " + direccion
                + ", Teléfono = " + telefono + ", Correo = " + correo + ", Activo = " + activo + ", Clave = " + clave +  "]";
    } */

}

