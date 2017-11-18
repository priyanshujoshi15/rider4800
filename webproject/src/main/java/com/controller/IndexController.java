package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.Dao.UserDao;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.*;

@Controller
public class indexController {

	@Autowired
	UserDao userDaoImpl;

	@Autowired
	SupplierDao supplierDaoImpl;

	@Autowired
	ProductDao productDaoImpl;

	@Autowired
	CategoryDao categoryDaoImpl;

	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";// You can redirect wherever you want,
										// but generally it's a good practice to
										// show login screen again.
	}

	@RequestMapping("/userLogged")
	public String userLogged() {
		return "redirect:/index" ;
	}

	@RequestMapping("/error")
	public String errorPage() {
		return "/error";
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/index")
	public String addHome() {
		return "index";
	}

	@RequestMapping("/goTologin")
	public ModelAndView goToLogin() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new User());
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView goToRegister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("register");
		return mv;
	}

	@RequestMapping(value = "/saveRegister", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user, BindingResult res) {
		ModelAndView mv = new ModelAndView();
		if (res.hasErrors()) {
			mv.setViewName("register");
			return mv;
		} else {
			userDaoImpl.insertUser(user);// this will enter all data from
										// register.jsp
										// to H2 TABLE
			mv.setViewName("index");
			return mv;
		}

	}

	@RequestMapping("/productCustList")
	public ModelAndView productCustList(@RequestParam("cid") int cid) {
		System.out.println(cid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", productDaoImpl.getProductBypid(cid));
		mav.setViewName("productCustList");
		return mav;
	}

	@ModelAttribute
	public void fetchData(Model m) {
		m.addAttribute("catList", categoryDaoImpl.getAllCategories());

		m.addAttribute("prodList", productDaoImpl.getAllProducts());

		m.addAttribute("supList", supplierDaoImpl.getAllSuppliers());
	}
}