package com.decorarky.catalogo.dimension;

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
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double ancho;
    private double largo;
    private double alto;
    private boolean estado;
    @OneToMany(mappedBy = "dimension")
    private List<Producto> productos;
}
