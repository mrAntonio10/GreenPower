package com.upb.upb.db.repository;

import com.upb.upb.db.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public List<Usuario> findAllByEstadoFalse();
}
