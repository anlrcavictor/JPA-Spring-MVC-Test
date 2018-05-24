package dao;

import java.util.List;

import domain.Manufacturer;


public interface ManufacturerDAO {

	public void insertManufacturer(Manufacturer manufacturer);
	
	public Manufacturer getManufacturerById(int id);
	
	public List<Manufacturer> getAllManufacturers();
	
	public void removeManufacturer(int id);
	
	public void updateManufacturer(Manufacturer manufacturer);
	
	public Manufacturer getManufacturerByName(String name);
}
