package com.Proyect.Quicktix.Usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Proyect.Quicktix.Usuario.models.Usuario;
import com.Proyect.Quicktix.Usuario.service.IUsuarioService;
import com.Proyect.Quicktix.Usuario.utils.RoleEnums;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UsuarioController {

  @Autowired
  private IUsuarioService usuarioService;

  @Autowired
  private Usuario usuario;

  @GetMapping("/indexAdmin")
  public String indexAdmin() {
    return "layout/administrador/home_admin";
  }

  @GetMapping("/index")
  public String index() {
    return "layout/index";
  }

  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("usuario", new Usuario());
    usuario.setRole(RoleEnums.ADMIN);
    return "layout/login";
  }

  @GetMapping("/registrar/{id}")
  public String mostrarUsuario(@PathVariable("id") Integer id, Model model) {

    if (id != null && id != 0) {
      model.addAttribute("usuario", usuarioService.obtener(id));
    } else {
      usuario.setRole(RoleEnums.USER);
      model.addAttribute("usuario", new Usuario());
    }
    return "layout/registrar";
  }

  @PostMapping("/registrarUsuario")
  public String registrarModificarUsuario(@Valid Usuario usuario, BindingResult result, Model model,
      RedirectAttributes attribute) {

    usuarioService.registrar(usuario);
    System.out.println("Usuario guardada con exito");
    attribute.addFlashAttribute("success", "Usuario guardada con exito");
    return "redirect:/login";
  }

  @PostMapping("/sesion")
  public String login(@RequestParam String correo, @RequestParam String password, Model model) {

    Usuario usuario = usuarioService.autentificarUsuario(correo, password);

    if (usuario != null) {
      model.addAttribute("usuario", usuario);
      if (usuarioService.isAdmin()) {
        return "redirect:/indexAdmin";
      } else {
        return "redirect:/index";
      }
    } else {
      model.addAttribute("error", "Credenciales incorrectas");
      model.addAttribute("usuario", new Usuario());
      return "redirect:/login";
    }
  }
}
