package com.hiberConfig;

import java.util.Properties;

import javax.sql.DataSource;

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

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;
import com.model.Category;
import com.model.Orders;
import com.model.Product;
import com.model.Supplier;
import com.model.User;

@ComponentScan(basePackages = "com")
@EnableTransactionManagement
@Configuration
public class HibernateConfiguration 
{
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dsource = new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/webap");
		dsource.setUsername("sa");
		dsource.setPassword("");
		return dsource;
	}

	public Properties hibernateProperties() {
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
		sb.addAnnotatedClass(Cart.class);
		sb.addAnnotatedClass(Orders.class);
		
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
	@Bean(name="userDaoImpl")
	public UserDaoImpl getUseData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="cartDaoImpl")
	public CartDaoImpl getCartData(SessionFactory sf)

	{
		return new CartDaoImpl(sf);
	}
	
	
	@Autowired
	@Bean(name="orderDaoImpl")
	public OrdersDaoImpl getOrdersData(SessionFactory sf)
	{
		return new OrdersDaoImpl(sf);
	}
	
	@Autowired
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getH2DataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
