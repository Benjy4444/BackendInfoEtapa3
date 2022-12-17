package com.aplicacion.asistenciayturnos.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;

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
    @javax.validation.constraints.NotNull (message = "El campo CUIT no puede ser vacío.")
    private Long cuit;

    @Getter @Setter @Column(name="nombre")
    @javax.validation.constraints.NotBlank (message = "El campo nombre no puede ser vacío.")
    //@Size(min = 1,max= 40, message = "El nombre debe tener entre 1 y 40 caracteres.")
    private String nombre;

    @Getter @Setter @Column(name="direccion")
    //@Size(min = 1,max= 40, message = "El nombre debe tener entre 1 y 40 caracteres.")
    //@javax.validation.constraints.NotNull (message = "El campo dirección no puede ser vacío.")
    private String direccion;

    @Getter @Setter @Column(name="telefono")
    //@Size(min = 0,max= 20, message = "El nombre debe tener entre 1 y 40 caracteres.")
    //@javax.validation.constraints.NotNull (message = "El campo teléfono no puede ser vacío.")
    private Integer telefono;

    @Getter @Setter @Column(name="correo")
    //@Size(min = 1,max= 255, message = "El nombre debe tener entre 1 y 40 caracteres.")
    //@javax.validation.constraints.NotNull (message = "El campo correo no puede ser vacío.")
    //@Email
    private String correo;

    @Getter @Setter @Column(name="alta")
    //@javax.validation.constraints.NotNull
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date alta;

    @Getter @Setter @Column(name="activo")
    //@javax.validation.constraints.NotNull
    //Aquí un 1 indica que la organizaciòn está activa, caso de ser 0 no está activa y equivale al borrado lógico
    private Boolean activo;

    @Getter @Setter @Column(name="clave")
    //@Size(min = 20,max= 40, message = "El nombre debe tener entre 1 y 40 caracteres.")
    //@javax.validation.constraints.NotNull (message = "El campo clave no puede ser vacío.")
    private String clave;

    @OneToMany(mappedBy="organizacion")
    private Set<Evento> evento;

    /* Reemplazado por la anotación arriba de la clase @ToString
    @Override
    public String toString() {
        return "Organización [Id = " + idorganizacion + ", CUIT = " + cuit + ", Nombre = " + nombre + ", Dirección = " + direccion
                + ", Teléfono = " + telefono + ", Correo = " + correo + ", Alta = " + alta
                + ", Activo = " + activo + ", Clave = " + clave +  "]";
    } */

}
