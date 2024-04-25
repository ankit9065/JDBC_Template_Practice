package org.jsp.jdbc_template_practice;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter Employee ID to update details: ");
            int id = sc.nextInt();
            
            System.out.println("Enter New Employee Details: ");
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            System.out.print("Enter Designation: ");
            String designation = sc.next();
            
            ApplicationContext context = new ClassPathXmlApplicationContext("Jdbc-template.xml");
            JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
            
            String query = "UPDATE employee SET name=?, salary=?, designation=? WHERE id=?";
            
            int rowsUpdated = template.update(query, name, salary, designation, id);
            System.out.println(rowsUpdated + " rows updated successfully.");
            ((ClassPathXmlApplicationContext)context).close();
        } 
        catch (Exception e) {
            System.err.println("Invalid Id for update");
        } sc.close();
    }
}
