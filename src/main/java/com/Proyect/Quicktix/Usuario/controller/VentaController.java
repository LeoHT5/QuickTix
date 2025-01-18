package com.Proyect.Quicktix.Usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Proyect.Quicktix.Evento.service.IEventoService;
import com.Proyect.Quicktix.Usuario.models.Venta;
import com.Proyect.Quicktix.Usuario.service.IVentaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class VentaController {

  @Autowired
  private IEventoService eventoService;

  @Autowired
  private IVentaService ventaService;

  @GetMapping("/venta/{id}")
  public String mostrarVenta(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("listaEvento", eventoService.listarNombre());

    if (id != null && id != 0) {
      model.addAttribute("venta", ventaService.obtenerVenta(id));
    } else {
      model.addAttribute("venta", new Venta());
    }

    return "layout/ticket";
  }

  @PostMapping("/venta")
  public String registrar(@Valid Venta venta, BindingResult result, Model model,
      RedirectAttributes attribute) {

    if (result.hasErrors()) {
      model.addAttribute("listaEvento", eventoService.listarNombre());
      System.out.println("Existen errores en el formulario");
      return "layout/ticket";
    }

    ventaService.registrar(venta);
    System.out.println("Venta Exitosa");

    model.addAttribute("venta", new Venta());

    attribute.addFlashAttribute("success", "Venta Exitosa");
    return "layout/ticket";
  }

}
