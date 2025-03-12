package com.codigo_de_sabores.prototipo.service;

import com.codigo_de_sabores.prototipo.model.Review;
import com.codigo_de_sabores.prototipo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
ReviewService, responsável por:

-Cadastrar uma avaliação (review) com nota e comentário.
-Atualizar uma avaliação existente.
-Remover uma avaliação.
-Buscar uma avaliação por ID ou listar todas as avaliações.
*/

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // Cadastrar uma nova avaliação
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Atualizar uma avaliação existente
    public Review updateReview(Long id, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepository.findById(id);

        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setRating(updatedReview.getRating());
            existingReview.setComment(updatedReview.getComment());
            return reviewRepository.save(existingReview);
        } else {
            throw new RuntimeException("Avaliação não encontrada.");
        }
    }

    // Remover uma avaliação por ID
    public void deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
        } else {
            throw new RuntimeException("Avaliação não encontrada.");
        }
    }

    // Buscar uma avaliação por ID
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Avaliação não encontrada."));
    }

    // Listar todas as avaliações
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}