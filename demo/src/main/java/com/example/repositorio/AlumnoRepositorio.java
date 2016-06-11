package com.example.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Alumno;

public interface AlumnoRepositorio extends CrudRepository<Alumno, Integer> {
	List<Alumno> findAll();
}
