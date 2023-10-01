package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PLANTA")
public class Planta implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_PLANTA_ID_GENERATOR", sequenceName = "SEQ_PLANTA_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANTA_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CARACTERISTICA")
    private String caracteristica;

    @Column(name = "ESTADO")
    private Boolean estado;
}
