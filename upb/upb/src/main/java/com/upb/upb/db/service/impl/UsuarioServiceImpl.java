package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Usuario;
import com.upb.upb.db.model.Vivero;
import com.upb.upb.db.repository.UsuarioRepository;
import com.upb.upb.db.repository.ViveroRepository;
import com.upb.upb.db.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ViveroRepository viveroRepository;

    @Override
    public List<Usuario> findAll() {
            List<Usuario> respuesta = usuarioRepository.findAllByEstadoFalse();
            return  respuesta;
    }

    @Override
    @Transactional
    public Long save(Usuario usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setId(null);
        usuario.setRol(usuarioDto.getRol());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setNombreCompleto(usuarioDto.getNombreCompleto());
        usuario.setEstado(usuarioDto.getEstado());

        Optional<Vivero> viveroOpt = viveroRepository.findByIdAndEstadoFalse(usuarioDto.getVivero().getId());
        if(viveroOpt.isPresent()){  //usuario con vivero
            usuario.setVivero(viveroOpt.get());
        }
        usuario = usuarioRepository.save(usuario);
        return usuario.getId();
    }
}
