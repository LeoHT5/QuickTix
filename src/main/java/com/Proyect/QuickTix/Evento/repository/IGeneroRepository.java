package com.Proyect.QuickTix.Evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.QuickTix.Evento.models.Genero;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Integer> {

}
