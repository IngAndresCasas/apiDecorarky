package com.decorarky.catalogo.urlImagen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlImagenRepo extends JpaRepository<UrlImagen, Integer> {
}
