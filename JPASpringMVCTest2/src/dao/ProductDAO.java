package dao;

import java.util.Date;
import java.util.List;

import domain.Product;

public interface ProductDAO {
	
	public void insertProduct(Product product);
	
	public Product getProductById(int id);
	
	public List<Product> getAllProdcts();
	
	public void updateProduct(Product product);
	
	public void deleteProduct(int id);
	
	public List<Product> getProductSearchedByDate(Date startDate,Date endDate);
}
