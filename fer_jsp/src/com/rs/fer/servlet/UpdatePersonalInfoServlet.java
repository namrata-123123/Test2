 package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;
@WebServlet("/updatePersonalInfo")
public class UpdatePersonalInfoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		boolean isPersonalUpdated = ferService.updatePersonalInfo(user);
		PrintWriter out = response.getWriter();
		String username = (session.getAttribute("username") != null ? session.getAttribute("username").toString() : "");
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, username);

		if (isPersonalUpdated) {
			out.println("personal info updated successfully");
		} else {
			out.println("personal info not updated");
		}
		HTMLUtil.displayFooter(request, response, out);

	}

}
