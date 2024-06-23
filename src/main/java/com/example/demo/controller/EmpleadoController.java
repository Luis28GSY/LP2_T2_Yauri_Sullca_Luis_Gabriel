package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Interface.AreaRepository;
import com.example.demo.Interface.EmpleadoRepository;
import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadosEntity;

@Controller
public class EmpleadoController {

	@Autowired
	private AreaRepository arearepository;
	
	@Autowired
	private EmpleadoRepository empleadorepository;
	
	@GetMapping("/lista")
	public String homeLista(Model model) {
		
		List<EmpleadosEntity> empleados = empleadorepository.findAll();
		
		model.addAttribute("lst_empleados", empleados);
		
		return "home_lista";
	}
	
	@GetMapping("/registrar_empleado")
	public String ViewRegistrarEmpleado(Model model) {
		
		List<AreaEntity> listaAreas = arearepository.findAll();
		
		model.addAttribute("lista_areas", listaAreas);
		
		model.addAttribute("emp", new EmpleadosEntity());
			
		return "registrar_empleado";
		
	}
	
	@PostMapping("/registrar_empleado")
	public String RegistrarEmpleado(Model model, @ModelAttribute EmpleadosEntity empleado) {
		
		empleadorepository.save(empleado);
		
		return "redirect:/lista";
		
	}
	
	@GetMapping("/editar_empleado/{idYauri}")
	public String ViewActualizar(Model model, @PathVariable("idYauri")String id) {
		
		EmpleadosEntity empleado = empleadorepository.findById(id).get();
		
		List<AreaEntity> listaAreas = arearepository.findAll();
		
		model.addAttribute("lista_areas", listaAreas);
		
		model.addAttribute("emp", empleado);
		
		return "actualizar_empleado";
		 
	}

}
