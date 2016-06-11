package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Alumno {
	@Id
	@SequenceGenerator(name = "Alumno_ID_GENERATOR", sequenceName = "Alumno_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Alumno_ID_GENERATOR")
	public Integer id;
	public String nombres;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public Integer promedio;

	public Alumno() {
	}

	public Alumno(String nombres, String apellidoPaterno, Integer promedio) {
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.promedio = promedio;
	}
}
