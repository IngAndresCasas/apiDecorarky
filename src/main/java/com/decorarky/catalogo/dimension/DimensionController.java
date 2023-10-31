package com.decorarky.catalogo.dimension;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/dimension")
public class DimensionController {
    private final DimensionService dimensionService;

    public DimensionController(DimensionService dimensionService){
        this.dimensionService = dimensionService;
    }



    @GetMapping("")
    public ResponseEntity<List<Dimension>> listaDimension(){
        return ResponseEntity.ok(dimensionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dimension> buscarDimensionPorId(@PathVariable Integer id){
        return ResponseEntity.ok(dimensionService.listarPorId(id));
    }
    @PostMapping("/")
    public ResponseEntity<Dimension> crearDimension(@RequestBody Dimension dimension){
        Dimension dimensionCreada = dimensionService.crear(dimension);
        return ResponseEntity.ok(dimensionCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dimension> editarDimension(@PathVariable Integer id, Dimension dimension){
        Dimension dimensionExistente = dimensionService.listarPorId(id);

        if ( dimension.getAncho() > 0 ){
            dimensionExistente.setAncho(dimension.getAncho());
        }
        if (dimension.getAlto() > 0){
            dimensionExistente.setAlto(dimension.getAlto());
        }
        if (dimension.getLargo() > 0 ){
            dimensionExistente.setLargo(dimension.getLargo());
        }
        if (dimension.isEstado() == true || dimension.isEstado() == false){
            dimensionExistente.setEstado(dimension.isEstado());
        }
        dimensionService.editar(dimensionExistente);
        return ResponseEntity.ok(dimensionExistente);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Dimension> eliminarDimension(@PathVariable Integer id){
        Dimension dimensionEliminada =  dimensionService.listarPorId(id);
        dimensionService.eliminar(id);
        return ResponseEntity.ok(dimensionEliminada);
    }
}
