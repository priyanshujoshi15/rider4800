package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.UserDao;
import com.model.User;

@Repository("userDaoImpl")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired // this annotation will mark the object as singleton, i.e for
				// only one user, one session factory will be invoked
	SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean insertUser(User user) // this method will be called from the
											// controller of the front end
	{
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteUser(int user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public User getUserByEmail(String email) {

		return sessionFactory.getCurrentSession().get(User.class, email);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public boolean validateUser(String email, String pswd) {
		String sql = "from User where email='"+email+"' and password='"+pswd+"'";
		User u = (User)sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
		
		if(u!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
