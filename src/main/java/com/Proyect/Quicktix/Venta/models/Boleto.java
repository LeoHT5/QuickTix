package com.Proyect.Quicktix.Venta.models;

import java.util.Date;

import com.Proyect.Quicktix.Venta.utils.EstadoEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "boleto")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private int idBoleto;

    @ManyToOne
    @JoinColumn(name = "id_detalle_venta")
    private DetalleVenta detalleVenta;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "fecha_generacion")
    private Date fechaGeneracion;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoEnums estadoEnums;

    @Column(name = "qr_codigo")
    private String qrCodigo;

}
