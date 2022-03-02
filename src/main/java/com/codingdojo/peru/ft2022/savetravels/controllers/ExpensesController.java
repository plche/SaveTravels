package com.codingdojo.peru.ft2022.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.peru.ft2022.savetravels.models.Expense;
import com.codingdojo.peru.ft2022.savetravels.services.ExpenseService;

@Controller
public class ExpensesController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense) {
		return "index.jsp";
	}
	
	@PostMapping(value = "/expenses")
	public String saveNewExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			expenseService.createExpense(expense);
			
			return "redirect:/expenses";
		}
		
		
		
	}
}
