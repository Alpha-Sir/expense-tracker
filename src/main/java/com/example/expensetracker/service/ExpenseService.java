package com.example.expense_tracker.service;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public void saveExpense(Expense expense) {
        repository.save(expense);
    }

    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }

    public double getTotalExpenses() {
        return repository.findAll()
                .stream()
                .mapToDouble(expense -> expense.getAmount() != null ? expense.getAmount() : 0.0)
                .sum();
    }
}