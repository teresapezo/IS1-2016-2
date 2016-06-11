package com.example.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dominio.Alumno;
import com.example.dominio.Curso;
import com.example.dominio.Matricula;
import com.example.repositorio.AlumnoRepositorio;
import com.example.repositorio.CursoRepositorio;
import com.example.repositorio.MatriculaRepositorio;

@RestController
public class AcademicoControlador {
	@Autowired
	AlumnoRepositorio alumnoRepositorio;

	@Autowired
	CursoRepositorio cursoRepositorio;

	@Autowired
	MatriculaRepositorio matriculaRepositorio;
	
	@RequestMapping(value = "/alumnos", method = RequestMethod.POST)
	@ResponseBody
	public Alumno guardarAlumno(@RequestBody Alumno alumno){
		return alumnoRepositorio.save(alumno);
	}
	//@RequestMapping("/alumnos")
	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	@ResponseBody
	public List<Alumno> alumnos() {
		return alumnoRepositorio.findAll();
	}
	
	@RequestMapping(value = "/cursos", method = RequestMethod.POST)
	@ResponseBody
	public Curso guardarCurso(@RequestBody Curso curso) {
		return cursoRepositorio.save(curso);
	}

	//@RequestMapping("/cursos")
	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	@ResponseBody
	public List<Curso> cursos() {
		return cursoRepositorio.findAll();
	}

	@RequestMapping(value = "/matriculas", method = RequestMethod.POST)
	@ResponseBody
	public Matricula guardarMatricula(@RequestBody Matricula matricula){
		boolean flagC = false, flagA = false, flagM = false;
		List<Curso> Cursos = cursoRepositorio.findAll();
		List<Alumno> Alumnos = alumnoRepositorio.findAll();
		List<Matricula> Matriculas = matriculaRepositorio.findAll();
		for(Curso i : Cursos){
			if(Integer.parseInt(i.getCodigo()) == matricula.curso_id.intValue()){
				flagC = true;
				break;
			}
		}
		for(Alumno i : Alumnos){
			if(i.id.intValue() == matricula.alumno_id.intValue()){
				flagA = true;
				break;
			}
		}
		for(Matricula i : Matriculas){
			if(i.curso_id.intValue() == matricula.curso_id.intValue() && i.alumno_id.intValue() == matricula.alumno_id.intValue()){
				flagM = true;
				break;
			}
		}
		if(flagC && flagA && !flagM){
			return matriculaRepositorio.save(matricula);
		}
		return null;
		
	}
	@RequestMapping(value = "/matriculas", method = RequestMethod.GET)
	@ResponseBody
	public List<Matricula> matriculas(){
		return matriculaRepositorio.findAll();
	}
}
