package com.Proyect.Quicktix.Venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.Quicktix.Venta.models.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {

}
