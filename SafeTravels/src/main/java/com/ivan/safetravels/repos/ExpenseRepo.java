package com.ivan.safetravels.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ivan.safetravels.models.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long> {
	
	List<Expense> findAll();

}
