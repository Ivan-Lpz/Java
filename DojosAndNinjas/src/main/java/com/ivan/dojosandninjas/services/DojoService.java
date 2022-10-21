package com.ivan.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.dojosandninjas.models.Dojo;
import com.ivan.dojosandninjas.repos.DojoRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo;

	// CREATE
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}

	// READ ALL
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}

	// READ ONE
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);

		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}

	}

	// UPDATE/EDIT
	public Dojo updateDojo(Dojo dojo) {
		Dojo updateDojo = dojoRepo.save(dojo);
		return updateDojo;

	}

	// DELETE
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}

}
