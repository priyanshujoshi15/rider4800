package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CartDao;
import com.Dao.CategoryDao;
import com.model.Cart;
import com.model.Category;
import com.model.Orders;

@SuppressWarnings(value="deprecation")
@Repository(value="orderDaoImpl")
@Transactional
public class OrdersDaoImpl
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public OrdersDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean insertOrders(Orders order) {
		try {
			sessionFactory.getCurrentSession().save(order);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
