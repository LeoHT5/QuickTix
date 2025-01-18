package com.Proyect.Quicktix.Usuario.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.Quicktix.Usuario.models.Role;
import com.Proyect.Quicktix.Usuario.models.Usuario;
import com.Proyect.Quicktix.Usuario.repository.IUsuarioRepository;
import com.Proyect.Quicktix.Usuario.service.IUsuarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImplement implements IUsuarioService {

  @Autowired
  private IUsuarioRepository usuarioRepository;

  @Autowired
  private Usuario currentUser;

  @Override
  public List<Usuario> listarUsuario() {
    return usuarioRepository.findAll();
  }

  @Override
  public Usuario registrar(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  @Override
  public Usuario actualizar(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  @Override
  public Usuario obtener(Integer id) {
    return usuarioRepository.findById(id).get();
  }

  @Override
  public String eliminar(Integer id) {
    usuarioRepository.deleteById(id);
    return "Usuario eliminado";
  }

  @Override
  public Usuario autentificarUsuario(String correo, String password) {
    Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreo(correo);

    if (optionalUsuario.isPresent()) {
      Usuario usuario = optionalUsuario.get();

      if (password.equals(usuario.getPassword()) && Role.ADMIN.equals(usuario.getRole())) {
        currentUser = usuario;
        return usuario;
      }
    }
    return null;
  }

  @Override
  public boolean isAdmin() {
    if (currentUser != null) {
      System.out.println("currentUser: " + currentUser);
      System.out.println("Role: " + currentUser.getRole());
      return Role.ADMIN.equals(currentUser.getRole());
    }
    return false;
  }

}
