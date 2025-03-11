package com.codigo_de_sabores.prototipo.repository;

import com.codigo_de_sabores.prototipo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Serve para buscar receitas por nome

    Recipe findByName(String name);

}
