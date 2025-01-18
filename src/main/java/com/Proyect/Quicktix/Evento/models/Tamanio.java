package com.Proyect.Quicktix.Evento.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_tamanio")
public class Tamanio implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "tamanio_id")
  private int id;

  @Column(name = "descripcion")
  @NotEmpty
  private String descripcion;
}
