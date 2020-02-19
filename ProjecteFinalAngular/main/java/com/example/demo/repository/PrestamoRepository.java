package com.example.demo.repository;


import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, String>{
	
	
	@Query("SELECT u FROM Prestamo u WHERE  u.fprestamo LIKE %:palabraClave%")
	List<Prestamo> buscarPrestamo(@Param("palabraClave") String fprestamo);
}

