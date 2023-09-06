package com.upb.upb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pruebaGreen")
public class Arduino implements Serializable {
    @Id
    @SequenceGenerator(name = "seqGenerator", sequenceName = "seq_gen_prueba", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    private Long id;

    @Column(name = "sensor", length = 50)
    private String sensor;
    @Column(name = "temperatura", length = 5)
    private Double temperatura;

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
}
