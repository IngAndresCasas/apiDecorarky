package com.decorarky.catalogo.categoria;

import com.decorarky.catalogo.producto.Producto;

import lombok.*;



import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private boolean estado;
    @OneToMany(mappedBy = "categoria")
    private List<Producto> producto;
}
