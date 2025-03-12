package com.codigo_de_sabores.prototipo.service;

import com.codigo_de_sabores.prototipo.model.User;
import com.codigo_de_sabores.prototipo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Cadastrar um novo usuário
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Atualizar um usuário existente
    public User updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setRole(updatedUser.getRole());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    // Remover um usuário por ID
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    // Buscar um usuário por ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado."));
    }

    // Listar todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

