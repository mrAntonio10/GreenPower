package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_USUARIO_ID_GENERATOR", sequenceName = "SEQ_USUARIO_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "ROL")
    private Long rol;

    @Column(name = "ESTADO")
    private Boolean estado;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "ID_VIVERO", referencedColumnName = "id")
    private Vivero vivero;
}
