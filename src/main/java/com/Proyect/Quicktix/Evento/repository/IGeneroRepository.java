package com.Proyect.Quicktix.Evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.Quicktix.Evento.models.Genero;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Integer> {

}
