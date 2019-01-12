package com.choosey.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.choosey.models.Category;
import com.choosey.models.Product;
@Repository  
@Transactional 
public class ProductDaoImpl implements ProductDao {
	@Autowired
 SessionFactory sessionFactory;
	
	
	public Product getProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
	
		return product;
	}
	public void deleteProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
		session.delete(product);
		
	}
	
	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product>products = query.list();
		return products;
	}
	public void saveorUpdate(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	public List<Category> getallCategories()
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		@SuppressWarnings("unchecked")
		List<Category> categories=query.list();
		return categories;
	}
	public List<Category> getAllCategories() {
	
		return null;
	}
	
	

}

