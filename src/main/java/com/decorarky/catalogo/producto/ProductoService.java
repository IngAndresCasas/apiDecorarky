package com.decorarky.catalogo.producto;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService {
    private final ProductoRepo productoRepo;

    public ProductoService (ProductoRepo productoRepo){
        this.productoRepo = productoRepo;
    }

    public List<Producto> listar(){ return productoRepo.findAll();}
    public Producto listarPorId(Integer id){return productoRepo.findById(id).get();}
    public Producto crear(Producto prod){return  productoRepo.save(prod);}
    public  Producto editar(Producto producto){ return productoRepo.save(producto);}
    public void  eliminar(Integer id){productoRepo.deleteById(id);    }
}
