package com.decorarky.catalogo.producto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Producto>> listaProducto(){
        return ResponseEntity.ok(productoService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Integer id){
        return ResponseEntity.ok(productoService.listarPorId(id));
    }
    @PostMapping("/")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Producto productoCreada = productoService.crear(producto);
        return ResponseEntity.ok(productoCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> editarProducto(@PathVariable Integer id, Producto producto){
        Producto productoExistente = productoService.listarPorId(id);

        if (producto.getNombre() != null && !producto.getNombre().isEmpty()){
            productoExistente.setNombre(producto.getNombre());
        }
        if (producto.getDescripcion() !=null && !producto.getDescripcion().isEmpty()){
            productoExistente.setDescripcion(producto.getDescripcion());
        }
        if (producto.getPrecio() >= 0){
            productoExistente.setPrecio(producto.getPrecio());
        }

        if (producto.isEstado() == true || producto.isEstado() == false){
            productoExistente.setEstado(producto.isEstado());
        }
        if (producto.getDimension() != null){
            productoExistente.setCategoria(producto.getCategoria());
        }

        if (producto.getDimension() != null){
            productoExistente.setDimension(producto.getDimension());
        }

        productoService.editar(productoExistente);
        return ResponseEntity.ok(productoExistente);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id){
        Producto productoEliminada =  productoService.listarPorId(id);
        productoService.eliminar(id);
        return ResponseEntity.ok(productoEliminada);
    }
}
