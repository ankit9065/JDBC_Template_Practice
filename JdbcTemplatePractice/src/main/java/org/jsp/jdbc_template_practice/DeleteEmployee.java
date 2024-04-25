package org.jsp.jdbc_template_practice;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeleteEmployee {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        
        String qry = "delete from employee where id = ?";
        ApplicationContext context = new ClassPathXmlApplicationContext("Jdbc-template.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        int r = template.update(qry, id);
        
        System.out.println(r + " row deleted");
        ((ClassPathXmlApplicationContext)context).close();
        sc.close();
    }
}
