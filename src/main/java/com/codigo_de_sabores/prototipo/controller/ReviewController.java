package com.codigo_de_sabores.prototipo.controller;

import com.codigo_de_sabores.prototipo.model.Review;
import com.codigo_de_sabores.prototipo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    // Adicionar uma nova avaliação
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    // Atualizar uma avaliação existente
    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        return reviewService.updateReview(id, updatedReview);
    }

    // Remover uma avaliação por ID
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    // Buscar uma avaliação por ID
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    // Listar todas as avaliações
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
}