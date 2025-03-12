package com.codigo_de_sabores.prototipo.service;

import com.codigo_de_sabores.prototipo.model.Recipe;
import com.codigo_de_sabores.prototipo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
RecipeService, responsável por:

-Cadastrar receitas com os ingredientes.
-Atualizar receitas.
-Remover receitas.
-Buscar receitas por ID ou listar todas.
*/

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    // Cadastrar uma nova receita
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    // Atualizar uma receita existente
    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if (optionalRecipe.isPresent()) {
            Recipe existingRecipe = optionalRecipe.get();
            existingRecipe.setTitle(updatedRecipe.getTitle());
            existingRecipe.setIngredients(updatedRecipe.getIngredients());
            return recipeRepository.save(existingRecipe);
        } else {
            throw new RuntimeException("Receita não encontrada.");
        }
    }

    // Remover uma receita por ID
    public void deleteRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Receita não encontrada.");
        }
    }

    // Buscar uma receita por ID
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Receita não encontrada."));
    }

    // Listar todas as receitas
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}