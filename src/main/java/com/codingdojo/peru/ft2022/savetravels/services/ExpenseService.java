package com.codingdojo.peru.ft2022.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.peru.ft2022.savetravels.models.Expense;
import com.codingdojo.peru.ft2022.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	// agregar el repositorio de gastos como una dependencia
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// returns all the books
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	// creates an expense
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	// retrieves an expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) return optionalExpense.get();
		else return null;
	}
	
	// updates an expense
	public Expense updateExpense(Long id, String name, String vendor, Double amount, String description) {
		Expense expense = new Expense(name, vendor, amount, description);
		expense.setId(id);
		return expenseRepository.save(expense);
	}
	
	// removes an expense
	public void deleteExpense(Long id) { expenseRepository.deleteById(id); }
}
