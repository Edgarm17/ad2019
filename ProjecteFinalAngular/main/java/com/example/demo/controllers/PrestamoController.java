package com.example.demo.controllers;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Prestamo;
import com.example.demo.repository.PrestamoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PrestamoController {
	
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@GetMapping("/prestamos")
	public List<Prestamo> getAllPrestamos(){
		return prestamoRepository.findAll();
	}
	
	@GetMapping("/prestamos/{fprestamo}")
	public Prestamo getPrestamoById(@PathVariable(value = "fprestamo") String prestamoFecha) throws ResourceNotFoundException{
		Prestamo prestamo = prestamoRepository.findById(prestamoFecha)
				.orElseThrow(()-> new ResourceNotFoundException("Prestamo no encontrado para este fprestamo :"+prestamoFecha));
		return prestamo;
	}
	
	@GetMapping("/prestamos/fechas/{fprestamo}")
	public List<Prestamo> getPrestamoByFecha(@PathVariable(value = "fprestamo")String fecha) throws ResourceNotFoundException{
		return prestamoRepository.buscarPrestamo(fecha);
	}
	
	@PostMapping("/prestamos")
	public Prestamo createPrestamo(@Valid  @RequestBody Prestamo prestamo) {
		return prestamoRepository.save(prestamo);
	}
	
	@PutMapping("/prestamos/{fprestamo}")
	public Prestamo updatePrestamo(@PathVariable(value = "fprestamo") String prestamoFecha,
	@Valid @RequestBody Prestamo prestamoDetails) throws ResourceNotFoundException{
		Prestamo prestamo = prestamoRepository.findById(prestamoFecha)
				.orElseThrow(()-> new ResourceNotFoundException("Prestamo no encontrado para este fprestamo :"+prestamoFecha));
		
		prestamo.setFdevolucion(prestamoDetails.getFdevolucion());
		prestamo.setLibro(prestamoDetails.getLibro());
		prestamo.setSocio(prestamoDetails.getSocio());
		
		
		
		final Prestamo updatedPrestamo = prestamoRepository.save(prestamo);
		return updatedPrestamo;
	}
	
	@DeleteMapping("/prestamos/{fprestamo}")
	public boolean deletePrestamo(@PathVariable(value = "fprestamo") String prestamoFecha) throws ResourceNotFoundException{
		Prestamo prestamo = prestamoRepository.findById(prestamoFecha)
				.orElseThrow(()-> new ResourceNotFoundException("Prestamo no encontrado para este fprestamo :"+prestamoFecha));
		prestamoRepository.delete(prestamo);
		return true;
	}

}
