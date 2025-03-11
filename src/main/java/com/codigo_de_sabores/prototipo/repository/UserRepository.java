package com.codigo_de_sabores.prototipo.repository;

import com.codigo_de_sabores.prototipo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //Vou mudar isso mais pra frente, não é correto usar o nome e sim o Id
    User findByName(String name);
}
