package com.upb.upb.db.repository;

import com.upb.upb.db.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
@Query(" SELECT u FROM Usuario u " +
        " INNER JOIN FETCH u.vivero v" +
        " WHERE u.estado = false AND v.estado = false")
    public List<Usuario> findAllByEstadoFalse();
    Optional<Usuario> findByIdAndEstadoFalse(@Param("id") Long id);
}
