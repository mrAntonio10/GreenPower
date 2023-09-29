package com.upb.upb.db.repository;

import com.upb.upb.db.model.Vivero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ViveroRepository extends JpaRepository<Vivero, Long> {
    List<Vivero> findAllByEstadoFalse();
    Optional<Vivero> findByIdAndEstadoFalse(@Param("id") Long id);
}
