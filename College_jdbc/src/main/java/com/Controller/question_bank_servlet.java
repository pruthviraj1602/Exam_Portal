package com.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.jdbc_conn;
import com.model.Promodel;

/**
 * Servlet implementation class question_bank_servlet
 */
@WebServlet("/question_bank_servlet")
public class question_bank_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public question_bank_servlet() {
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
		String subject=request.getParameter("subject");
		System.out.println(subject);
		String question=request.getParameter("question");
		System.out.println(question);
		String answer=request.getParameter("answer");
		System.out.println(answer);
		String option1=request.getParameter("option1");
		System.out.println(option1);
		String option2=request.getParameter("option2");
		System.out.println(option2);
		String option3=request.getParameter("option3");
		System.out.println(option3);
		String option4=request.getParameter("option4");
		System.out.println(option4);
	
		if(subject.equals("General Knowledge")) {
			
			try {
				Promodel pm=new Promodel(jdbc_conn.getConnection());
				boolean b=pm.general_k(subject,question,answer,option1,option2,option3,option4);
				if(b) {
					response.sendRedirect("Examiner_questionbank.jsp");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(subject.equals("Arithmatic")) {
			try {
				Promodel pm=new Promodel(jdbc_conn.getConnection());
				boolean b=pm.arithmatic(subject,question,answer,option1,option2,option3,option4);
				if(b) {
					response.sendRedirect("Examiner_questionbank.jsp");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
		}
		if(subject.equals("JAVA")) {
			try {
				Promodel pm=new Promodel(jdbc_conn.getConnection());
				boolean b=pm.java(subject,question,answer,option1,option2,option3,option4);
				if(b) {
					response.sendRedirect("Examiner_questionbank.jsp");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(subject.equals("SQL")) {
			try {
				Promodel pm=new Promodel(jdbc_conn.getConnection());
				boolean b=pm.sql(subject,question,answer,option1,option2,option3,option4);
				if(b) {
					response.sendRedirect("Examiner_questionbank.jsp");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
			
	}

}
