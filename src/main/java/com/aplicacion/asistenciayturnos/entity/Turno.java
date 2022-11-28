package com.aplicacion.asistenciayturnos.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity

//Las siguientes anotaciones reemplazan a la creación de constructores
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@ToString

//La siguiente anotacion llama a la base de datos correspondiente
@Table(name="turno")
public class Turno /* implements Serializable */ {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="idturno")
    private Long idturno;

    @Getter @Setter @Column(name="idevento")
    private Long idevento;

    @Getter @Setter @Column(name="idusuario")
    private Long idusuario;

    @Getter @Setter @Column(name="codigo")
    private String codigo;

    @Getter @Setter @Column(name="fecha")
    private Date fecha;

    @Getter @Setter @Column(name="hora")
    private Time hora;

    @Getter @Setter @Column(name="activo")
    private Boolean activo;

    /*
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
    */
    ///----------------------------------------------

    /* Reemplazado por la anotación arriba de la clase @ToString
    @Override
    public String toString() {
        return "Turno [Id = " + idturno + ", Evento = " + idevento + ", Usuario = " + idusuario + ", Código = " + codigo + ", Fecha = " + fecha
                + ", Hora = " + hora + ", Activo = " + activo +  "]";
    } */

}