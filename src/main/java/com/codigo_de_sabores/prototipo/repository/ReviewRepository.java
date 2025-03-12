package com.codigo_de_sabores.prototipo.repository;

import com.codigo_de_sabores.prototipo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Buscar todas as avaliações de uma receita específica
    List<Review> findByRecipeId(Long recipeId);

    // Buscar todas as avaliações de um degustador específico
    List<Review> findByTasterId(Long degustadorId);
}
