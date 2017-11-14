package com.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.model.Category;
import com.model.Supplier;

@RequestMapping("/admin")
@Controller
public class adminController 
{
	@Autowired
	SupplierDao supplierDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

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
		categoryDao.insertCategory(cc);
		mav.setViewName("modal");
		return mav;
	}

	@RequestMapping(value = "/saveSupp", method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveSupplier(@RequestParam("sid") int sid, @RequestParam("sname") String sname) {
		ModelAndView mav = new ModelAndView();
		Supplier ss = new Supplier();
		ss.setSid(sid);
		ss.setSname(sname);
		supplierDao.insertSupplier(ss);
		mav.setViewName("modal");
		return mav;
	}

	/*@RequestMapping(value="/saveProd", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveProducts(HttpServletRequest request, @RequestParam("pname") String pname ,@RequestParam("description") String description, @RequestParam("price") int price, @RequestParam("stock") int stock)  
	{
		Product prod = new Product();
		prod.setPname(request.getParameter("pname"));
		prod.setPrice(Float.parseFloat(request.getParameter("price")));
		prod.setDescription(request.getParameter("description"));
		prod.setStock(Integer.parseInt(request.getParameter("stock")));
		prod.setCategory(categoryDaoImpl.getCategoryBycid(Integer.parseInt(request.getParameter("cid"))));
		prod.setSupplier(supplierDaoImpl.getSupplierByid(Integer.parseInt(request.getParameter("sid"))));
		
		String filepath=request.getSession().getServletContext().getRealPath("file");
		String filename = file.getOriginalFilename(); //imagename
		prod.setImgname(filename);
		productDaoImpl.insertProduct(prod);
		System.out.println("File path file" + filepath + " " + filename);
		try
		{
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream
									   (new FileOutputStream(filepath+""));
		}
		
		
		
		
		
		
		
		
		
		
		
		return null;
		
	}*/
	
	@ModelAttribute
	public Model addData(Model m)
	{
		m.addAttribute("catList", categoryDao.getAllCategories());
		m.addAttribute("prodList", productDao.getAllProducts());
		return m;
	}
}
