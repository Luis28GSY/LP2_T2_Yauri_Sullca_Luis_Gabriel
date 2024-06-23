package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpleadosEntity {

	@Id
	@Column(name = "dni_empleado",  length = 8,
			columnDefinition = "CHAR(8)")
	private String dniEmpleado;
	
	@Column(name = "nombre_empleado", nullable = true, length = 45)
	private String nombreEmpleado;
	
	@Column(name = "apellido_empleado", nullable = true, length = 45)
	private String apellidoEmpleado;
	
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "direccion", nullable = true, length = 45)
	private String direccion;
	
	@Column(name = "correo", nullable = true, length = 45, unique = true)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "area_id	", nullable = false)
	private AreaEntity areaentity;
	
}
