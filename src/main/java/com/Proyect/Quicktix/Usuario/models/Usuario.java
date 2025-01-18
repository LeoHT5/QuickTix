package com.Proyect.Quicktix.Usuario.models;

import com.Proyect.Quicktix.Usuario.utils.RoleEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private int id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "apellido")
  private String apellido;

  @Column(name = "telefono")
  private String telefono;

  @Column(name = "correo", unique = true)
  @Email
  private String correo;

  @Column(name = "clave")
  private String password;

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private RoleEnums role;

  @Column(name = "estado")
  private boolean estado;

}
