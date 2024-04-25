package org.jsp.jdbc_template_practice;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveEmployee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Details: ");
		
		System.out.print("Enter Id: ");
		int id = sc.nextInt();
		System.out.print("Enter Name: ");
		String name = sc.next();
		System.out.print("Enter Salary: ");
		double salary = sc.nextDouble();
		System.out.print("Enter Desg: ");
		String desg = sc.next();
		
		String qry = "insert into employee values(?,?,?,?)";
		ApplicationContext context = new ClassPathXmlApplicationContext("Jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		
		int r = template.update(qry, id, name, salary, desg);
		System.out.println(r + " rows inserted");
		((ClassPathXmlApplicationContext)context).close();
		sc.close();
	}
}
