package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.UserDao;
import com.model.*;

@Controller
public class IndexController {

	@Autowired
	UserDao userDao;

/*	@RequestMapping("/")
	public String index() {
		return "index";
	}
*/
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
		user.setRole("ROLE_USER");
		userDao.insertUser(user);// this will enter all data from register.jsp
									// to H2 TABLE
		mv.setViewName("redirect:/login");
		return mv;
	}

	/*@RequestMapping(value = "/login")
	public String loginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user) {
		boolean status = userDao.validateUser(user.getEmail(), user.getPassword());
		if (status) 
		{
			return "index";
		} 
		else 
		{
			return "register";
		}
	}
*/
}