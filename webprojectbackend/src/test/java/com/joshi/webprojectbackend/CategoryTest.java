package com.joshi.webprojectbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.CategoryDao;
import com.model.Category;
import com.model.User;

public class CategoryTest 
{

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		Category category = (Category)context.getBean("category");
		
		/*category.setCid(1001);
		category.setCname("Junk Food");
		category.setDescription("Junk food @ 40% discount");
		
		category.setCid(1003);
		category.setCname("Healthy Food");
		category.setDescription("Healthy food @ 20% discount");
		*/
		
		CategoryDao dao = (CategoryDao)context.getBean("categoryDao");
		
		//dao.insertCategory(category);
		
		Category cate = dao.getCategoryBycid(1003);
		//System.out.println(cate.getCname() + " : " + cate.getDescription());
		
		//dao.deleteCategory(cate);	
		
		cate.setCname("YAKULT");
		dao.updateCategory(cate);
		
		context.close();
		
		
	}
		

	
}
