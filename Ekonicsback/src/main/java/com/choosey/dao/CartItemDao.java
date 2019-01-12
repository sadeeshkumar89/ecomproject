package com.choosey.dao;

import java.util.List;
import com.choosey.models.CartItem;
import com.choosey.models.User;

public interface CartItemDao {
void addToCart(CartItem cartItem);
User getUser(String email);
List<CartItem> getCartItems(String email);
void removeCartItem(int cartItemId);
void updateCartItem(int cartItemId, int requestedQuantity);
//CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}