package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Manufacturer;
import domain.Product;
import service.ManufacturerServiceImpl;
import service.ProductServiceImpl;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private ManufacturerServiceImpl manufacturerService;
	
	@RequestMapping
	public String ListProduct(Model model) {
		model.addAttribute("allProducts", productService.getAllFormattedProducts());
		return "/products";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String ListProducts(Model model) {
		model.addAttribute("allProducts", productService.getAllProductLastXMonth(2));
		return "/products2";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String ListProductsByDate(HttpServletRequest req ,Model model) {
		String startDate=req.getParameter("startDate");
		String finishDate=req.getParameter("finishDate");
		System.out.println("Product List POST Çalýþtý!! startDate = "+startDate +" finishDate = " +finishDate);
		
		model.addAttribute("allProducts", productService.getProductSearchedByDate(startDate, finishDate));
		return "/products2";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    // http://localhost:8080/injavawetrust.springmvc/products/add
	public String getNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
		return "/productAdd";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded) {
		System.out.println(productToBeAdded);
		productService.insertProduct(productToBeAdded);
		return "redirect:/products";
	}
	
	@RequestMapping(value="/product.delete{productId}",method=RequestMethod.GET)
	public String deleteProduct(@RequestParam("productId") int id) {	
		productService.deleteProduct(id);
		return "redirect:/products";
	}
	
	@RequestMapping(value="/product.update{productId}",method=RequestMethod.GET)
	public String updateProduct(@RequestParam("productId") int id, Model model) {	
		model.addAttribute("updateProduct",productService.getProductById(id));
		
		return "/productUpdate";
	}
	
	@RequestMapping(value="/product.update",method=RequestMethod.POST)
	public String updateProductPost(@ModelAttribute("updateProduct") Product updatedProduct) {
		System.out.println("UpdateProductPost working!!"+updatedProduct);
		productService.updateProduct(updatedProduct);
		return "redirect:/products";
	}
	
	//------------@ModelAttribute---------
	
	@ModelAttribute("manufacturerList")
	public List<String> prepareManufacturerList() {
		List<String> manufacturerListName=new ArrayList<String>();
		 for(Manufacturer man :manufacturerService.getAllManufacturer()) {
			 manufacturerListName.add(man.getName());
		 }
		 return manufacturerListName;
	}
	
	
	
}
