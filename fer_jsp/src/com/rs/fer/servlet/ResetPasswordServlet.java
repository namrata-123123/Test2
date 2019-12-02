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
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		boolean isUpdated = ferService.resetPassword(userId, currentPassword, newPassword);

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		if (isUpdated) {
			out.println("password updated successfully");
		} else {
			out.println("password not updated");
		}
		HTMLUtil.displayFooter(request, response, out);

	}
}