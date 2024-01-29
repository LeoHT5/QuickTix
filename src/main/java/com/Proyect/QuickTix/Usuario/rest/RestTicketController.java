package com.Proyect.QuickTix.Usuario.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyect.QuickTix.Usuario.models.Venta;
import com.Proyect.QuickTix.Usuario.service.IVentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ticket")
public class RestTicketController {
    
    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<?> listaTicket(){
        List<Venta> ventas = ventaService.listarVenta();
        return new ResponseEntity<>(ventas, ventas.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtenerTicket(@PathVariable("id") Integer id){
        return new ResponseEntity<>(ventaService.obtenerVenta(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody Venta venta){
        Venta newVenta = ventaService.registrar(venta);
        return new ResponseEntity<Venta>(newVenta, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        ventaService.eliminar(id);
    }
    
}