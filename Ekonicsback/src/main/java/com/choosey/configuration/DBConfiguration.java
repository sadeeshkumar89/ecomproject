package com.choosey.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.choosey.models.Authorities;
//import com.choosey.models.BillingAddress;
//import com.choosey.models.Category;
//import com.choosey.models.Customer;
//import com.choosey.models.Product;
//import com.choosey.models.ShippingAddress;
//import com.choosey.models.User;

@Configuration
@EnableTransactionManagement
public class DBConfiguration
{
	
	
	@Bean
	public DataSource getdataSource()
	{
		BasicDataSource dataSource= new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/Ekonics");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		System.out.println("dataSource bean is created");
		return dataSource;
		
		
		
	}
	
	@Bean
	public SessionFactory sessionFactory()
	{
		LocalSessionFactoryBuilder lsf= new LocalSessionFactoryBuilder(getdataSource());
		Properties hibernateProperties= new Properties();
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		hibernateProperties.setProperty("hibernate.show_sql","true");
		
		lsf.addProperties(hibernateProperties);
		
		lsf.scanPackages("com.choosey.*");
		System.out.println("session factory object");
		//Class classes[]=new Class[] {Authorities.class,BillingAddress.class,Category.class,Customer.class,Product.class,ShippingAddress.class,User.class};
		return lsf.buildSessionFactory();

	
	}
	@Bean
	public HibernateTransactionManager hibTransManagement()
	{
		System.out.println("transaction");
		return new HibernateTransactionManager(sessionFactory());
	}
}
