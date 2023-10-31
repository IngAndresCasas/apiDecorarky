package com.decorarky.catalogo.urlImagen;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/urlImagen")
public class UrlImagenController {
    private final UrlImagenService urlImagenService;

    public UrlImagenController(UrlImagenService urlImagenService){
        this.urlImagenService = urlImagenService;
    }



    @GetMapping("")
    public ResponseEntity<List<UrlImagen>> listaUrlImagen(){
        return ResponseEntity.ok(urlImagenService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UrlImagen> buscarUrlImagenPorId(@PathVariable Integer id){
        return ResponseEntity.ok(urlImagenService.listarPorId(id));
    }
    @PostMapping("/")
    public ResponseEntity<UrlImagen> crearUrlImagen(@RequestBody UrlImagen urlImagen){
        UrlImagen urlImagenCreada = urlImagenService.crear(urlImagen);
        return ResponseEntity.ok(urlImagenCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UrlImagen> editarUrlImagen(@PathVariable Integer id, UrlImagen urlImagen){
        UrlImagen urlImagenExistente = urlImagenService.listarPorId(id);
        if (urlImagen.getUrl() != null && !urlImagen.getUrl().isEmpty()){
            urlImagenExistente.setUrl(urlImagen.getUrl());
        }

        if (urlImagen.isEstado() == true || urlImagen.isEstado() == false){
            urlImagenExistente.setEstado(urlImagen.isEstado());
        }
        urlImagenService.editar(urlImagenExistente);
        return ResponseEntity.ok(urlImagenExistente);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<UrlImagen> eliminarurlImagen(@PathVariable Integer id){
        UrlImagen urlImagenEliminada =  urlImagenService.listarPorId(id);
        urlImagenService.eliminar(id);
        return ResponseEntity.ok(urlImagenEliminada);
    }
}
