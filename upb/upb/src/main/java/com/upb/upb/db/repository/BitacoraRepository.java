package com.upb.upb.db.repository;

import com.upb.upb.db.model.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BitacoraRepository extends JpaRepository<Bitacora, Long> {


    @Query("SELECT d " +
            " FROM Bitacora  d " +
            " WHERE d.id = :id_bitacora")
    Bitacora getById(@Param("id") Long id_bitacora);
}
