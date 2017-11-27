package com.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.OrdersDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.Dao.UserDao;
import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Product;

@Controller
public class cartController 
{
	@Autowired
	SupplierDaoImpl supplierDaoImpl;

	@Autowired
	ProductDaoImpl productDaoImpl;

	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	OrdersDaoImpl orderDaoImpl;
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@RequestMapping(value="/prodDetails/{pid}")
	public ModelAndView productDetails(@PathVariable("pid") int pid)
	{
		ModelAndView mv = new ModelAndView();
		Product p= productDaoImpl.getProductBypid(pid);
		mv.addObject("product,p");
		mv.setViewName("prodDetails");
		return mv;
	}
	
	@RequestMapping(value="/addCart", method=RequestMethod.POST)
	public ModelAndView addtoCart(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		return mv;
	}
					
	/*@RequestMapping(value="/deletePCart/{cartId}")
	public ModelAndView deleteCartItem(@PathVariable("cartId") int cartId, HttpServletRequest req)
	{
		ModelAndView mv = new ModelAndView();
		Principal principal = req.getUserPrincipal();
		String userEmail = principal.getName();
		CartDaoImpl.delete(cartId);
		mv.addObject("cartInfo", cart);
		mv.setViewName("Cart");
		return mv;
	}
*/
		

	
	
	
	
	
	
	
	
	
}
