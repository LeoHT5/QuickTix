package com.Proyect.Quicktix.Venta.models;

import java.util.Date;

import com.Proyect.Quicktix.Evento.models.Evento;
import com.Proyect.Quicktix.Usuario.models.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_Venta")
public class Venta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_venta")
  private int idVenta;

  @Column(name = "nombreCompleto")
  private String nombre;

  @Column(name = "correo")
  private String correo;

  @Column(name = "fecha_venta")
  private Date fecha_venta;

  @Column(name = "tipo")
  private String tipo;

  @Column(name = "cantidad")
  protected int cantidad;

  @Column(name = "metodo_pago")
  private String metodo_pago;

  @ManyToOne
  @JoinColumn(name = "evento_id")
  private Evento evento;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

}
