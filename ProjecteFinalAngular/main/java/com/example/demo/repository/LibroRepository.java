package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
	
	@Query("SELECT u FROM Libro u WHERE  u.titulo LIKE %:palabraClave% OR u.autor LIKE %:palabraClave%")
	List<Libro> buscarLibro(@Param("palabraClave") String palabraClave);
}
