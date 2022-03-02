package com.codingdojo.peru.ft2022.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.peru.ft2022.savetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	// este método recupera todos los libros de la base de datos
	List<Expense> findAll();
}
