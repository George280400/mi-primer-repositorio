package com.mx.Responsables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Responsables.Entity.Responsables;

@Repository
public interface IResponsableRepository extends JpaRepository<Responsables, Integer>{

}
