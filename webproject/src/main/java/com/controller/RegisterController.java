package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.UserDao;
import com.model.*;

@Controller
public class RegisterController {

	@Autowired
	UserDao userDao;

	@RequestMapping("/")
	public String index() {
		return "index";
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
		user.setRole("ROLE_USER");
		userDao.insertUser(user);// this will enter all data from register.jsp
									// to H2 TABLE
		mv.setViewName("redirect:/");
		return mv;
	}

}