 package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Entity.admin_log;
import com.Entity.arithmaticQuestion;
import com.Entity.examiner_register;
import com.Entity.gkquestion;
import com.Entity.javaquestion;
import com.Entity.sqlquestion;
import com.Entity.student_register;


public class Promodel {
	Connection con;
	public Promodel(Connection con) {
		super();
		this.con=con;
	}
	public boolean insert(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
	
		PreparedStatement ps=con.prepareStatement("insert into login(email,password) values(?,?)");
		ps.setString(1, email);
		ps.setString(2, password);
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("success!");
			b=true;
		}
		return b;
	}
	public boolean stud_register(String name, String address, String email, String password, String gender, String branch) throws SQLException {
		boolean b=false;
		
		PreparedStatement ps=con.prepareStatement("insert into student(name,address,email,password,gender,branch)values(?,?,?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, email);
		ps.setString(4, password);
		ps.setString(5, gender);
		ps.setString(6, branch);
		int i=ps.executeUpdate();
	    if(i==1) {
	    	System.out.println("success!");
	    	b=true;
	    }
		return b;
	}
	
	public boolean Examiner_register(String name, String address, String email, String password, String gender,
			String branch , String subject) throws SQLException {
boolean b=false;
		
		PreparedStatement ps=con.prepareStatement("insert into examiner(name,address,email,password,gender,branch,subject)values(?,?,?,?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, email);
		ps.setString(4, password);
		ps.setString(5, gender);
		ps.setString(6, branch);
		ps.setString(7, subject);
		int i=ps.executeUpdate();
	    if(i==1) {
	    	System.out.println("success!");
	    	b=true;
	    }
		return b;
	}
	public String match(String email, String password,String status) throws SQLException {
		String s=null;
		student_register sr=null;
		
		PreparedStatement ps=con.prepareStatement("select * from student where email=? and password=? and status=?");
		ps.setString(1, email);
		ps.setString(2, password);
		ps.setString(3, status);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			sr=new student_register();
		   sr.setId(rs.getInt(1));
		   sr.setName(rs.getNString(2));
		   sr.setAddress(rs.getNString(3));
		   sr.setEmail(rs.getNString(4));
		   sr.setPassword(rs.getNString(5));
		   sr.setGender(rs.getNString(6));
		   sr.setBranch(rs.getNString(7));
		   sr.setStatus(rs.getNString(8));
		   
		   if(email.equals(sr.getEmail()) && password.equals(sr.getPassword()) && status.equals(sr.getStatus())) {  
			   s=sr.getName();
			   break;
		   }
		}
		return s;
	}
	public String match_examiner(String email, String password) throws SQLException {
		String s=null;
		examiner_register er=null;
		
		PreparedStatement ps=con.prepareStatement("select * from examiner where email=? and password=?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			er=new examiner_register();
			er.setId(rs.getInt(1));
			er.setName(rs.getNString(2));
			er.setAddress(rs.getNString(3));
			er.setEmail(rs.getNString(4));
			er.setPassword(rs.getNString(5));
			er.setGender(rs.getNString(6));
			er.setBranch(rs.getNString(7));
			
			if(email.equals(er.getEmail()) && password.equals(er.getPassword())) {
				s=er.getName();
				break;
			}
		}
		return s;
	}
	
	 public  List<student_register> stuList(String branch) throws SQLException{
	    	List< student_register> sr=new ArrayList<student_register>();
	    	student_register s=null;
	    	PreparedStatement ps=con.prepareStatement("select * from student where branch=?");
	    	ps.setString(1, branch);
	    	ResultSet rs=ps.executeQuery();
	    	while(rs.next()) {
	    		s=new student_register();
	    		s.setId(rs.getInt(1));
	    		s.setName(rs.getNString(2));
	    	    s.setAddress(rs.getNString(3));
	    	    s.setEmail(rs.getNString(4));
	    	    s.setPassword(rs.getNString(5));
	    	    s.setGender(rs.getNString(6));
	    	    s.setBranch(rs.getNString(7));
	    	    sr.add(s);
	    	}
			return sr;
	    	
	    }
	 public  List<student_register> stuList1() throws SQLException{
	    	List< student_register> sr=new ArrayList<student_register>();
	    	student_register s=null;
	    	PreparedStatement ps=con.prepareStatement("select * from student");
	    	
	    	ResultSet rs=ps.executeQuery();
	    	while(rs.next()) {
	    		s=new student_register();
	    		s.setId(rs.getInt(1));
	    		s.setName(rs.getNString(2));
	    	    s.setAddress(rs.getNString(3));
	    	    s.setEmail(rs.getNString(4));
	    	    s.setPassword(rs.getNString(5));
	    	    s.setGender(rs.getNString(6));
	    	    s.setBranch(rs.getNString(7));
	    	    sr.add(s);
	    	}
			return sr;
	    	
	    }
	public boolean stu_delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("delete from student where id=?");
		ps.setInt(1, id);
		int d=ps.executeUpdate();
		if(d==1) {
			b=true;
		}
		return b;
	}
	
	public List<student_register> update_stu(int id) throws SQLException{
		List<student_register> sr=new ArrayList<student_register>();
		student_register s=null;
		PreparedStatement ps=con.prepareStatement("select * from student where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			s=new student_register();
			s.setId(rs.getInt(1));
			s.setName(rs.getNString(2));
			s.setAddress(rs.getNString(3));
			s.setEmail(rs.getNString(4));
			s.setPassword(rs.getNString(5));
			s.setGender(rs.getNString(6));
			s.setBranch(rs.getNString(7));
			sr.add(s);
		}
		return sr;
		
	}
	public boolean update_stu(int id, String name, String address, String email, String password, String gender,
			String branch, String status) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("update student set name=?,address=?,email=?,password=?,gender=?,branch=?,status=? where id=?");
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, email);
		ps.setString(4, password);
		ps.setString(5, gender);
		ps.setString(6, branch);
		ps.setString(7, status);
		ps.setInt(8, id);
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("success");
			b=true;
		}
		return b;
	}
	
	public boolean update_stu2(int id, String name, String address, String email, String password, String gender,
			String branch) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("update student set name=?,address=?,email=?,password=?,gender=?,branch=? where id=?");
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, email);
		ps.setString(4, password);
		ps.setString(5, gender);
		ps.setString(6, branch);
		
		ps.setInt(7, id);
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("success");
			b=true;
		}
		return b;
	}
	public student_register std(String email, String password) throws SQLException {
		student_register std =null;
		PreparedStatement ps=con.prepareStatement("select * from student where email=? and password=?");
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			std=new student_register();
			std.setId(rs.getInt(1));
			std.setName(rs.getNString(2));
			std.setAddress(rs.getNString(3));
			std.setEmail(rs.getNString(4));
			std.setPassword(rs.getNString(5));
			std.setGender(rs.getNString(6));
			std.setBranch(rs.getNString(7));
			
		}
		
		System.out.println("success!");
		return std;
	}
	public boolean admin(String email, String password) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("insert into admin(email,password)values(?,?)");
		ps.setString(1, email);
		ps.setString(2, password);
		
		int i=ps.executeUpdate();
	    if(i==1) {
	    	b=true;
	    	System.out.println("succes!");
	    }
		return b;
	}
	public String match_admin(String email, String password) throws SQLException {
	     admin_log al=null;
	     String s=null;
	     PreparedStatement ps=con.prepareStatement("select * from admin where email=? and password=?");
	     ps.setString(1, email);
	     ps.setString(2, password);
	     ResultSet rs=ps.executeQuery();
	     while(rs.next()) {
	    	 al=new admin_log();
	    	 al.setId(rs.getInt(1));
	    	 al.setEmail(rs.getNString(2));
	    	 al.setPassword(rs.getNString(3));
	    	 
	    	 if(email.equals(al.getEmail())  &&  password.equals(al.getPassword())) {
	    		 s=al.getEmail();
	    		 break;
	    	 }
	     }
		return s;
	}

	
	public List<examiner_register> examiner_list() throws SQLException{
		List<examiner_register> li=new ArrayList<examiner_register>();
		examiner_register e=null;
		PreparedStatement ps=con.prepareStatement("select * from examiner");
	     ResultSet rs=ps.executeQuery();
	     while(rs.next()) {
	    	 e=new examiner_register();
	    	 e.setId(rs.getInt(1));
	    	 e.setName(rs.getNString(2));
	    	 e.setAddress(rs.getNString(3));
	    	 e.setEmail(rs.getNString(4));
	    	 e.setPassword(rs.getNString(5));
	    	 e.setGender(rs.getNString(6));
	    	 e.setBranch(rs.getNString(7));
	    	 e.setSubject(rs.getNString(8));
	    	 li.add(e);
	     }
		return li;
		
	}
	public boolean teach_delete(int id) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("delete from examiner where id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("success!");
			b=true;
		}
		return b;
	}
	
	public List<examiner_register> examiner(int id) throws SQLException{
		List<examiner_register> li=new ArrayList<examiner_register>();
		examiner_register e=null;
		PreparedStatement ps=con.prepareStatement("select * from examiner where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
	    	 e=new examiner_register();
	    	 e.setId(rs.getInt(1));
	    	 e.setName(rs.getNString(2));
	    	 e.setAddress(rs.getNString(3));
	    	 e.setEmail(rs.getNString(4));
	    	 e.setPassword(rs.getNString(5));
	    	 e.setGender(rs.getNString(6));
	    	 e.setBranch(rs.getNString(7));
	    	 e.setSubject(rs.getNString(8));
	    	 li.add(e);
	     }
		return li;
	}
	public examiner_register exam(String email, String password) throws SQLException {
	     examiner_register exam=null;
	     
	     PreparedStatement ps=con.prepareStatement("select * from examiner where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				exam=new examiner_register();
				exam.setId(rs.getInt(1));
				exam.setName(rs.getNString(2));
				exam.setAddress(rs.getNString(3));
				exam.setEmail(rs.getNString(4));
				exam.setPassword(rs.getNString(5));
				exam.setGender(rs.getNString(6));
				exam.setBranch(rs.getNString(7));
				exam.setSubject(rs.getNString(8));
			}
		return exam;
	}
	public boolean general_k(String subject, String question, String answer, String option1, String option2, String option3, String option4) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("insert into gk(subject,question,answer,option1,option2,option3,option4)values(?,?,?,?,?,?,?)");
		ps.setString(1, subject);
		ps.setString(2, question);
		ps.setString(3, answer);
		ps.setString(4, option1);
		ps.setString(5, option2);
		ps.setString(6, option3);
		ps.setString(7, option4);
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("succes");
			b=true;
		}
		return b;
	}
	public boolean arithmatic(String subject, String question, String answer, String option1, String option2, String option3, String option4) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("insert into arithmatic(subject,question,answer,option1,option2,option3,option4)values(?,?,?,?,?,?,?)");
		ps.setString(1, subject);
		ps.setString(2, question);
		ps.setString(3, answer);
		ps.setString(4, option1);
		ps.setString(5, option2);
		ps.setString(6, option3);
		ps.setString(7, option4);
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("succes");
			b=true;
		}
		return b;
	}
	public boolean java(String subject, String question, String answer, String option1, String option2, String option3, String option4) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("insert into java(subject,question,answer,option1,option2,option3,option4)values(?,?,?,?,?,?,?)");
		ps.setString(1, subject);
		ps.setString(2, question);
		ps.setString(3, answer);
		ps.setString(4, option1);
		ps.setString(5, option2);
		ps.setString(6, option3);
		ps.setString(7, option4);
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("succes");
			b=true;
		}
		return b;
	}
	public boolean sql(String subject, String question, String answer, String option1, String option2, String option3, String option4) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("insert into s_q_l(subject,question,answer,option1,option2,option3,option4)values(?,?,?,?,?,?,?)");
		ps.setString(1, subject);
		ps.setString(2, question);
		ps.setString(3, answer);
		ps.setString(4, option1);
		ps.setString(5, option2);
		ps.setString(6, option3);
		ps.setString(7, option4);
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("succes");
			b=true;
		}
		return b;
	}
	
	public List<gkquestion> gklist() throws SQLException{
		List<gkquestion> li=new ArrayList<gkquestion>();
		gkquestion g=null;
		PreparedStatement ps=con.prepareStatement("select * from gk");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			g=new gkquestion();
			g.setId(rs.getInt(1));
			g.setSubject(rs.getNString(2));
			g.setQuestion(rs.getNString(3));
			g.setAnswer(rs.getNString(4));
			g.setOption1(rs.getNString(5));
			g.setOption2(rs.getNString(6));
			g.setOption3(rs.getNString(7));
			g.setOption4(rs.getNString(8));
			li.add(g);
		}
		return li;	
	}
	public List<arithmaticQuestion> arithmaticlist() throws SQLException{
		List<arithmaticQuestion> li=new ArrayList<arithmaticQuestion>();
		arithmaticQuestion a=null;
		PreparedStatement ps=con.prepareStatement("select * from arithmatic");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			a=new arithmaticQuestion();
			a.setId(rs.getInt(1));
			a.setSubject(rs.getNString(2));
			a.setQuestion(rs.getNString(3));
			a.setAnswer(rs.getNString(4));
			a.setOption1(rs.getNString(5));
			a.setOption2(rs.getNString(6));
			a.setOption3(rs.getNString(7));
			a.setOption4(rs.getNString(8));
			li.add(a);
		}
		System.out.println("success");
		return li;
	}
	public List<javaquestion> javalist() throws SQLException{
		List<javaquestion> li=new ArrayList<javaquestion>();
		javaquestion j=null;
		PreparedStatement ps=con.prepareStatement("select * from java");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			j=new javaquestion();
			j.setId(rs.getInt(1));
			j.setSubject(rs.getNString(2));
			j.setQuestion(rs.getNString(3));
			j.setAnswer(rs.getNString(4));
			j.setOption1(rs.getNString(5));
			j.setOption2(rs.getNString(6));
			j.setOption3(rs.getNString(7));
			j.setOption4(rs.getNString(8));
			li.add(j);
		}
		return li;
	}
	public List<sqlquestion> sqllist() throws SQLException{
		List<sqlquestion> li=new ArrayList<sqlquestion>();
         sqlquestion s=null;
         PreparedStatement ps=con.prepareStatement("select * from s_q_l");
         ResultSet rs=ps.executeQuery();
         while(rs.next()) {
        	 s=new sqlquestion();
        	 s.setId(rs.getInt(1));
 			s.setSubject(rs.getNString(2));
 			s.setQuestion(rs.getNString(3));
 			s.setAnswer(rs.getNString(4)); 
 			s.setOption1(rs.getNString(5));
			s.setOption2(rs.getNString(6));
			s.setOption3(rs.getNString(7));
			s.setOption4(rs.getNString(8));
 			li.add(s);
         }
		return li;
	}
