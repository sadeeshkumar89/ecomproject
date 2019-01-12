package com.choosey.dao;

import java.util.List;

import com.choosey.models.Category;
import com.choosey.models.Product;

public interface ProductDao {
void saveorUpdate(Product product);
Product getProduct(int id);
void deleteProduct(int id);
List<Product>getAllProducts();
List<Category> getAllCategories();

}
