package com.example.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Curso;

public interface CursoRepositorio extends CrudRepository<Curso, String> {
	List<Curso> findAll();
	Curso findByCodigo(String codigo);
}
