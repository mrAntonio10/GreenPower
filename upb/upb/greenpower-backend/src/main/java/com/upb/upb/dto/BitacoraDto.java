package com.upb.upb.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BitacoraDto {
    private Long id;
    private String user;
    private Long idHumedad;
    private Long idTemperatura;
    private Date fecha;
}
