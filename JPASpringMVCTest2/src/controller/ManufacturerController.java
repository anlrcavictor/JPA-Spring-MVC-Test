package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Manufacturer;
import service.ManufacturerServiceImpl;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerServiceImpl manufacturerService;
	
	@RequestMapping
	public String ListManufacturer(Model model) {
		model.addAttribute("allManufacturers", manufacturerService.getAllManufacturer());
		return "/manufacturers";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    // http://localhost:8080/injavawetrust.springmvc/manufacturers/add
	public String getNewManufacturerForm(@ModelAttribute("newManufacturer") Manufacturer newManufacturer) {
		return "/manufacturerAdd";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newManufacturer") Manufacturer manufacturerToBeAdded) {
		System.out.println(manufacturerToBeAdded);
		manufacturerService.insertManufacturer(manufacturerToBeAdded);
		return "redirect:/manufacturers";
	}
	
}
