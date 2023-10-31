package com.decorarky.catalogo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

   public CategoriaController(CategoriaService categoriaService){
       this.categoriaService = categoriaService;
   }
    @GetMapping("")
   public ResponseEntity<List<Categoria>> listaCategorias(){
       return ResponseEntity.ok(categoriaService.listar());
   }
    @GetMapping("/{id}")
   public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Integer id){
       return ResponseEntity.ok(categoriaService.listarPorId(id));
   }
    @PostMapping("/")
   public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
       Categoria categoriaCreada = categoriaService.crear(categoria);
       return ResponseEntity.ok(categoriaCreada);
   }

    @PutMapping("/{id}")
   public ResponseEntity<Categoria> editarCategoria(@PathVariable Integer id, Categoria categoria){
       Categoria categoriaExistente = categoriaService.listarPorId(id);
       if (categoria.getNombre() != null && !categoria.getNombre().isEmpty()){
           categoriaExistente.setNombre(categoria.getNombre());
       }
       if (categoria.getDescripcion()==null && !categoria.getDescripcion().isEmpty()){
           categoriaExistente.setDescripcion(categoria.getDescripcion());
       }
       if (categoria.isEstado() == true || categoria.isEstado() == false){
           categoriaExistente.setEstado(categoria.isEstado());
       }
       categoriaService.editar(categoriaExistente);
       return ResponseEntity.ok(categoriaExistente);
   }
    @DeleteMapping("/{id}")
   public  ResponseEntity<Categoria> eliminarCategoria(@PathVariable Integer id){
       Categoria categoriaEliminada =  categoriaService.listarPorId(id);
       categoriaService.eliminar(id);
       return ResponseEntity.ok(categoriaEliminada);
   }

}
