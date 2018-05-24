package service;

import java.util.List;

import domain.Manufacturer;
import domain.Product;

public interface ManufacturerService {

	public void insertManufacturer(Manufacturer manufacturer);
	
	public Manufacturer getManufacturerById(int id);
	
	public List<Manufacturer> getAllManufacturer();
	
	public void updateManufacturer(Manufacturer manufacturer);
	
	public void deleteManufacturer(int id);
}
