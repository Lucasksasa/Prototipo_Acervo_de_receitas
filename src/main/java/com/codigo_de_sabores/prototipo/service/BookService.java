package com.codigo_de_sabores.prototipo.service;

import com.codigo_de_sabores.prototipo.model.Book;
import com.codigo_de_sabores.prototipo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
BookService, que será responsável por:

-Criar um livro com as receitas selecionadas pelo editor.
-Atualizar um livro existente.
-Remover um livro.
-Buscar um livro por ID ou listar todos os livros.

*/

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Cadastrar um novo livro
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Atualizar um livro existente
    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setRecipes(updatedBook.getRecipes());
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Livro não encontrado.");
        }
    }

    // Remover um livro por ID
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Livro não encontrado.");
        }
    }

    // Buscar um livro por ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Livro não encontrado."));
    }

    // Listar todos os livros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
