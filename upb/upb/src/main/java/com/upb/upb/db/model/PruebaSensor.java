package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PRUEBA_SENSOR")
public class PruebaSensor implements Serializable {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String sensor;

    @Column(name = "MEDIDA")
    private Long medida;


//    @Column(name = "SENSOR_ID_HUMEDAD")
//    private Long idHumedad;
//
//    @Column(name = "SENSOR_ID_TEMPERATURA")
//    private Long idTemperatura;
//
//    @Column(name = "FECHA")
//    private Date fecha;



}
