package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.connection.jdbc_conn;
import com.model.Promodel;

/**
 * Servlet implementation class login_admin_servlet
 */
@WebServlet("/login_admin_servlet")
public class login_admin_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_admin_servlet() {
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
		try {
			Promodel pm=new Promodel(jdbc_conn.getConnection());
			String s=pm.match_admin(email,password);
			if(s!=null) {
				JOptionPane.showMessageDialog(null, "Login Succesfull","LoginSuccces", JOptionPane.INFORMATION_MESSAGE);
				response.sendRedirect("Admin_dash.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Check Email or Password","LoginFail", JOptionPane.INFORMATION_MESSAGE);
				response.sendRedirect("LoginAdmin.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
