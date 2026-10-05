package com.uc.ms_security.repository;

import com.uc.ms_security.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    @EntityGraph(attributePaths = {"profile"})
    Optional<User> findWithProfileById(Long id); //with funciona como un join fetch, trae el perfil del usuario si se solicita

    @EntityGraph(attributePaths = {"sessions"})
    Optional<User> findWithSessionsById(Long id); //with funciona como un join fetch, trae las sesiones del usuario si se solicita
}



