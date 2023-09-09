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
@Table(name = "BITACORA")
public class Bitacora implements Serializable {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "USUARIO")
    private String user;

//    @Column(name = "SENSOR_ID_HUMEDAD")
//    private Long idHumedad;
//
//    @Column(name = "SENSOR_ID_TEMPERATURA")
//    private Long idTemperatura;
//
//    @Column(name = "FECHA")
//    private Date fecha;



}
