package com.Proyect.Quicktix.Venta.service;

import com.Proyect.Quicktix.Venta.models.Venta;

public interface IVentaService {

  public Venta registrar(Venta venta);

  public Venta obtenerVenta(Integer id);
}