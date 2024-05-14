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
 * Servlet implementation class Student_exam_servlet
 */
@WebServlet("/Student_exam_servlet")
public class Student_exam_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_exam_servlet() {
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
		String subject=request.getParameter("subject");
		System.out.println(subject);
		String login_email=request.getParameter("em");
		System.out.println(login_email);
		String login_password=request.getParameter("pass");
		System.out.println(login_password);
		
		int id=1;
		int m=1;
		
		
		
		if(subject.equals("GeneralKnowledge")) {
			try {
				Promodel pm=new Promodel(jdbc_conn.getConnection());
//				String s=pm.exam_match(email,password);
				student_register user=pm.std(email,password);
				if(email.equals(login_email)&& password.equals(login_password)) {
					HttpSession session=request.getSession();
					session.setAttribute("std", user);
					JOptionPane.showMessageDialog(null, "Best Luck...!","loginExam", JOptionPane.INFORMATION_MESSAGE);
					response.sendRedirect("exam_demo.jsp?id="+id + "&m="+m );
				}
				else {
					JOptionPane.showMessageDialog(null, "Check Login Email or Password","LoginFail", JOptionPane.INFORMATION_MESSAGE);
					response.sendRedirect("StudentExamLOG.jsp");
					System.out.println("success!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        if(subject.equals("Arithmatic")) {
        	try {
    			Promodel pm=new Promodel(jdbc_conn.getConnection());
//    			String s=pm.exam_match(email,password);
    			student_register user=pm.std(email,password);
    			if(email.equals(login_email)&& password.equals(login_password)) {
    				HttpSession session=request.getSession();
    				session.setAttribute("std", user);
    				JOptionPane.showMessageDialog(null, "Best Luck for the exam...!","loginExam", JOptionPane.INFORMATION_MESSAGE);
    				response.sendRedirect("exam.demo2.jsp?id="+id + "&m="+m );
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Please Check Login Email or Password","LoginFail", JOptionPane.INFORMATION_MESSAGE);
    				response.sendRedirect("StudentExamLOG.jsp");
    				System.out.println("success!");
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	
		}
        if(subject.equals("JAVA")) {
        	try {
    			Promodel pm=new Promodel(jdbc_conn.getConnection());
//    			String s=pm.exam_match(email,password);
    			student_register user=pm.std(email,password);
    			if(email.equals(login_email)&& password.equals(login_password)) {
    				HttpSession session=request.getSession();
    				session.setAttribute("std", user);
    				JOptionPane.showMessageDialog(null, "Best Luck...!","loginExam", JOptionPane.INFORMATION_MESSAGE);
    				response.sendRedirect("exam_demo3.jsp?id="+id + "&m="+m );
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Check Login Email or Password","LoginFail", JOptionPane.INFORMATION_MESSAGE);
    				response.sendRedirect("StudentExamLOG.jsp");
    				System.out.println("success!");
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
		}
        if(subject.equals("SQL")) {
        	try {
    			Promodel pm=new Promodel(jdbc_conn.getConnection());
//    			String s=pm.exam_match(email,password);
    			student_register user=pm.std(email,password);
    			if(email.equals(login_email)&& password.equals(login_password)) {
    				HttpSession session=request.getSession();
    				session.setAttribute("std", user);
    				JOptionPane.showMessageDialog(null, "Best Luck...!","loginExam", JOptionPane.INFORMATION_MESSAGE);
    				response.sendRedirect("exam_demo4.jsp?id="+id + "&m="+m );
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Check Login Email or Password","LoginFail", JOptionPane.INFORMATION_MESSAGE);
    				response.sendRedirect("StudentExamLOG.jsp");
    				System.out.println("success!");
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
		}
	}

}
