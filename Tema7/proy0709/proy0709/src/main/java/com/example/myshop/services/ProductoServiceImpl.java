package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.Producto;
import com.example.myshop.repositories.CategoriaRepository;
import com.example.myshop.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
    //private List<Producto> repositorio = new ArrayList<>();
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public Producto añadir(Producto producto) {
        
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto editar(Producto producto) {
        return productoRepository.save(producto);
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    // @Override
    // public List<Producto> obtenerIdCategoria(Long idCategoria) {
    //     if (idCategoria==null) return null;  //throw exception
    //     List<Producto> productosCategoria = new ArrayList<>();
    //     for (Producto producto : productosCategoria) {
    //         if(producto.getIdCategoria()==idCategoria) productosCategoria.add(producto);
    //     }
    //     return productosCategoria;
    // }

    @Override
    public List<Producto> obtenerIdCategoria(Long idCategoria){
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        if(categoria==null) return null;
        else return productoRepository.findByCategoria(categoria);
    }


}
