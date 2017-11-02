package com.controller;
/*package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.model.Category;
import com.model.User;

@Component
@RequestMapping("/admin")
public class adminController {

	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	@Autowired
	ProductDaoImpl prductDaoImpl;
	@Autowired
	CategoryDaoImpl categoryDaoImpl;

	@RequestMapping("/admin")
	public String addm()
	{
		return "admin";
	}

	
		@RequestMapping("/adding")
	public String addPage() 
	{
		return "adding";
	}

	@RequestMapping("/index")
	public String addHome()
	{
		return "index";
	}

	@RequestMapping(value="/saveCat", method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveCategory(@RequestParam("cid") int cid, @RequestParam("cname"))
	{
		ModelAndView mv = new ModelAndView();
		Category c = new Category();
		c.setCid(cid); //setter method invoked
		c.setCname(cname); //setter method invoked
		
		categoryDaoImpl.insertCategory(c); //insert() invoked from CategoryDaoImpl
		
		mv.setViewName("modal");
		return mv;
	}
}
*/