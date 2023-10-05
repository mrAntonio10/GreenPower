package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VIVERO_ARDUINO_PLANTA",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ARDUINO", "ID_PLANTA"})
)
public class Vivero_arduino_planta implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_VAP_ID_GENERATOR", sequenceName = "SEQ_VAP_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VAP_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "ID_VIVERO", referencedColumnName = "id")
    private Vivero vivero;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "ID_ARDUINO", referencedColumnName = "id")
    private Arduino arduino;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "ID_PLANTA", referencedColumnName = "id")
    private Planta planta;
}
