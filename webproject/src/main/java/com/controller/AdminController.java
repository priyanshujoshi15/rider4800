package com.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;
@SuppressWarnings("unused")
@RequestMapping("/admin")
@Controller
public class adminController {
	@Autowired
	SupplierDaoImpl supplierDaoImpl;

	@Autowired
	ProductDaoImpl productDaoImpl;

	@Autowired
	CategoryDaoImpl categoryDaoImpl;

	@RequestMapping("/adding")
	public String addPage() {
		return "adding";
	}

	@RequestMapping("/index")
	public String addHome() {
		return "index";
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/error")
	public String errorPage() {
		return "/error";
	}

	@RequestMapping("/userLogged")
	public String userLogged() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/saveCat", method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveCategory(@RequestParam("cid") int cid, @RequestParam("cname") String cname) {
		ModelAndView mav = new ModelAndView();
		Category cc = new Category();
		cc.setCid(cid);
		cc.setCname(cname);
		categoryDaoImpl.insertCategory(cc);
		mav.setViewName("adding");
		return mav;
	}

	@RequestMapping(value = "/saveSupp", method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveSupplier(@RequestParam("sid") int sid, @RequestParam("sname") String sname) {
		ModelAndView mav = new ModelAndView();
		Supplier ss = new Supplier();
		ss.setSid(sid);
		ss.setSname(sname);
		supplierDaoImpl.insertSupplier(ss);
		mav.setViewName("adding");
		return mav;
	}

	@RequestMapping(value = "/saveProd", method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveProducts(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		p.setPname(request.getParameter("pname"));
		p.setPrice(Float.parseFloat(request.getParameter("price")));
		p.setDescription(request.getParameter("description"));
		p.setStock(Integer.parseInt(request.getParameter("stock")));
		p.setCategory(categoryDaoImpl.getCategoryBycid(Integer.parseInt(request.getParameter("cid"))));
		p.setSupplier(supplierDaoImpl.getSupplierByid(Integer.parseInt(request.getParameter("sid"))));

		String filepath = request.getSession().getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename(); // imagename
		p.setImgname(filename);
		productDaoImpl.insertProduct(p);
		System.out.println("Filepath" + filepath + " " + filename);
		try {
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(
					new FileOutputStream(filepath + "/resources/images/" + filename));
			fos.write(imagebyte);
			fos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		mv.setViewName("adding");
		return mv;
	}

	@ModelAttribute
	public Model addData(Model m) {
		m.addAttribute("catList", categoryDaoImpl.getAllCategories());
		m.addAttribute("prodList", productDaoImpl.getAllProducts());
		return m;
	}

	@RequestMapping("/productList")
	public ModelAndView productList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prodlist", productDaoImpl.getAllProducts());
		mav.setViewName("productList");
		return mav;
	}

	@RequestMapping("/deleteProduct/{pid}")
	public String deleteProd(@PathVariable("pid") int pid) {
		productDaoImpl.deleteProduct(pid);
		return "redirect:/admin/productList?del";
	}

	@RequestMapping("/updateProduct")
	public ModelAndView updateProd(@RequestParam("pid") int pid) {
		ModelAndView mv = new ModelAndView();
		Product p = productDaoImpl.getProductBypid(pid);
		mv.addObject("prod", p);
		mv.addObject("cList", categoryDaoImpl.getAllCategories());
		mv.addObject("slist", supplierDaoImpl.getAllSuppliers());
		mv.setViewName("updateProduct");
		return mv;
	}

	@RequestMapping("/catList")
	public ModelAndView categoryList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("catList", categoryDaoImpl.getAllCategories());
		mv.setViewName("categoryList");
		return mv;
	}

	@RequestMapping("/deleteCat/{cid}")
	public String deleteCategory(@PathVariable("cid") int cid) {
		categoryDaoImpl.deleteCategory(cid);
		return "redirect:/admin/cattList?del";
	}

	@RequestMapping("/updateCat")
	public ModelAndView updateCat(@RequestParam("cid") int cid) {
		ModelAndView mv = new ModelAndView();
		Category c = categoryDaoImpl.getCategoryBycid(cid);
		mv.addObject("cList", categoryDaoImpl.getAllCategories());
		mv.setViewName("updateCategory");
		return mv;
	}

	@RequestMapping("/updateCategory")
	@Transactional
	public ModelAndView updateCategory(@RequestParam("cid") int cid, @RequestParam("cname") String cname) {
		ModelAndView mv = new ModelAndView(); // this method maps model with the
												// view
		Category c = new Category(); // creating the model class object, c
		c.setCid(cid);
		c.setCname(cname);
		categoryDaoImpl.updateCategory(c);
		mv.setViewName("redirect:/admin/categoryList?update");
		return mv;
	}

	@RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
	public ModelAndView updateProduct(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView();

		String pid = request.getParameter("pid");
		String pname = request.getParameter("pName");
		String ct = request.getParameter("pCategory");
		String sp = request.getParameter("pSupplier");
		String p = request.getParameter("pPrice");
		String d = request.getParameter("pDescription");
		String q = request.getParameter("pStock");

		Product prod2 = new Product();
		prod2.setPid(Integer.parseInt(pid));
		prod2.setPname(pname);
		prod2.setCategory(categoryDaoImpl.getCategoryBycid(Integer.parseInt(ct)));
		prod2.setCategory(categoryDaoImpl.getCategoryBycid(Integer.parseInt(sp)));
		prod2.setPrice(Float.parseFloat(p));
		prod2.setDescription(d);
		prod2.setStock(Integer.parseInt(q));

		String filepath = request.getSession().getServletContext().getRealPath("/");

		String filename = file.getOriginalFilename();
		prod2.setImgname(filename);
		productDaoImpl.updateProduct(prod2);
		System.out.println("File path" + filepath + " " + filename);

		try {
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(
					new FileOutputStream(filepath + "/resources/images/" + filename));
			fos.write(imagebyte);
			fos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		mv.setViewName("redirect:/admin/productList?update");
		return mv;

	}

}
