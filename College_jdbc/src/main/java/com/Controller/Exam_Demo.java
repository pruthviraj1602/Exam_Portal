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
 * Servlet implementation class Exam_Demo
 */
@WebServlet("/Exam_Demo")
public class Exam_Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam_Demo() {
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
		String question = request.getParameter("question");
		System.out.println(question);
		String answer=request.getParameter("answer");
		System.out.println(answer);
		String m=request.getParameter("m");
		System.out.println(m);
		
		try {
			Promodel pm=new Promodel(jdbc_conn.getConnection());
			String s=pm.exam_demo_match(question,answer);
			if(id==10) {
				if(s!=null) {
					response.sendRedirect("Result.jsp?id="+(id)+"&m=" + (Integer.parseInt(m)+1-1));
					System.out.println("succcess & End");
				}else {
					response.sendRedirect("Result.jsp?id="+(id)+"&m=" + (Integer.parseInt(m)-1));
					System.out.println("Failed!");
				}
			}
			
			
			if(s!=null) {
				response.sendRedirect("exam_demo.jsp?id="+(id+1)+"&m=" + (Integer.parseInt(m) + 1));
				System.out.println("success!");
			}
			else {
				response.sendRedirect("exam_demo.jsp?id="+(id+1)+"&m="+m);
				System.out.println("Failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
