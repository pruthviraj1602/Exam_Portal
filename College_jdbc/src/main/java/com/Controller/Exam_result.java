package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.gkquestion;
import com.connection.jdbc_conn;
import com.model.Promodel;

/**
 * Servlet implementation class Exam_result
 */
@WebServlet("/Exam_result")
public class Exam_result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam_result() {
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
	     int question1=Integer.parseInt(request.getParameter("question1"));
	     System.out.println(question1);
	     String option1=request.getParameter("option1");
	     System.out.println(option1);
	     
	     int question2=Integer.parseInt(request.getParameter("question2"));
	     System.out.println(question2);
	     String option2=request.getParameter("option2");
	     System.out.println(option2);
	     
	     int question3=Integer.parseInt(request.getParameter("question3"));
	     System.out.println(question3);
	     String option3=request.getParameter("option3");
	     System.out.println(option3);
	     
	     int question4=Integer.parseInt(request.getParameter("question4"));
	     System.out.println(question4);
	     String option4=request.getParameter("option4");
	     System.out.println(option4);
	     
	     int question5=Integer.parseInt(request.getParameter("question5"));
	     System.out.println(question5);
	     String option5=request.getParameter("option5");
	     System.out.println(option5);
	     
	     int question6=Integer.parseInt(request.getParameter("question6"));
	     System.out.println(question6);
	     String option6=request.getParameter("option6");
	     System.out.println(option6);
	     
	     int question7=Integer.parseInt(request.getParameter("question7"));
	     System.out.println(question7);
	     String option7=request.getParameter("option7");
	     System.out.println(option7);
	     
	     int question8=Integer.parseInt(request.getParameter("question8"));
	     System.out.println(question8);
	     String option8=request.getParameter("option8");
	     System.out.println(option8);
	     
	     int question9=Integer.parseInt(request.getParameter("question9"));
	     System.out.println(question9);
	     String option9=request.getParameter("option9");
	     System.out.println(option9);
	     
	     int question10=Integer.parseInt(request.getParameter("question10"));
	     System.out.println(question10);
	     String option10=request.getParameter("option10");
	     System.out.println(option10);
	     
	     try {
			Promodel pm=new Promodel(jdbc_conn.getConnection());
		//	String s=pm.quiz(question1,option1,question2,option2,question3,option3,question4,option4,question5,option5,question6,option6,question7,option7,question8,option8,question9,option9,question10,option10);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
