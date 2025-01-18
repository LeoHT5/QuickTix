package com.Proyect.Quicktix.Usuario.models;

import java.io.Serializable;

import com.Proyect.Quicktix.Evento.models.Evento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_Venta")
public class Venta implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private int id;

  @Column(name = "nombreCompleto")
  @NotEmpty
  @Pattern(regexp = "[a-zA-Z ]{3,100}")
  private String nombre;

  @Column(name = "correo")
  @NotEmpty
  @Email
  private String correo;

  @Column(name = "telefono")
  @NotEmpty
  @Pattern(regexp = "[0-9]{9}")
  private String telefono;

  @Column(name = "tipo")
  @NotEmpty
  private String tipo;

  @Column(name = "cantidad")
  // @NotEmpty
  // @Pattern(regexp = "[0-9]{1,2}")
  protected int cantidad;

  @ManyToOne
  @JoinColumn(name = "evento_id", nullable = false)
  @NotNull
  private Evento evento;

}
