package com.example.demo.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EmpleadosEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadosEntity, String>{

}
