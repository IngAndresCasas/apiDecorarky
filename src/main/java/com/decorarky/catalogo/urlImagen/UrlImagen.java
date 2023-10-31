package com.decorarky.catalogo.urlImagen;

import com.decorarky.catalogo.producto.Producto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class UrlImagen {
    @Id
    private Integer id;
    private String url;
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}
