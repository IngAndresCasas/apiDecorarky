package com.decorarky.catalogo.urlImagen;

import com.decorarky.catalogo.categoria.Categoria;
import com.decorarky.catalogo.categoria.CategoriaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UrlImagenService {
    private final UrlImagenRepo urlImagenRepo;

    public UrlImagenService (UrlImagenRepo urlImagenRepo){
        this.urlImagenRepo = urlImagenRepo;
    }

    public List<UrlImagen> listar(){ return urlImagenRepo.findAll();}
    public UrlImagen listarPorId(Integer id){return urlImagenRepo.findById(id).get();}
    public UrlImagen crear(UrlImagen urlimg){return  urlImagenRepo.save(urlimg);}
    public  UrlImagen editar(UrlImagen urlImagen){ return urlImagenRepo.save(urlImagen);}
    public void  eliminar(Integer id){urlImagenRepo.deleteById(id);    }
}
