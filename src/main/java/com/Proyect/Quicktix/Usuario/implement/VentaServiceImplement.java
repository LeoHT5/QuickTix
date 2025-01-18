package com.Proyect.Quicktix.Usuario.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.Quicktix.Usuario.models.Venta;
import com.Proyect.Quicktix.Usuario.repository.IVentaRepository;
import com.Proyect.Quicktix.Usuario.service.IVentaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VentaServiceImplement implements IVentaService {

  @Autowired
  private IVentaRepository ventaRepository;

  @Override
  public Venta registrar(Venta venta) {
    return ventaRepository.save(venta);
  }

  @Override
  public Venta obtenerVenta(Integer id) {
    return ventaRepository.findById(id).get();
  }

}
