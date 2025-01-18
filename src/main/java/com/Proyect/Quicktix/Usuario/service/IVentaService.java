package com.Proyect.Quicktix.Usuario.service;

import com.Proyect.Quicktix.Usuario.models.Venta;

public interface IVentaService {

  public Venta registrar(Venta venta);

  public Venta obtenerVenta(Integer id);
}