package com.ivan.dojosandninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ivan.dojosandninjas.models.Ninja;


@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();

	}


