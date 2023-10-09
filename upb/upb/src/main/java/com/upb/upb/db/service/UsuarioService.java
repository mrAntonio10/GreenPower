package com.upb.upb.db.service;

import com.upb.upb.db.model.Usuario;
import com.upb.upb.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDto> findAllByIdVivero(Long id);

    Long save(Usuario usuarioDto);

    Boolean findByUsernameAndPassword(String nombre, String password);
}
