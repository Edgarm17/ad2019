package com.example.demo.controllers;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Socio;
import com.example.demo.repository.SocioRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SocioController {
	
	@Autowired
	private SocioRepository socioRepository;
	
	@GetMapping("/socios")
	public List<Socio> getAllSocios(){
		return socioRepository.findAll();
	}
	
	@GetMapping("/socios/{numsocio}")
	public Socio getSocioById(@PathVariable(value = "numsocio") int socioId) throws ResourceNotFoundException{
		Socio socio = socioRepository.findById(socioId)
				.orElseThrow(()-> new ResourceNotFoundException("Socio no encontrado para este numsocio :"+socioId));
		return socio;
	}
	
	@GetMapping("/socios/nombre/{nombre}")
	public List<Socio> getSocioByName(@PathVariable(value = "nombre")String nombre) throws ResourceNotFoundException{
		return socioRepository.buscarSocio(nombre);
	}
	
	@PostMapping("/socios")
	public Socio createSocio(@Valid  @RequestBody Socio socio) {
		return socioRepository.save(socio);
	}
	
	@PutMapping("/socios/{numsocio}")
	public Socio updateSocio(@PathVariable(value = "numsocio") int socioId,
	@Valid @RequestBody Socio socioDetails) throws ResourceNotFoundException{
		Socio socio = socioRepository.findById(socioId)
				.orElseThrow(()-> new ResourceNotFoundException("Socio no encontrado para este numsocio :"+socioId));
		
		socio.setApellidos(socioDetails.getApellidos());
		socio.setEdad(socioDetails.getEdad());
		socio.setFalta(socioDetails.getFalta());
		socio.setNombre(socioDetails.getNombre());
		socio.setTelefono(socioDetails.getTelefono());
		
		final Socio updatedSocio = socioRepository.save(socio);
		return updatedSocio;
	}
	
	@DeleteMapping("/socios/{numsocio}")
	public boolean deleteSocio(@PathVariable(value = "numsocio") int socioId) throws ResourceNotFoundException{
		Socio socio = socioRepository.findById(socioId)
				.orElseThrow(()-> new ResourceNotFoundException("Socio no encontrado para este numsocio :"+socioId));
		socioRepository.delete(socio);
		return true;
	}

}