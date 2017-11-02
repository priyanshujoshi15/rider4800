package com.joshi.webprojectbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.UserDao;
import com.model.User;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		User user = (User)context.getBean("user");
		/*
		user.setName("niit");
		user.setAddress("Rajori");
		user.setEmail("niit@gmail.com");
		user.setPassword("123456");
		*/
		
		UserDao dao = (UserDao)context.getBean("userDao");
		//dao.insertUser(user);
		
		User usr = dao.getUserByEmail("oii");
		//System.out.println(usr.getEmail()+" : "+usr.getName());
		
		//dao.deleteUser(usr);
		
		usr.setName("oop");
		dao.updateUser(usr);
		
		context.close();
}
}
