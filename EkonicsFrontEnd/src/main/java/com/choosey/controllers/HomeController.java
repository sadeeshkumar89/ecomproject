
package com.choosey.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choosey.dao.CartItemDao;
import com.choosey.dao.ProductDao;
import com.choosey.models.CartItem;
import com.choosey.models.Category;

@Controller
public class HomeController {
	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	private ProductDao productDao;
	public HomeController(){
		System.out.println("homeController bean is created..");
	}
	
	// @RequestMapping("/home" )
	//public String homePage(){
		//return "homePage";
	//}
    @RequestMapping("/aboutus")
    public String aboutUs(){
    	return "aboutUsPage";
    }
    @RequestMapping("/login")
    public String login() {
    	return "login";
    	
    }
    @RequestMapping("/loginerror")
    public String loginError(Model model) {
    	model.addAttribute("loginError","Invalid Email/Password");
    	return "login";
    }
    @RequestMapping("/logoutsuccess")
    public String logoutSuccess(Model model) {
    	model.addAttribute("logoutSuccess", "LoggedOut Successfully");
    	return "login";
    }
    @RequestMapping("/home")
	public String homePage(@AuthenticationPrincipal Principal principal,HttpSession session,Model model){
        List<CartItem> cartItems=null;
    	if(principal!=null){
         cartItems=cartItemDao.getCartItems(principal.getName());
    	session.setAttribute("cartSize",cartItems.size());
    	
    	}
    	List<Category>categories=productDao.getAllCategories();
    	session.setAttribute("categories", categories);
		return "homePage";
	}
}