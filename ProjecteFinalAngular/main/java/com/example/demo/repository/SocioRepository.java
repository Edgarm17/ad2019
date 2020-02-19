package com.example.demo.repository;


import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Socio;

public interface SocioRepository extends JpaRepository<Socio, Integer>{
	
	@Query("SELECT u FROM Socio u WHERE  u.nombre LIKE %:palabraClave% OR u.apellidos LIKE %:palabraClave%")
	List<Socio> buscarSocio(@Param("palabraClave") String nombreApellido);
}