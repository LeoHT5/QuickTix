package com.Proyect.Quicktix.Evento.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_duracion")
public class Duracion {

  @Id
  @GeneratedValue
  @Column(name = "duracion_id")
  private int id;

  @NotEmpty
  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "estado")
  private boolean estado;
}
