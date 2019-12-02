package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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

@WebServlet("/expenseReport")
public class ExpenseReportServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		String expenseType = request.getParameter("expenseType");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		
		List<Expense> expenseReport = ferService.expenseReport(userId, expenseType, fromDate, toDate);

		if (expenseReport != null && !expenseReport.isEmpty()) {
			out.println("<table border='1' align='center'>");
			out.println("<tr>");
			out.println("<td colspan='6' align='center'>Expense Report</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Expense Type</td>");
			out.println("<td>Date</td>");
			out.println("<td>Price</td>");
			out.println("<td>Number of Items</td>");
			out.println("<td>Total</td>");
			out.println("<td align='center'>Actions</td>");
			out.println("</tr>");

			Iterator<Expense> iterator = expenseReport.iterator();
			Expense expense = null;
			while (iterator.hasNext()) {
				expense = iterator.next();
				out.println("<tr>");
				out.println("<td>" + expense.getType() + "</td>");
				out.println("<td>" + expense.getDate() + "</td>");
				out.println("<td>" + expense.getPrice() + "</td>");
				out.println("<td>" + expense.getNumberofitems() + "</td>");
				out.println("<td>" + expense.getTotal() + "</td>");

				out.println("<td><a href='#'>Edit</a>&nbsp&nbsp&nbsp<a href='#'>Delete</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");

		} else {
			out.println("No expense records found");
		}
		HTMLUtil.displayFooter(request, response, out);

	}
}