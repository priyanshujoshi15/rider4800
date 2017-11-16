package com.hiberConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;
import com.model.User;

@ComponentScan(basePackages = "com")
@EnableTransactionManagement
@Configuration
public class HibernateConfiguration 
{
	@Autowired
	@Bean/*(name="datasource")*/
	public DataSource dataSource() {
		DriverManagerDataSource dsource = new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/webap");
		dsource.setUsername("sa");
		dsource.setPassword("");
		return dsource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFac(DataSource datasource) {
		LocalSessionFactoryBuilder sb = new LocalSessionFactoryBuilder(datasource);
		sb.addProperties(hibernateProperties());
		sb.addAnnotatedClass(User.class);
		sb.addAnnotatedClass(Category.class);
		sb.addAnnotatedClass(Product.class);
		sb.addAnnotatedClass(Supplier.class);
		return sb.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="supplierDaoImpl")
	public SupplierDaoImpl getSuppData(SessionFactory sf)
	{
		return new SupplierDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="categoryDaoImpl")
	public CategoryDaoImpl getCatData(SessionFactory sf)
	{
		return new CategoryDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="productDaoImpl")
	public ProductDaoImpl getProdData(SessionFactory sf)
	{
		return new ProductDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="UserDaoImpl")
	public UserDaoImpl getUseData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
