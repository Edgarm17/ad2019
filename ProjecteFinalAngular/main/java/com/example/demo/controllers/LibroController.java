package com.example.demo.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Libro;
import com.example.demo.repository.LibroRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {
	
	@Autowired
	private LibroRepository libroRepository;
	
	@GetMapping("/libros")
	public List<Libro> getAllLibros(){
		return libroRepository.findAll();
	}
	
	@GetMapping("/libros/{isbn}")
	public Libro getLibroById(@PathVariable(value = "isbn") int libroIsbn) throws ResourceNotFoundException{
		Libro libro = libroRepository.findById(libroIsbn)
				.orElseThrow(()-> new ResourceNotFoundException("Libro no encontrado para este isbn :"+libroIsbn));
		return libro;
	}
	
	@GetMapping("/libros/nombre/{nombre}")
	public List<Libro> getLibroByName(@PathVariable(value = "nombre")String nombre) throws ResourceNotFoundException{
		return libroRepository.buscarLibro(nombre);
	}
	
	@PostMapping("/libros")
	public Libro createLibro(@Valid  @RequestBody Libro libro) {
		return libroRepository.save(libro);
	}
	
	@PutMapping("/libros/{isbn}")
	public Libro updateLibro(@PathVariable(value = "isbn") int libroIsbn,
	@Valid @RequestBody Libro libroDetails) throws ResourceNotFoundException{
		Libro libro = libroRepository.findById(libroIsbn)
				.orElseThrow(()-> new ResourceNotFoundException("Libro no encontrado para este isbn :"+libroIsbn));
		
		libro.setAnyopublicacion(libroDetails.getAnyopublicacion());
		libro.setAutor(libroDetails.getAutor());
		libro.setEditorial(libroDetails.getEditorial());
		libro.setNumejemplares(libroDetails.getNumejemplares());
		libro.setNumpag(libroDetails.getNumpag());
		libro.setTitulo(libroDetails.getTitulo());
		final Libro updatedLibro = libroRepository.save(libro);
		return updatedLibro;
	}
	
	@DeleteMapping("/libros/{isbn}")
	public boolean deleteLibro(@PathVariable(value = "isbn") int libroIsbn) throws ResourceNotFoundException{
		Libro libro = libroRepository.findById(libroIsbn)
				.orElseThrow(()-> new ResourceNotFoundException("Libro no encontrado para este isbn :"+libroIsbn));
		libroRepository.delete(libro);
		return true;
	}

}
