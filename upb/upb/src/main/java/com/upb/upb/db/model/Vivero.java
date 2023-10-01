package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VIVERO")
public class Vivero implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_VIVERO_ID_GENERATOR", sequenceName = "SEQ_VIVERO_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VIVERO_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "UBICACION")
    private String ubicacion;

    @Column(name = "ESTADO")
    private Boolean estado;

}
