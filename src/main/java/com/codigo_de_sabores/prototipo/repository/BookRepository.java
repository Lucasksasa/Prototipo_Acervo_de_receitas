package com.codigo_de_sabores.prototipo.repository;

import com.codigo_de_sabores.prototipo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    //Busca o livro por título
    Book findByTitle(String title);
}
