package com.decorarky.catalogo.producto;

import com.decorarky.catalogo.categoria.Categoria;
import com.decorarky.catalogo.dimension.Dimension;
import com.decorarky.catalogo.urlImagen.UrlImagen;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Producto {
    @Id
    private Integer codigo;
    private String referencia; 
    private  String nombre;
    private String descripcion;
    private double precio;
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private Date creado;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion",updatable = true)
    private Date actualizacion;

    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "dimension_id", nullable = false)
    private Dimension dimension;

    @OneToMany (mappedBy = "producto")
    private List<UrlImagen> urlImagens;
}
