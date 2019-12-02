package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/editExpense")
public class EditExpenseServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();
	Expense expense = new Expense();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// Getting expense object from session
		Expense expense = (Expense) session.getAttribute("expense");
		int expenseId = Integer.parseInt(session.getAttribute("expenseId").toString());

		// Updating expense properties
		expense.setType(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(Float.parseFloat(request.getParameter("price").toString()));
		expense.setNumberofitems(Integer.parseInt(request.getParameter("numberofitems").toString()));
		expense.setTotal(Float.parseFloat(request.getParameter("total").toString()));
		expense.setByWhom(request.getParameter("byWhom"));

		// Setting expenseId to Edit
		expense.setId(expenseId);

		// Calling editExpense() from FERService
		boolean isEdited = ferService.editExpense(expense);

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		// Displaying the status
		if (isEdited) {
			out.println("Expense edited successfully");
		} else {
			out.println("failed");

		}

		HTMLUtil.displayFooter(request, response, out);

	}

}
