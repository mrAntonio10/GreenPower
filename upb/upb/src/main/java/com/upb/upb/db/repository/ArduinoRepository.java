package com.upb.upb.db.repository;

import com.upb.upb.db.model.Arduino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArduinoRepository extends JpaRepository<Arduino, Long> {
    List<Arduino> findAllByEstadoFalse();

    Optional<Arduino> findByIdAndEstadoFalse(@Param("id") Long id);
}
