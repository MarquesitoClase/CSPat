package com.example.app.Services;

import com.example.app.domain.Usuario;

import jakarta.validation.Valid;

public interface UsuarioService {
    public Usuario añadir(@Valid Usuario usuario);
}
