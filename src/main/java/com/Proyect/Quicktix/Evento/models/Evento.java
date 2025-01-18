package com.Proyect.Quicktix.Evento.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_evento")
public class Evento implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "evento_id")
  private int id;

  @Column(name = "nombre")
  @Pattern(regexp = "[a-zA-Z ]{3,100}")
  private String nombre;

  @ManyToOne
  @JoinColumn(name = "genero_id", nullable = false)
  @NotNull
  private Genero genero;

  @ManyToOne
  @JoinColumn(name = "tamanio_id", nullable = false)
  @NotNull
  private Tamanio tamanio;

  @Column(name = "fecha")
  private String fecha;

  @Column(name = "hora")
  private String hora;

  @Column(name = "ubicacion")
  private String ubicacion;

  @ManyToOne
  @JoinColumn(name = "duracion_id", nullable = false)
  @NotNull
  private Duracion duracion;
}
