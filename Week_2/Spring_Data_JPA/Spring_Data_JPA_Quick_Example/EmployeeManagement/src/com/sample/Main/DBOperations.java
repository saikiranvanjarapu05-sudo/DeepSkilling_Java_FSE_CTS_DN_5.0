package com.sample.Main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.config.AppConfig;
import com.sample.DAO.EmployeeDAO;
import com.sample.Models.Employee;

public class DBOperations {
	
	public static ApplicationContext context=
			new AnnotationConfigApplicationContext(AppConfig.class);
	
	public static EmployeeDAO dao=context.getBean(EmployeeDAO.class);

	public static Scanner sc=new Scanner(System.in);
	
	public static void Insert()
	{
		System.out.println("Enter Name:");
		String name=sc.nextLine();
		
		System.out.println("Enter Designation:");
		String designation=sc.nextLine();
		
		System.out.println("Enter Age:");
		int age=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter City:");
		String city=sc.nextLine();
		
		dao.Save(new Employee(0, name,designation,age,city));
		
	}
	
	public static void Update()
	{
		System.out.println("Enter Id:");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Name:");
		String name=sc.nextLine();
		
		System.out.println("Enter Designation:");
		String designation=sc.nextLine();
		
		System.out.println("Enter Age:");
		int age=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter City:");
		String city=sc.nextLine();
		
		dao.Update(new Employee(id, name,designation,age,city));
		
	}
	
	public static void GetData()
	{
		for(var emp:dao.GetAll())
		{
			System.out.println(emp);
		}
	}
	
	public static void Delete()
	{
		System.out.println("Enter Id:");
		int id=sc.nextInt();
		sc.nextLine();
		
		dao.Delete(id);
	}
	
	public static void main(String[] args) {
		boolean x=true;
		while(x)
		{
			System.out.println("******* EMPLOYEE MANAGEMENT *******");
			System.out.println("1.Add\n2.Update\n3.Delete\n4.Get Data\n0.Exit\nEnter Your Choice:");
			int n=sc.nextInt();
			sc.nextLine();
			
			switch(n)
			{
			case 0: x=false; 
			        System.out.println("Existing Application...");
			        break;
			case 1: Insert();GetData();break;
			case 2:GetData();Update();GetData();break;
			case 3:GetData();Delete();GetData();break;
			case 4:GetData();break;
			default: System.out.println("Wrong Input!");break;
			}
		}

	}

}

  