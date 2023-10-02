package com.upb.upb.db.repository;

import com.upb.upb.db.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlantaRepository extends JpaRepository<Planta, Long> {
    List<Planta> findAllByEstadoFalse();

    Optional<Planta> findByIdAndEstadoFalse(@Param("id") Long id);
}
