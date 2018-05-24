package service;

import java.util.List;

import domain.Product;

public interface ProductService {

	public void insertProduct(Product product);
	
	public Product getProductById(int id);
	
	public List<Product> getAllProducts();
	
	public void updateProduct(Product product);
	
	public void deleteProduct(int id);
	
	public List<Product> getAllFormattedProducts();
	
	public List<Product> getProductSearchedByDate(String startDate,String endDate);
	
	public List<Product> getAllProductLastXMonth(int Month);
}
