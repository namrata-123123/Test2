package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creating expense object 
		Expense expense = new Expense();
		HttpSession session = request.getSession();
		// Getting expense properties
		expense.setType(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice((Float.parseFloat(request.getParameter("price"))));
		expense.setNumberofitems((Integer.parseInt(request.getParameter("numberOfItems"))));
		expense.setTotal((Float.parseFloat(request.getParameter("total"))));
		expense.setByWhom((request.getParameter("byWhom")));
		expense.setUserid(Integer.parseInt(session.getAttribute("userId").toString()));
		//calling AddExpense from FERService
		boolean isExpenseAdded = ferService.addExpense(expense);
		PrintWriter out = response.getWriter();
		String nextPath = null;

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		//Checking condition and Displaying the status
		if (isExpenseAdded) {
			request.getRequestDispatcher("AddExpenseStatus.html").include(request, response);
		} else {
			out.println("Expeneses addition failed");
			nextPath = "AddExpense.html";

			RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPath);
			requestDispatcher.include(request, response);
		}

		HTMLUtil.displayFooter(request, response, out);

	}
}
