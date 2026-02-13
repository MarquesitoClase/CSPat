package com.example.myshop.services;

import java.util.List;


import com.example.myshop.domain.Producto;


public interface ProductoService {
    Producto añadir(Producto producto);

    List<Producto> obtenerTodos();

    Producto obtenerPorId(long id);

    Producto editar(Producto producto);

    void delete(Long id);

    public List<Producto>  obtenerIdCategoria(Long idCategoria);

}
