package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BITACORA")
public class Bitacora implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_BITACORA_ID_GENERATOR", sequenceName = "SEQ_BITACORA_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BITACORA_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "USUARIO")
    private String user;


}
