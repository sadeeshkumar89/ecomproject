package com.choosey.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.choosey.dao.CartItemDao;
import com.choosey.dao.ProductDao;
import com.choosey.models.CartItem;
import com.choosey.models.Customer;
import com.choosey.models.CustomerOrder;
import com.choosey.models.Product;
import com.choosey.models.ShippingAddress;
import com.choosey.models.User;

@Controller
public class CartItemController {
	@Autowired
private CartItemDao cartItemDao;
@Autowired
private ProductDao productDao;
	
@RequestMapping(value="/cart/addtocart/{productId}")
public String addToCart(@PathVariable int productId,
		@RequestParam int requestedQuantity,@AuthenticationPrincipal Principal principal){//get two values from jsp page
	
	String email="";
	if(principal!=null)
	email=principal.getName();
	Product product=productDao.getProduct(productId);
	User user=cartItemDao.getUser(email);
	
	CartItem cartItem=new CartItem();
	cartItem.setQuantity(requestedQuantity);
	cartItem.setProduct(product);
	cartItem.setTotalPrice(product.getPrice()*requestedQuantity);
	cartItem.setUser(user);
	cartItemDao.addToCart(cartItem);
	return "redirect:/cart/getcartitems";
}
@RequestMapping("/cart/getcartitems")
public String getCartItems(@AuthenticationPrincipal Principal principal,Model model,HttpSession session	){
	List<CartItem> cartItems=null;
	if(principal!=null)
	cartItems=cartItemDao.getCartItems(principal.getName());
	session.setAttribute("cartSize", cartItems.size());
	model.addAttribute("cartItems",cartItems);
	return "cart";
}
@RequestMapping("/cart/updatecartitem")
public String updateCartItem(@RequestParam int cartItemId,@RequestParam int requestedQuantity){
	System.out.println(cartItemId + " " + requestedQuantity);
	cartItemDao.updateCartItem(cartItemId,requestedQuantity);
	return "redirect:/cart/getcartitems";
}

@RequestMapping(value="/cart/removecartitem/{cartItemId}")
public String removeCartItem(@PathVariable int cartItemId){
    cartItemDao.removeCartItem(cartItemId);
	return "redirect:/cart/getcartitems";
}

@RequestMapping(value="/cart/clearcart")
public String clearCart(@AuthenticationPrincipal Principal principal){
	@SuppressWarnings("unused")
	List<CartItem> cartItems=cartItemDao.getCartItems(principal.getName());
	return "redirect:/cart/getcartitems";
}

@RequestMapping(value="/cart/getshippingaddressform")
public String getShippingAddressForm(@AuthenticationPrincipal Principal principal,Model model){
    String email=principal.getName();
    //GET SHIPPING ADDRESS
    User user=cartItemDao.getUser(email);
    Customer customer=user.getCustomer();
    ShippingAddress shippingAddress=customer.getShippingAddress();
    model.addAttribute("shippingaddress",shippingAddress);
	return "shippingaddressform";
}

@RequestMapping(value="/cart/createorder")
public String createCustomerOrder(@ModelAttribute ShippingAddress shippingAddress,
		Model model,
		@AuthenticationPrincipal Principal principal,HttpSession session){
	//set updated shippingaddress in customer object 
	
	String email=principal.getName();
	User user=cartItemDao.getUser(email);
	Customer customer=user.getCustomer();
	customer.setShippingAddress(shippingAddress);
	
	user.setCustomer(customer);
	customer.setUser(user);
	
	CustomerOrder customerOrder=new CustomerOrder();
	customerOrder.setPurchaseDate(new Date());
	customerOrder.setUser(user);
	
	List<CartItem> cartItems=cartItemDao.getCartItems(email);
	double grandTotal=0.0;
	for(CartItem cartItem:cartItems){
		grandTotal=cartItem.getTotalPrice()+grandTotal;
	}
	customerOrder.setGrandTotal(grandTotal);
	
	return "orderdetails";
}

}


