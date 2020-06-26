package com.fees.roport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;



class MyReportClass <T> { 
	T obj;
	
	void create(T obj) { 
		this.obj = obj;
	}
	
	T getInstance() { 
		return obj;
	}
}


public class FeesReport {

	InputStreamReader isr = null;
	BufferedReader buff = null;
	AccountOperation aco = null;
	AdminOperation ado = null;
	
	boolean reportOpen = true;
	String secChoice;
	
	public static void main(String[] args) throws Exception {
		
		FeesReport fr=new FeesReport();
		
		fr.isr = new InputStreamReader(System.in);
		fr.buff = new BufferedReader(fr.isr);
		
		Class.forName("com.mysql.jdbc.Driver");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("connection is established");
		PreparedStatement stmt=null;
		
		
		do {
			
			Admin a=new Admin();
			Accountant ac=new Accountant();
			Student s= new Student();
			
			
			
			System.out.println("Welcome to FEES MANAGEMENT\n");
			System.out.println("SELECT  YOUR SECTION\n1. ADMIN\n2. ACCOUNTANT");
			String secChoice = fr.buff.readLine();
			
			String mOperationChoice, continueChoice;
			boolean report = true;
			
			switch(Integer.parseInt(secChoice))
			{
			case 1: MyReportClass<AdminOperation> obj = new MyReportClass<AdminOperation>();
					obj.create(new AdminOperation());
					fr.ado = obj.getInstance();
					do {
						System.out.println("SELECT  YOUR  Operation\n1. Add Accountant\n2. ViewAccountant");
						mOperationChoice = fr.buff.readLine();
						switch(Integer.parseInt(mOperationChoice)) {
						case 1: fr.ado.addAccountan(fr.buff, ac,con);
								break;
						case 2: fr.ado.viewAccountant(fr.buff, ac,con);
								break;
						
						default: System.out.println("No Operation Choice Selected");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = fr.buff.readLine();
						if(continueChoice.equalsIgnoreCase("No"))
							report = false;
						
					}while(report);
					break;
			
			case 2: MyReportClass<AccountOperation> obj1 = new MyReportClass<AccountOperation>();
					obj1.create(new AccountOperation());
					fr.aco = obj1.getInstance();
					do {
						System.out.println("SELECT  YOUR  Operation\n1. ADD STUDENT\n2. VIEW STUDENT\n3. EDIT STUDENT\n4. DUE FEES\n5. Logout");
						mOperationChoice = fr.buff.readLine();
						switch(Integer.parseInt(mOperationChoice)) {
						case 1:fr.aco.addStudent(fr.buff, s,con);
								break;
						case 2: fr.aco.viewStudent(fr.buff, s,con);
								break;
						case 3: fr.aco.editStudent(fr.buff, s,con);
								break;
						case 4:  fr.aco.dueFees(fr.buff, s,con);
								break;
						case 5:  fr.aco.logot(fr.buff, s,con);
								break;		
						default: System.out.println("No Operation Choice Selected");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = fr.buff.readLine();
						if(continueChoice.equalsIgnoreCase("No"))
							report = false;
						
					}while(report);
					break;
			
			
			
			default: System.out.println("No Choice of Bank Done");
			}
			System.out.println("Do you Want to End Section Selection\nYes\nNo");
			fr.secChoice = fr.buff.readLine();
			if(fr.secChoice.equalsIgnoreCase("Yes"))
				fr.reportOpen = false;
			
			
			
			
			
			
			
			
			
		}while(fr.reportOpen);
		
		
		
	}
	
	
	
	
}
