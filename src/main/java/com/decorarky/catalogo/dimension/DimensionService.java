package com.decorarky.catalogo.dimension;

import com.decorarky.catalogo.categoria.Categoria;
import com.decorarky.catalogo.categoria.CategoriaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DimensionService {
    private final DimensionRepo dimensionRepo;

    public DimensionService (DimensionRepo dimensionRepo){
        this.dimensionRepo = dimensionRepo;
    }

    public List<Dimension> listar(){ return dimensionRepo.findAll();}
    public Dimension listarPorId(Integer id){return dimensionRepo.findById(id).get();}
    public Dimension crear(Dimension cat){return  dimensionRepo.save(cat);}
    public  Dimension editar(Dimension dimension){ return dimensionRepo.save(dimension);}
    public void  eliminar(Integer id){dimensionRepo.deleteById(id);    }
}
