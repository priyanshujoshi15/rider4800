package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDao;
import com.model.Product;
@SuppressWarnings(value="deprecation")
@Repository(value="productDaoImpl")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean insertProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(int product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product getProductBypid(int pid) {
		return sessionFactory.getCurrentSession().get(Product.class, pid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

}
