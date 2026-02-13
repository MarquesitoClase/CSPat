package com.example.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Repositorios.UsuarioRepository;
import com.example.app.domain.Usuario;

import jakarta.validation.Valid;
import lombok.NonNull;
@Service
public class UsuarioServiceImplBD implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario añadir(@Valid @NonNull Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
