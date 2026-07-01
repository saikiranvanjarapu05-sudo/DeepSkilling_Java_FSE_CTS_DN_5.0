package com.sample.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.sample")
@EnableTransactionManagement

public class AppConfig {

	@Bean
	public DataSource getDataSource()
	{ 
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springormDB");
		ds.setUsername("root");
		ds.setPassword("12345678");
		return ds;
			
	}
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setPackagesToScan("com.sample.Models");
		Properties pr=new Properties();
		pr.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		pr.put("hibernate.show_sql","true");
		pr.put("hibernate.hmb2ddl.auto","update");
		
		factory.setHibernateProperties(pr);
		return factory;
	}
	
	@Bean
	public HibernateTransactionManager getTransManager(SessionFactory sf)
	{
		return new HibernateTransactionManager(sf);
		
	}
	
	
	
	
}