package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {

        // 🔥 ALWAYS send expense (VERY IMPORTANT)
        model.addAttribute("expense", new Expense());

        model.addAttribute("expenses", service.getAllExpenses());
        model.addAttribute("totalExpenses", service.getTotalExpenses());

        return "index";
    }

    @GetMapping("/edit/{id}")
    public String editExpense(@PathVariable Long id, Model model) {

        Expense expense = service.getExpenseById(id);

        // 🔥 If null, avoid crash
        if (expense == null) {
            expense = new Expense();
        }

        model.addAttribute("expense", expense);
        model.addAttribute("expenses", service.getAllExpenses());
        model.addAttribute("totalExpenses", service.getTotalExpenses());

        return "index";
    }

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {

        if (expense.getDate() == null) {
            expense.setDate(LocalDate.now());
        }

        service.saveExpense(expense);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
        return "redirect:/";
    }
}