package com.codigo_de_sabores.prototipo.repository;

import com.codigo_de_sabores.prototipo.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    // Buscar ingredientes por nome
    Ingredient findByName(String name);
}