//	public String exam_match(String email, String password) throws SQLException {
//		String s=null;
//		student_register sr=null;
//		
//		PreparedStatement ps=con.prepareStatement("select * from student where email=? and password=?");
//		ps.setString(1, email);
//		ps.setString(2, password);
//		
//		
//		ResultSet rs=ps.executeQuery();
//		while(rs.next()) {
//			sr=new student_register();
//		   sr.setId(rs.getInt(1));
//		   sr.setName(rs.getNString(2));
//		   sr.setAddress(rs.getNString(3));
//		   sr.setEmail(rs.getNString(4));
//		   sr.setPassword(rs.getNString(5));
//		   sr.setGender(rs.getNString(6));
//		   sr.setBranch(rs.getNString(7));
//		   sr.setStatus(rs.getNString(8));
//		   
//		   if(email.equals(sr.getEmail()) && password.equals(sr.getPassword())) {  
//			   s=sr.getName();
//			   break;
//		   }
//		}
//		return s;
//	}

	public String exam_demo_match( String question, String answer) throws SQLException {
		 gkquestion gk=null;
		 String s=null;
		 PreparedStatement ps=con.prepareStatement("select * from gk where question=? and answer=?");
		 ps.setString(1, question);
		 ps.setString(2, answer);
		ResultSet rs=ps.executeQuery();
		
		 while(rs.next()) {
			 gk=new gkquestion();
			 gk.setId(rs.getInt(1));
			 gk.setSubject(rs.getNString(2));
			 gk.setQuestion(rs.getNString(3));
			 gk.setAnswer(rs.getNString(4));
			 gk.setOption1(rs.getNString(5));
			 gk.setOption2(rs.getNString(6));
			 gk.setOption3(rs.getNString(7));
			 gk.setOption4(rs.getNString(8));
			 if(question.equals(gk.getQuestion())&& answer.equals(gk.getAnswer())) {
				 s=gk.getQuestion();
			     break;	 
			 }
		 }
		return s;
	}
	public String  exam_demo2_match( String question, String answer) throws SQLException {
		arithmaticQuestion ar=null;
		String s=null;
		PreparedStatement ps=con.prepareStatement("select * from arithmatic where question=? and answer=?");
		 ps.setString(1, question);
		 ps.setString(2, answer);
		ResultSet rs=ps.executeQuery();

		while(rs.next()) {
			ar=new arithmaticQuestion();
			ar.setId(rs.getInt(1));
			ar.setSubject(rs.getNString(2));
			ar.setQuestion(rs.getNString(3));
			ar.setAnswer(rs.getNString(4));
			ar.setOption1(rs.getNString(5));
			ar.setOption2(rs.getNString(6));
			ar.setOption3(rs.getNString(7));
			ar.setOption4(rs.getNString(8));
			if(question.equals(ar.getQuestion())&&answer.equals(ar.getAnswer())) {
				s=ar.getQuestion();
				break;
			}
		}
		System.out.println("success");
		return s;
		
	}
    
	public String  exam_demo3_match( String question, String answer) throws SQLException {
		javaquestion j=null;
		String s=null;
		PreparedStatement ps=con.prepareStatement("select * from java where question=? and answer=?");
		 ps.setString(1, question);
		 ps.setString(2, answer);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			j=new javaquestion();
			j.setId(rs.getInt(1));
			j.setSubject(rs.getNString(2));
			j.setQuestion(rs.getNString(3));
			j.setAnswer(rs.getNString(4));
			j.setOption1(rs.getNString(5));
			j.setOption2(rs.getNString(6));
			j.setOption3(rs.getNString(7));
			j.setOption4(rs.getNString(8));
			if(question.equals(j.getQuestion())&&answer.equals(j.getAnswer())) {
				s=j.getQuestion();
				break;
			}
		}
		
		return s;
	}
	public String  exam_demo4_match( String question, String answer) throws SQLException {
		sqlquestion sq=null;
		String s=null;
		PreparedStatement ps=con.prepareStatement("select * from s_q_l where question=? and answer=?");
		 ps.setString(1, question);
		 ps.setString(2, answer);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			sq=new sqlquestion();
			sq.setId(rs.getInt(1));
 			sq.setSubject(rs.getNString(2));
 			sq.setQuestion(rs.getNString(3));
 			sq.setAnswer(rs.getNString(4)); 
 			sq.setOption1(rs.getNString(5));
			sq.setOption2(rs.getNString(6));
			sq.setOption3(rs.getNString(7));
			sq.setOption4(rs.getNString(8));
			
			if(question.equals(sq.getQuestion())&&answer.equals(sq.getAnswer())) {
				s=sq.getQuestion();
				break;
			}
		}
		
		return s;
	}
	public boolean update_teacher(int id, String name, String address, String email, String password, String gender,
			String branch, String subject) throws SQLException {
		boolean b=false;
		PreparedStatement ps=con.prepareStatement("update examiner set name=?,address=?,email=?,password=?,gender=?,branch=?,subject=? where id=?");
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, email);
		ps.setString(4, password);
		ps.setString(5, gender);
		ps.setString(6, branch);
		ps.setString(7, subject);
		ps.setInt(8, id);
		
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("success");
			b=true;
		}
		return b;
	}
}
