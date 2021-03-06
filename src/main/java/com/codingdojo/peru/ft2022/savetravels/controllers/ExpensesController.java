package com.codingdojo.peru.ft2022.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.codingdojo.peru.ft2022.savetravels.models.Expense;
import com.codingdojo.peru.ft2022.savetravels.services.ExpenseService;

@Controller
public class ExpensesController {
	
	@Autowired
	ExpenseService expenseService;

	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);

		return "index.jsp";
	}

	@PostMapping(value = "/expenses")
	public String saveNewExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) return "index.jsp";
		expenseService.createExpense(expense);

		return "redirect:/expenses";
	}

	@GetMapping("/expenses/{expenseId}")
	public String expenseDetail(@PathVariable("expenseId") Long expenseId, Model model) {
		Expense expense = expenseService.findExpense(expenseId);
		model.addAttribute("expense", expense);

		return "show.jsp";
	}

	@GetMapping("/expenses/edit/{id}")
	public String editAnExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/{id}")
	public String updateAnExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) return "edit.jsp";
		else {
			expenseService.updateExpense(expense.getId(), expense.getName(), expense.getVendor(), expense.getAmount(), expense.getDescription());
			return "redirect:/expenses";
		}
	}

	@DeleteMapping("/expenses/{id}")
	public String destroyAnExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
