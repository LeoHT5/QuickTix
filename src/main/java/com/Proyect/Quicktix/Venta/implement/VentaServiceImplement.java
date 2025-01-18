package com.Proyect.Quicktix.Venta.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.Quicktix.Venta.models.Venta;
import com.Proyect.Quicktix.Venta.repository.IVentaRepository;
import com.Proyect.Quicktix.Venta.service.IVentaService;

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
