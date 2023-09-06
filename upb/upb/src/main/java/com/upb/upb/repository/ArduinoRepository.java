package com.upb.upb.repository;

import com.upb.upb.model.Arduino;
import com.upb.upb.model.dto.ArduinoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArduinoRepository extends JpaRepository<Arduino, Long> {

}
