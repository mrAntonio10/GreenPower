package com.upb.upb.db.service;

import com.upb.upb.db.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();

    Long save(Usuario usuarioDto);
}
