package com.Proyect.QuickTix.Evento.service;

import java.util.List;

import com.Proyect.QuickTix.Evento.DTO.EventoDTO;
import com.Proyect.QuickTix.Evento.models.Evento;

public interface IEventoService {

  public List<Evento> listar();

  public List<EventoDTO> listarNombre();

  public Evento registar(Evento evento);

  public Evento actualizar(Evento evento);

  public Evento obtener(Integer id);

  public String eliminar(Integer id);

}
