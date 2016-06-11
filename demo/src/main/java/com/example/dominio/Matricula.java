package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Matricula {
	@Id
	@SequenceGenerator(name = "Matricula_ID_GENERATOR", sequenceName = "Matricula_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Matricula_ID_GENERATOR")
	public Integer id;
	public Integer alumno_id;
	public Integer curso_id;
	public Matricula(){
		
	}
	public Matricula(Integer alumno_id, Integer curso_id) {
		this.alumno_id = alumno_id;
		this.curso_id = curso_id;
	}
}
