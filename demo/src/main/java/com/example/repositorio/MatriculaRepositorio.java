package com.example.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Matricula;

public interface MatriculaRepositorio extends CrudRepository<Matricula, String> {
	List<Matricula> findAll();
	//Matricula findById(Integer id_matricula);
}
