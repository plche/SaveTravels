package com.codingdojo.peru.ft2022.savetravels.services;

import java.util.List;

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
}
