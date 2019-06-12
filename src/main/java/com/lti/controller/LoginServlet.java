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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		int id = Integer.parseInt(request.getParameter("id"));
		String password = (String) request.getParameter("pw");
		//UserDao dao = new UserDaoImpl();
		UserDao dao = new UserDaoHibImpl();
		User user = dao.login(id, password);
		if (user.getId() == id && user.getPassword().equals(password)) {
			request.setAttribute("user", user);
			RequestDispatcher rd = request
					.getRequestDispatcher("landingPage.jsp");
			rd.forward(request, response);
		}

		RequestDispatcher rd = request.getRequestDispatcher("loginFail.jsp");
		rd.forward(request, response);
	}

}
