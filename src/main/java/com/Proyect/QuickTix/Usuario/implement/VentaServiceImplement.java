package com.Proyect.QuickTix.Usuario.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.QuickTix.Usuario.models.Venta;
import com.Proyect.QuickTix.Usuario.repository.IVentaRepository;
import com.Proyect.QuickTix.Usuario.service.IVentaService;

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

  @Override
  public List<Venta> listarVenta() {
    return ventaRepository.findAll();
  }

  @Override
  public String eliminar(Integer id) {
    ventaRepository.deleteById(id);
    return "Ticket eliminado";
  }

}
