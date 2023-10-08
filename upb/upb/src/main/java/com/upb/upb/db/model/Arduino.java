package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ARDUINO")
public class Arduino implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_ARDUINO_ID_GENERATOR", sequenceName = "SEQ_ARDUINO_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ARDUINO_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "SENSOR_ACTUADOR")
    private String sensor_actuador;

    @Column(name = "PARAMETROMAX")
    private Float parametro;

    @Column(name = "PARAMETROMIN")
    private Float parametroMin;

    @Column(name = "ESTADO")
    private Boolean estado;

    @Column (name = "PIN")
    private Float pin;
}
