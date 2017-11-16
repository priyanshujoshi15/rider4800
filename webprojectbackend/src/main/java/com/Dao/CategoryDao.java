package com.Dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao 
{
	public boolean insertCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int category);
	
	public Category getCategoryBycid(int cid);
	
	public List<Category> getAllCategories();
	
}
