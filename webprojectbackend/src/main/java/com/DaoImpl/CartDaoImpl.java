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

@SuppressWarnings("unused")
@Repository("cartDao")
@Service

public class CartDaoImpl implements CartDao 
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(Cart cart)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
		
	}
	
	public List<Cart> findById(String userId)
	{
		Session session = sessionFactory.openSession();
		List<Cart> cr = null;
		try
		{
			session.beginTransaction();
			cr=(List<Cart>)session.createQuery("from Cart where userMailId=: email").setString("email", userId).list();
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
		}
		return cr;
	}
	
	public Cart getCartById(int cartId, String userEmail)
	{
		Session session = sessionFactory.openSession();
		Cart cr = null;
		session.beginTransaction();
		cr=(Cart)session.createQuery("from Cart where userMailId=:email and cartProductId=:id")
				.setString("email", userEmail).setInteger("id", cartId).uniqueResult();
		session.getTransaction().commit();
		return cr;
	}
	
	@Transactional
	public void deleteCart(int cartId)
	{
		Session session = sessionFactory.openSession();
		Cart cr = (Cart)session.get(Cart.class, cartId);
		session.delete(cr);
	}
	
	@Transactional
	public void updateCart(Cart cr)
	{
		Session session = sessionFactory.openSession();
		session.update(cr);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
