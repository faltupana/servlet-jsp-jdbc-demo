package com.lti.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.beans.User;
import com.lti.model.dao.UserDao;
import com.lti.model.dao.UserDaoHibImpl;
import com.lti.model.dao.UserDaoImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		String phoneNumber = (String) request.getParameter("phoneNumber");
		User user = new User(name, phoneNumber, password);
		//UserDao dao = new UserDaoImpl();
		UserDao dao = new UserDaoHibImpl();
		int seq = dao.store(user);
		request.setAttribute("seq", seq);
		RequestDispatcher rd = request
				.getRequestDispatcher("registrationSuccess.jsp");
		rd.forward(request, response);
	}
}
