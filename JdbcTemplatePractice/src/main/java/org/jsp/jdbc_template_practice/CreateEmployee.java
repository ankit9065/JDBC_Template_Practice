package org.jsp.jdbc_template_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateEmployee {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		template.execute("create table employee (id int not null, name varchar(20) not null, salary decimal not null, designation varchar(25) not null, primary key(id))");
		System.out.println("Table created");
		((ClassPathXmlApplicationContext)context).close();
	}
}
