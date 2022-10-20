package com.ivan.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ivan.safetravels.models.Expense;
import com.ivan.safetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseServ;
	
	@GetMapping("/")  // This will display main page with all expenses and the form
	public String index(Model model) {    //Model model allows us to display in the jsp
		//get the expenses
		List<Expense> allexpenses = expenseServ.allExpenses();//creates an object which is a list object
		//pass the expenses to the jsp
		model.addAttribute("allExpenses", allexpenses); //this will allow us to display to our jsp 
		//create new expense
		Expense newExpense = new Expense();  //this will allows to create an new expense and the right side of the equal sign comes from the empty constructor in the model
		model.addAttribute("newExpense", newExpense); 
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String submit(@Valid @ModelAttribute("newExpense")Expense expense,BindingResult result, Model model) {
//			System.out.println(expense.getName());
		if (result.hasErrors()) {
			System.out.println(result);
			List<Expense> allexpenses = expenseServ.allExpenses();

			model.addAttribute("allExpenses", allexpenses);

			return "index.jsp";
			
		} else {
			expenseServ.createExpense(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editpage(@PathVariable("id") Long id, Model model) {
		System.out.println(id);
		Expense ex = expenseServ.findExpense(id);
		model.addAttribute("newExpense",ex);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/submit/edit/{id}", method=RequestMethod.PUT)
		public String submitedit(@Valid @ModelAttribute("newExpense")Expense expense,BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);

			return "edit.jsp";
			
		} else {
			expenseServ.updateExpense(expense);
			System.out.println(expense);

			return "redirect:/";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String showpage(@PathVariable ("id")Long id, Model model) {
		Expense expense = expenseServ.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	

}
