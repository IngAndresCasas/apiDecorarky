package com.decorarky.catalogo.dimension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimensionRepo extends JpaRepository<Dimension, Integer> {
}
