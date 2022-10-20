package com.ivan.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.safetravels.models.Expense;
import com.ivan.safetravels.repos.ExpenseRepo;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepo expenseRepo;
	
	
	//CREATE
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	//READ ALL
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}
	
	
	//READ ONE
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
			
	}
	//UPDATE/EDIT
	public Expense updateExpense(Expense exp) {
		Expense updateExpense = expenseRepo.save(exp);
		return updateExpense;
		
	}
	
	//DELETE 
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
	
}
