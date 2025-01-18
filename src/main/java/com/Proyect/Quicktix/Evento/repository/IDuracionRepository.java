package com.Proyect.Quicktix.Evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.Quicktix.Evento.models.Duracion;

@Repository
public interface IDuracionRepository extends JpaRepository<Duracion, Integer> {

}
