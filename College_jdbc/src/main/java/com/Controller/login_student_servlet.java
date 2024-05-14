package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.Entity.student_register;
import com.connection.jdbc_conn;
import com.model.Promodel;


/**
 * Servlet implementation class login_student_servlet
 */
@WebServlet("/login_student_servlet")
public class login_student_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_student_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email=request.getParameter("email");
		System.out.println(email);
		String password=request.getParameter("password");
		System.out.println(password); 
		String status="enable";
	try {
		Promodel pm=new Promodel(jdbc_conn.getConnection());
		String s=pm.match(email,password,status);
		student_register user=pm.std(email,password);
		if(s!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("std", user);
			JOptionPane.showMessageDialog(null, "Successful login","Successful", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect("Dashboared.jsp");
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Check Email or Password","LoginFail", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect("Login.jsp");
			System.out.println("success!");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

}
