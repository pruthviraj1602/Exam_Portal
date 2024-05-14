package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.jdbc_conn;
import com.model.Promodel;

/**
 * Servlet implementation class admin_student_update_servlet
 */
@WebServlet("/admin_student_update_servlet")
public class admin_student_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_student_update_servlet() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String name=request.getParameter("name");
		System.out.println(name);
		String address=request.getParameter("address");
		System.out.println(address);
		String email=request.getParameter("email");
		System.out.println(email);
		String password=request.getParameter("password");
		System.out.println(password);
		String gender=request.getParameter("gender");
		System.out.println(gender);
		String branch=request.getParameter("branch");
		System.out.println(branch);
		String status=request.getParameter("status");
		System.out.println("status");
		try {
			Promodel pm=new Promodel(jdbc_conn.getConnection());
			boolean b=pm.update_stu(id,name,address,email,password,gender,branch,status);
			if(b) {
				response.sendRedirect("adminStudent_dash.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
