package com.Proyect.Quicktix.Evento.models;

import java.util.Date;

import com.Proyect.Quicktix.Evento.utils.PedidoEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_evento")
public class Evento {

  @Id
  @GeneratedValue
  @Column(name = "id_evento")
  private int id_evento;

  @Column(name = "nombre")
  private String nombre;

  @Column
  private String descripcion;

  @Column(name = "fecha")
  private Date fecha;

  @Column(name = "hora")
  private Date hora;

  @Column(name = "precio")
  private double precioBase;

  @Column(name = "estado")
  @Enumerated(EnumType.STRING)
  private PedidoEnums estado;

  @Column(name = "ubicacion")
  private String ubicacion;

  @Column(name = "capacidad")
  private int capacidadTotal;

  @Column(name = "fecha_fin_venta")
  private Date fechaInicioVenta;

  @Column(name = "fecha_fin_venta")
  private Date fechaFinVenta;

  @ManyToOne
  @JoinColumn(name = "duracion_id", nullable = false)
  @NotNull
  private Duracion duracion;

  @ManyToOne
  @JoinColumn(name = "genero_id", nullable = false)
  @NotNull
  private Genero genero;

  @ManyToOne
  @JoinColumn(name = "tamanio_id", nullable = false)
  @NotNull
  private Tamanio tamanio;

}
