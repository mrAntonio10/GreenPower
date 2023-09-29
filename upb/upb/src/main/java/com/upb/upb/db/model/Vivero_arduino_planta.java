package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VIVERO_ARDUINO_PLANTA")
public class Vivero_arduino_planta implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_VAP_ID_GENERATOR", sequenceName = "SEQ_VAP_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VAP_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_VIVERO", referencedColumnName = "id")
    private Vivero vivero;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_ARDUINO", referencedColumnName = "id")
    private Arduino Arduino;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_PLANTA", referencedColumnName = "id")
    private Planta planta;
}
