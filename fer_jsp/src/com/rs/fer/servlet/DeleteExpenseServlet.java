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

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out,session.getAttribute("username").toString());
		
		int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());
		boolean isDeleted = ferService.deleteExpense(expenseId);
		
		if (isDeleted) {
			out.println("Expense deleted successfully");
		} else {
			out.println("Expense not deleted");
		}

		HTMLUtil.displayFooter(request, response, out);

	}

}
