package com.upb.upb.db.repository;

import com.upb.upb.db.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public List<Usuario> findAllByEstadoFalse();
    Optional<Usuario> findByIdAndEstadoFalse(@Param("id") Long id);
}
