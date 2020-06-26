package com.fees.roport;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountOperation {

	public void addStudent(BufferedReader buff, Student s,Connection con) {

		
		try {
			
			
			System.out.println("Enter id");
			int id=buff.read();
			System.out.println("Enter your Name");
			String name = buff.readLine();

			System.out.println("Enter your email");
			String email = buff.readLine();
			System.out.println("Enter your course");
			String course = buff.readLine();
			System.out.println("Enter your fee");
			int fee = buff.read();
			System.out.println("Enter your paid");
			int paid = buff.read();
			System.out.println("Enter your due");
			int due = buff.read();
			System.out.println("Enter your address");
			String address = buff.readLine();
			System.out.println("Enter your city");
			String city = buff.readLine();
			System.out.println("Enter your state");
			String state = buff.readLine();
			System.out.println("Enter your country");
			String country = buff.readLine();
			System.out.println("Enter your cotactno");
			int contactno = buff.read();
			
			s.setId(id);
			s.setName(name);
			s.setEmail(email);
			s.setCourse(course);
			s.setFee(fee);
			s.setPaid(paid);
			s.setDue(due);
			s.setAddress(address);
			s.setCity(city);
			s.setState(state);
			s.setContactno(contactno);
			
			
			PreparedStatement stmtInsert = con.prepareStatement("insert into students.Stud values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmtInsert.setInt(1, id);
			stmtInsert.setString(2, name);
			stmtInsert.setString(3, email);
			stmtInsert.setString(4, course);
			stmtInsert.setInt(5, fee);
			stmtInsert.setInt(6, paid);
			stmtInsert.setInt(7, due);
			stmtInsert.setString(8, city);
			stmtInsert.setString(9, state);
			stmtInsert.setString(10, country);
			stmtInsert.setString(11, address);
			stmtInsert.setInt(12, contactno);

			System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");
			

			 try{
		         if(stmtInsert!=null)
		            con.close();
		      }catch(SQLException se){
		    	  
		      }
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
	}

	public void viewStudent(BufferedReader buff, Student s,Connection con) {
		// TODO Auto-generated method stub
		
	}

	public void editStudent(BufferedReader buff, Student s,Connection con) {
		
		
		
		try {
			System.out.println("choose  which value u hav to edit\n1.Name\n2.email\n3.course\n4.fee\n5.paid\n6.due\n7.city\n8.state\n9.country\n10.address\n11.contact num");
			int choose=buff.read();
			
			PreparedStatement stmtedit=null;
			switch (choose) {
			case 1:
				System.out.println("name");
				String name=buff.readLine();
				s.setName(name);
				System.out.println("id");
				int id=buff.read();
				s.setId(id);
				stmtedit= con.prepareStatement("update Stud set name=? where id=?");
				stmtedit.setString(2,name);
				stmtedit.setInt(1, id);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				
				break;
			case 2:
				System.out.println("email");
				String email=buff.readLine();
				s.setEmail(email);
				System.out.println("id");
				int id1=buff.read();
				s.setId(id1);
				stmtedit= con.prepareStatement("update Stud set email=? where id=?");
				stmtedit.setString(2,email);
				stmtedit.setInt(1, id1);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				
				
				break;
			case 3:
				System.out.println("course");
				String course=buff.readLine();
				s.setCourse(course);
				System.out.println("id");
				int id2=buff.read();
				s.setId(id2);
				stmtedit= con.prepareStatement("update Stud set course=? where id=?");
				stmtedit.setString(3,course);
				stmtedit.setInt(1, id2);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				
				break;
			case 4:
				System.out.println("fee");
				String fee=buff.readLine();
				s.setCourse(fee);
				System.out.println("id");
				int id3=buff.read();
				s.setId(id3);
				stmtedit= con.prepareStatement("update Stud set fee=? where id=?");
				stmtedit.setString(4,fee);
				stmtedit.setInt(1, id3);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");
				

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				break;
			case 5:
				System.out.println("paid");
				String paid=buff.readLine();
				s.setCourse(paid);
				System.out.println("id");
				int id6=buff.read();
				s.setId(id6);
				stmtedit= con.prepareStatement("update Stud set paid=? where id=?");
				stmtedit.setString(5,paid);
				stmtedit.setInt(1, id6);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");
				

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				break;
			case 6:
				System.out.println("due");
				String due=buff.readLine();
				s.setCourse(due);
				System.out.println("id");
				int id7=buff.read();
				s.setId(id7);
				stmtedit= con.prepareStatement("update Stud set due=? where id=?");
				stmtedit.setString(6,due);
				stmtedit.setInt(1, id7);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");
			

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				
				
				break;
			case 7:
				System.out.println("city");
				String city=buff.readLine();
				s.setCourse(city);
				System.out.println("id");
				int id8=buff.read();
				s.setId(id8);
				stmtedit= con.prepareStatement("update Stud set city=? where id=?");
				stmtedit.setString(7,city);
				stmtedit.setInt(1, id8);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				
				break;
			case 8:
				System.out.println("state");
				String state=buff.readLine();
				s.setCourse(state);
				System.out.println("id");
				int id9=buff.read();
				s.setId(id9);
				stmtedit= con.prepareStatement("update Stud set state=? where id=?");
				stmtedit.setString(8,state);
				stmtedit.setInt(1, id9);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				
				break;
			case 9:
				System.out.println("country");
				String country=buff.readLine();
				s.setCourse(country);
				System.out.println("id");
				int id10=buff.read();
				s.setId(id10);
				stmtedit= con.prepareStatement("update Stud set country=? where id=?");
				stmtedit.setString(9,country);
				stmtedit.setInt(1, id10);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				break;
			case 10:
				System.out.println("address");
				String address=buff.readLine();
				s.setCourse(address);
				System.out.println("id");
				int id11=buff.read();
				s.setId(id11);
				stmtedit= con.prepareStatement("update Stud set address=? where id=?");
				stmtedit.setString(10,address);
				stmtedit.setInt(1, id11);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");

				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				break;
			case 11:
				System.out.println("contact num");
				String contactno=buff.readLine();
				s.setCourse(contactno);
				System.out.println("id");
				int id12=buff.read();
				s.setId(id12);
				stmtedit= con.prepareStatement("update Stud set contactno=? where id=?");
				stmtedit.setString(11,contactno);
				stmtedit.setInt(1, id12);
				System.out.println(stmtedit.executeUpdate() + " No of Records Updated");
				
				 try{
			         if(stmtedit!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();

			      }
				

			default:System.out.println("No edit option choosen ");
				break;
			}
			
			
			
			System.out.println(stmtedit.executeUpdate() + " No of Records Updated");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void dueFees(BufferedReader buff, Student s,Connection con) {
		try {
			Statement stmt=null;
			stmt= con.createStatement();
			 String sql = "SELECT due FROM students.Stud";
		      ResultSet rs = stmt.executeQuery(sql);
		     
		      while(rs.next()){
		        
		         int due = rs.getInt("due");
		        

		         
		         System.out.print("duefees is: " + due+" ");
		       
		      }
		      rs.close();
		      try{
			         if(stmt!=null)
			            con.close();
			      }catch(SQLException se){
						se.printStackTrace();
  
			      }
		      
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void logot(BufferedReader buff, Student s,Connection con) {
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("succesfully logout");
	}

}
