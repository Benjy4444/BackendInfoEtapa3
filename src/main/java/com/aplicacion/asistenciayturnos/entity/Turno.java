package com.aplicacion.asistenciayturnos.entity;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Getter @Setter @Column(name="codigo")
    private String codigo;

    @Getter @Setter @Column(name="fecha")
    private Date fecha;

    @Getter @Setter @Column(name="hora")
    private LocalTime hora;

    @Getter @Setter @Column(name="activo")
    private Boolean activo;

    @Getter @Setter @Column(name="idevento")
    private Long idevento;

    @ManyToOne
    @JoinColumn(name = "idevento", insertable = false, updatable = false)
    private Evento evento;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Getter @Setter @Column(name="idusuario")
    private Long idusuario;

    @ManyToOne
    @JoinColumn(name = "idusuario", insertable = false, updatable = false)
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*
    @ManyToMany(mappedBy = "turnos")
    @JsonIgnore
    public List<Usuario> usuarios = new ArrayList<>();
    */

    /* Reemplazado por la anotación arriba de la clase @ToString
    @Override
    public String toString() {
        return "Turno [Id = " + idturno + ", Evento = " + idevento + ", Usuario = " + idusuario + ", Código = " + codigo + ", Fecha = " + fecha
                + ", Hora = " + hora + ", Activo = " + activo +  "]";
    } */

}