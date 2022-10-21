package com.ivan.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.dojosandninjas.models.Ninja;
import com.ivan.dojosandninjas.repos.NinjaRepo;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepo ninjaRepo;

	// CREATE
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	// READ ALL
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}

	// READ ONE
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);

		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}

	}

	// UPDATE/EDIT
	public Ninja updateNinja(Ninja ninja) {
		Ninja updateNinja = ninjaRepo.save(ninja);
		return updateNinja;

	}

	// DELETE
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}

}
