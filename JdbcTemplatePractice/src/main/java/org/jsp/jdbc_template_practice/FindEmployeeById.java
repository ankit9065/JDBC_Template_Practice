package org.jsp.jdbc_template_practice;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FindEmployeeById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Employee Id: ");
		int id = sc.nextInt();
		String dql = "select * from employee where id=?";
		ApplicationContext context = new ClassPathXmlApplicationContext("Jdbc-template.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        ResultSetExtractor<String> res = rs->{
        	if(rs.next()) {
//        		System.out.println("Employee Id: " + rs.getInt(1));
        		System.out.println("Employee Name: " + rs.getString(2));
        		System.out.println("Employee Salary: " + rs.getDouble(3));
        		System.out.println("Employee Designation: " + rs.getString(4));
        		return "Employee Found...";
        	}
        	else
        		return "Invalid Employee Id";
        };
        String message = template.query(dql, new Object[] {id}, res);
        System.out.println(message);
        ((ClassPathXmlApplicationContext)context).close();
        sc.close();
	}
}
