package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/displayDeleteExpense")
public class DisplayDeleteExpenseServlet extends HttpServlet {
	FERService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		List<Expense> expenses = ferService.getExpenses(userId);

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		if (expenses != null && !expenses.isEmpty()) {
			out.println("ExpenseId:");
			out.println("<select name='expenseId'>");

			for (Expense expense : expenses) {
				out.println("<option value=" + expense.getId() + ">");
				out.println(expense.getByWhom() + "," + expense.getDate() + "," + expense.getType() + ","+ expense.getPrice());
				out.println("</option>");
			}
			out.println("</select>");
			out.println("<br></br>");
			out.println("<input type='button' value='Delete Expense' onclick='javascript:submitForm(\"deleteExpense\")'>");

			HTMLUtil.displayFooter(request, response, out);

		}
	}
}
