package com.Proyect.Quicktix.Evento.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.Quicktix.Evento.DTO.EventoDTO;
import com.Proyect.Quicktix.Evento.models.Duracion;
import com.Proyect.Quicktix.Evento.models.Evento;
import com.Proyect.Quicktix.Evento.models.Genero;
import com.Proyect.Quicktix.Evento.models.Tamanio;
import com.Proyect.Quicktix.Evento.repository.IDuracionRepository;
import com.Proyect.Quicktix.Evento.repository.IEventoRepository;
import com.Proyect.Quicktix.Evento.repository.IGeneroRepository;
import com.Proyect.Quicktix.Evento.repository.ITamanioRepository;
import com.Proyect.Quicktix.Evento.service.IDuracionService;
import com.Proyect.Quicktix.Evento.service.IEventoService;
import com.Proyect.Quicktix.Evento.service.IGeneroService;
import com.Proyect.Quicktix.Evento.service.ITamanioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventoServiceImplement implements IEventoService, IDuracionService, IGeneroService, ITamanioService {

  @Autowired
  private IEventoRepository eventoRepository;

  @Autowired
  private IGeneroRepository generoRepository;

  @Autowired
  private IDuracionRepository duracionRepository;

  @Autowired
  private ITamanioRepository tamanioRepository;

  @Override
  public List<Evento> listar() {
    return eventoRepository.findAll();
  }

  @Override
  public Evento registar(Evento evento) {
    return eventoRepository.save(evento);
  }

  @Override
  public Evento actualizar(Evento evento) {
    return eventoRepository.save(evento);
  }

  @Override
  public Evento obtener(Integer id) {
    return eventoRepository.findById(id).get();
  }

  @Override
  public String eliminar(Integer id) {
    eventoRepository.deleteById(id);
    return "Evento eliminado";
  }

  @Override
  public List<Tamanio> listarTamanio() {
    return tamanioRepository.findAll();
  }

  @Override
  public List<Genero> listarGenero() {
    return generoRepository.findAll();
  }

  @Override
  public List<Duracion> listarDuracion() {
    return duracionRepository.findAll();
  }

  @Override
  public List<EventoDTO> listarNombre() {
    List<Evento> eventos = eventoRepository.findAll();
    return eventos.stream().map(evento -> new EventoDTO(evento.getId(), evento.getNombre()))
        .collect(Collectors.toList());
  }

}
