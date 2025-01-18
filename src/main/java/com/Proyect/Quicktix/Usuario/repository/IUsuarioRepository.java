package com.Proyect.Quicktix.Usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.Quicktix.Usuario.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

  Optional<Usuario> findByCorreo(String correo);
}
