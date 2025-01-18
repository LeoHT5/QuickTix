package com.Proyect.Quicktix.Usuario.models;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private int id;

  @Column(name = "nombre")
  @NotEmpty
  @Pattern(regexp = "[a-zA-Z ]{3,100}")
  private String nombre;

  @Column(name = "apellido")
  @NotEmpty
  @Pattern(regexp = "[a-zA-Z ]{3,100}")
  private String apellido;

  @Column(name = "telefono")
  @NotEmpty
  @Pattern(regexp = "[0-9]{9}")
  private String telefono;

  @Column(name = "correo", unique = true)
  @NotEmpty
  @Email
  private String correo;

  @Column(name = "clave")
  @NotEmpty
  private String password;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  Role role;

}
