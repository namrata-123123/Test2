
package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.util.HTMLUtil;

@WebServlet("/displayResetPassword")
public class DisplayResetPassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		request.getRequestDispatcher("ResetPassword.html").include(request, response);
		HTMLUtil.displayFooter(request, response, out);
	}

}
