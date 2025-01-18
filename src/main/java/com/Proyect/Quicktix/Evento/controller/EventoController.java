package com.Proyect.Quicktix.Evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Proyect.Quicktix.Evento.models.Evento;
import com.Proyect.Quicktix.Evento.service.IDuracionService;
import com.Proyect.Quicktix.Evento.service.IEventoService;
import com.Proyect.Quicktix.Evento.service.IGeneroService;
import com.Proyect.Quicktix.Evento.service.ITamanioService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EventoController {

  @Autowired
  private IEventoService eventoService;

  @Autowired
  private IGeneroService generoService;

  @Autowired
  private IDuracionService duracionService;

  @Autowired
  private ITamanioService tamanioService;

  @RequestMapping("/evento")
  public String lista(Model model) {
    model.addAttribute("listaEvento", eventoService.listar());
    return "layout/administrador/evento/listarEvento";
  }

  @GetMapping("/registrarEvento/{id}")
  public String mostrar(@PathVariable("id") Integer id, Model model) {

    model.addAttribute("listaGenero", generoService.listarGenero());
    model.addAttribute("listaTamanio", tamanioService.listarTamanio());
    model.addAttribute("listaDuracion", duracionService.listarDuracion());

    if (id != null && id != 0) {
      model.addAttribute("evento", eventoService.obtener(id));
    } else {
      model.addAttribute("evento", new Evento());
    }
    return "layout/administrador/evento/crearEvento";
  }

  @PostMapping("/registrarEvento")
  public String registrar(@Valid Evento evento, BindingResult result, Model model,
      RedirectAttributes attribute) {

    if (result.hasErrors()) {
      model.addAttribute("listaGenero", generoService.listarGenero());
      model.addAttribute("listaTamanio", tamanioService.listarTamanio());
      model.addAttribute("listaDuracion", duracionService.listarDuracion());
      System.out.println("Existen errores en el formulario");
      return "layout/administrador/evento/crearEvento";
    }

    eventoService.registar(evento);
    System.out.println("Evento guardada con exito");
    attribute.addFlashAttribute("success", "Evento guardada con exito");
    return "redirect:/evento";
  }

  @GetMapping("/eliminarEvento/{id}")
  public String eliminarAlumno(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {
    eventoService.eliminar(id);
    System.out.println("Evento elimnado con exito");
    attribute.addAttribute("warning", "Evento elminado con exito");
    return "redirect:/evento";
  }

}
