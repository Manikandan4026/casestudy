package com.fees.roport;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class AdminOperation extends FeesReport  {

	public void addAccountan(BufferedReader buff, Accountant ac,Connection con) {
		
		try {
		
		
			
			System.out.println("\nEnter your Name");
			String name = buff.readLine();
			System.out.println("Enter your Password");
			String password = buff.readLine();
			System.out.println("Enter your Email");
			String email = buff.readLine();
			System.out.println("Enter your contact no");
			int contactno = buff.read();
			System.out.println("Enter your id");
			int id = buff.read();
			
			ac.setName(name);
			ac.setPassword(password);
			ac.setEmail(email);
			ac.setContactno(contactno);
			ac.setId(id);
			
			
			
			PreparedStatement stmtInsert = con.prepareStatement("insert into students.accountant values(?,?,?,?,?)");
			stmtInsert.setInt(1, id);
			stmtInsert.setString(2, name);
			stmtInsert.setString(3, password);
			stmtInsert.setString(4, email);
			stmtInsert.setInt(5, contactno);

			System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");
			 try{
		         if(stmtInsert!=null)
		            con.close();
		      }catch(SQLException se){
		    	  
		      }
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	
		
		
	}

	public void viewAccountant(BufferedReader buff, Accountant ac,Connection con) {
		
		try {
			java.sql.Statement stmt=null;
			stmt= con.createStatement();
			 String sql = "SELECT * FROM students.Accountant";
		      ResultSet rs = stmt.executeQuery(sql);
		     
		      while(rs.next()){
		        
		         int id = rs.getInt("id");
		         String name = rs.getString("name");
		         String password = rs.getString("password");
		         String email = rs.getString("email");
		         int contactno = rs.getInt("contactno");
		        
		         System.out.println("Id"+" "+"Name"+" "+"Password  "+"email      "+"Contactnumber");
		         System.out.println(id+"   "+name+"     "+password+"       "+email+"       "+contactno);
		        /* System.out.print("id is: " + id +" ");
		         System.out.print("name is: " + name +" ");
		         System.out.print("password is: " + password +" ");
		         System.out.print("email is: " + email +" ");
		         System.out.print("contactno is: " + contactno +" \n");*/
		       
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
			
		
		
		

	}}
