package com.mx.Tareas.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Tareas.Dominio.Tarea;

@Repository
public interface ITareaDao extends JpaRepository<Tarea, Integer>{

}
