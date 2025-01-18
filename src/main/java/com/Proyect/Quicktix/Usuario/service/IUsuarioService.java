package com.Proyect.Quicktix.Usuario.service;

import java.util.List;

import com.Proyect.Quicktix.Usuario.models.Usuario;

public interface IUsuarioService {

  public List<Usuario> listarUsuario();

  public Usuario registrar(Usuario usuario);

  public Usuario actualizar(Usuario usuario);

  public Usuario obtener(Integer id);

  public String eliminar(Integer id);

  Usuario autentificarUsuario(String correo, String password);

  public boolean isAdmin();
}
