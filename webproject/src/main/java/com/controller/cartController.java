package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CartDao;
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
import com.model.Cart;
import com.model.Orders;
import com.model.Product;
import com.model.User;
@SuppressWarnings("unused")
@Controller
public class cartController {
	@Autowired
	SupplierDaoImpl supplierDaoImpl;

	@Autowired
	ProductDaoImpl productDaoImpl;

	@Autowired
	CategoryDaoImpl categoryDaoImpl;

	@Autowired
	OrdersDaoImpl ordersDaoImpl;

	@Autowired
	UserDaoImpl userDaoImpl;

	@Autowired
	CartDaoImpl cartDaoImpl;

	@RequestMapping(value = "/prodDetails/{pid}")
	public ModelAndView productDetails(@PathVariable("pid") int pid) {
		ModelAndView mv = new ModelAndView();
		Product p = productDaoImpl.getProductBypid(pid);
		mv.addObject("product,p");
		mv.setViewName("prodDetails");
		return mv;
	}

	@RequestMapping(value = "/addtoCart", method = RequestMethod.POST)
	public ModelAndView addtoCart(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();

		try {
			int pid = Integer.parseInt(request.getParameter("pId"));
			Double price = Double.parseDouble(request.getParameter("pPrice"));
			int qty = Integer.parseInt(request.getParameter("quant"));
			String prodName = request.getParameter("name");
			String imgName = request.getParameter("imgname");

			Cart cartExists = cartDaoImpl.getCartById(qty, userEmail);
			if (cartExists == null) {
				Cart cm = new Cart();
				cm.setCartPrice(price);
				;
				cm.setCartProductId(pid);
				cm.setCartQuantity(qty);
				cm.setCartImage(imgName);
				cm.setCartProductName(prodName);

				User u = userDaoImpl.getUserByEmail(userEmail);

				cm.setCartUserDetails(u);
				cartDaoImpl.insert(cm);
			} else if (cartExists != null) {
				Cart cm = new Cart();
				cm.setCartId(cartExists.getCartId());
				cm.setCartPrice(price);
				;
				cm.setCartProductId(pid);
				cm.setCartQuantity(cartExists.getCartQuantity() + qty);
				cm.setCartImage(imgName);
				cm.setCartProductName(prodName);

				User u = userDaoImpl.getUserByEmail(userEmail);

				cm.setCartUserDetails(u);
			}

			mv.addObject("cartInfo", cartDaoImpl.findById(userEmail));
			mv.setViewName("Cart");
		}
		catch (Exception e) {
			mv.addObject("cartInfo", cartDaoImpl.findById(userEmail));
			mv.setViewName("Cart");	
		}
		return mv;
	}

	/*
	 * @RequestMapping(value="/deletePCart/{cartId}") public ModelAndView
	 * deleteCartItem(@PathVariable("cartId") int cartId, HttpServletRequest
	 * req) { ModelAndView mv = new ModelAndView(); Principal principal =
	 * req.getUserPrincipal(); String userEmail = principal.getName();
	 * CartDaoImpl.delete(cartId); mv.addObject("cartInfo", cart);
	 * mv.setViewName("Cart"); return mv; }
	 */

	@RequestMapping(value = "/invoiceprocess", method = RequestMethod.POST)
	public ModelAndView ordersSaved(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("invoice");
		Orders ord = new Orders();

		Principal principal = req.getUserPrincipal();
		String userEmail = principal.getName();

		Double total = Double.parseDouble(req.getParameter("total"));
		String payment = req.getParameter("payment");
		List<Cart> cart = cartDaoImpl.findById(userEmail);
		User user = userDaoImpl.getUserByEmail(userEmail);
		ord.setUser(user);
		ord.setTotal(total);
		ord.setPayment(payment);
		ordersDaoImpl.insertOrders(ord);
		mv.addObject("user", userDaoImpl.getUserByEmail(userEmail));
		mv.addObject("orderDetails", user);
		mv.addObject("cart", cart);
		return mv;

	}

	@RequestMapping("/ack")
	public String ack() {
		return "ack";
	}

	@RequestMapping(value = "/goToCart", method = RequestMethod.GET)
	public ModelAndView gotocart(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();

		Principal principal = req.getUserPrincipal();
		String userEmail = principal.getName();
		mv.addObject("cartInfo", cartDaoImpl.findById(userEmail));
		mv.setViewName("Cart");
		return mv;
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView goToCheckout(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Principal principal = req.getUserPrincipal();
		String userEmail = principal.getName();
		User user = userDaoImpl.getUserByEmail(userEmail);
		List<Cart> cart = cartDaoImpl.findById(userEmail);
		mv.addObject("user", user);
		mv.setViewName("cart");
		return mv;
	}

}
