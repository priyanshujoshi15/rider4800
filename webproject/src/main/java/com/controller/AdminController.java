package com.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
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

@RequestMapping("/admin")
@Controller
public class adminController 
{
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

	@RequestMapping(value="/saveProd", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveProducts(HttpServletRequest request, @RequestParam("file") MultipartFile file )  
	{	
		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		p.setPname(request.getParameter("pname"));
		p.setPrice(Float.parseFloat(request.getParameter("price")));
		p.setDescription(request.getParameter("description"));
		p.setStock(Integer.parseInt(request.getParameter("stock")));
		p.setCategory(categoryDaoImpl.getCategoryBycid(Integer.parseInt(request.getParameter("cid"))));
		p.setSupplier(supplierDaoImpl.getSupplierByid(Integer.parseInt(request.getParameter("sid"))));
		
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename(); //imagename
		p.setImgname(filename);
		productDaoImpl.insertProduct(p);
		System.out.println("Filepath" + filepath + " " + filename);
		try
		{
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream
									   (new FileOutputStream(filepath + "/images/" + filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		mv.setViewName("adding");
		return mv;
	}
	
	@ModelAttribute
	public Model addData(Model m)
	{
		m.addAttribute("catList", categoryDaoImpl.getAllCategories());
		m.addAttribute("prodList", productDaoImpl.getAllProducts());
		return m;
	}
}
