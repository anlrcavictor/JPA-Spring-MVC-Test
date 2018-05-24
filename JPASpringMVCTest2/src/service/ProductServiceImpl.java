package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ManufacturerDAOImpl;
import dao.ProductDAOImpl;
import domain.Manufacturer;
import domain.Product;
import utility.Utility;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAOImpl productDAOImpl;
	
	@Autowired
	private ManufacturerDAOImpl manufacturerDAOImpl; 
	
	@Override
	public void insertProduct(Product product) {
		Manufacturer man=manufacturerDAOImpl.getManufacturerByName(product.getManufacturerName());
		product.setManufacturer(man);
		product.setAddedDate(Utility.convertToDate(product.getTransDate()));
		System.out.println(product);
		productDAOImpl.insertProduct(product);
	}

	@Override
	public Product getProductById(int id) {
		return productDAOImpl.getProductById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDAOImpl.getAllProdcts();
	}

	@Override
	public void updateProduct(Product product) {
		productDAOImpl.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(int id) {
		productDAOImpl.deleteProduct(id);
	}

	@Override
	public List<Product> getAllFormattedProducts() {
		List<Product> formattedProducts=new ArrayList();
		
	for(Product p : productDAOImpl.getAllProdcts()) {
			p.setTransDate(Utility.convertFromDateToString(p.getAddedDate()));
			formattedProducts.add(p);
		}
		return formattedProducts;
	}

	@Override
	public List<Product> getProductSearchedByDate(String startDate, String endDate) {
		Date convertedStartDate=Utility.convertToDate(startDate);
		Date convertedEndDate=Utility.convertToDate(endDate);
		
		return productDAOImpl.getProductSearchedByDate(convertedStartDate, convertedEndDate);
	}

	@Override
	public List<Product> getAllProductLastXMonth(int Month) {
		
		return productDAOImpl.getProductSearchedByDate(Utility.SubMonthNow(Month), new Date());
	}

}
