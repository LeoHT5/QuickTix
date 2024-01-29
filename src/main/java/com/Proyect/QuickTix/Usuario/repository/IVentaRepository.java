package com.Proyect.QuickTix.Usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.QuickTix.Usuario.models.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {

}
