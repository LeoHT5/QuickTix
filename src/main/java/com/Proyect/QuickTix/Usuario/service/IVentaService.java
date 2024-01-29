package com.Proyect.QuickTix.Usuario.service;

import java.util.List;

import com.Proyect.QuickTix.Usuario.models.Venta;

public interface IVentaService {

  public List<Venta> listarVenta();

  public Venta registrar(Venta venta);

  public Venta obtenerVenta(Integer id);

  public String eliminar(Integer id);
}