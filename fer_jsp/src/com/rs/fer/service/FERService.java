package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FERService {

	boolean registration(User user);
	
	int login(String username,String password);
	
	boolean addExpense(Expense expense);
	
	boolean editExpense(Expense expense);
	
	boolean deleteExpense(int expenseId);
	
	boolean resetPassword(int userId,String currentPassword,String newPassword);
	
	Expense getExpense(int expenseId);
	
	List<Expense> getExpenses(int userId);
	
	List<Expense> expenseReport(int userId,String expenseType,String fromDate,String toDate);
	
	User getPersonalInfo(int userId);
	
	boolean updatePersonalInfo(User user);
	boolean isUsernameAvailable(String username);

	
}
