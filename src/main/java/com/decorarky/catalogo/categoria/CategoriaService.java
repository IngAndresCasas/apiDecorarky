package com.decorarky.catalogo.categoria;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaService {
    private final CategoriaRepo categoriaRepo;

    public CategoriaService (CategoriaRepo categoriaRepo){
        this.categoriaRepo = categoriaRepo;
    }

    public List<Categoria> listar(){ return categoriaRepo.findAll();}
    public Categoria listarPorId(Integer id){return categoriaRepo.findById(id).get();}
    public Categoria crear(Categoria cat){return  categoriaRepo.save(cat);}
    public  Categoria editar(Categoria categoria){ return categoriaRepo.save(categoria);}
    public void  eliminar(Integer id){categoriaRepo.deleteById(id);    }
}
