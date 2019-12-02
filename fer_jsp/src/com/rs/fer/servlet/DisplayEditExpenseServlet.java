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

@WebServlet("/displayEditExpense")
public class DisplayEditExpenseServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());
		Expense expense = ferService.getExpense(expenseId);
		PrintWriter out = response.getWriter();
	
		HttpSession session = request.getSession();
		session.setAttribute("expenseId",expenseId);
		session.setAttribute("expense",expense);
		String username = (session.getAttribute("username") != null ? session.getAttribute("username").toString() : "");

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, username);
		//Displaying objects from HTML Table 
		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Edit Expense</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='expenseType' value=" + expense.getType() + "></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='text' name='date' value=" + expense.getDate() + "></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td><input type='text' name='price' value=" + expense.getPrice() + "></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Number of Items</td>");
		out.println("<td><input type='number' name='numberofitems' value=" + expense.getNumberofitems() + "></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Total</td>");
		out.println("<td><input type='number' name='total' value=" + expense.getTotal() + "></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>By Whom</td>");
		out.println("<td><input type='text' name='byWhom' value=" + expense.getByWhom() + "></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Edit' onclick='javascript:submitForm(\"editExpense\")'>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response, out);

	}

}
