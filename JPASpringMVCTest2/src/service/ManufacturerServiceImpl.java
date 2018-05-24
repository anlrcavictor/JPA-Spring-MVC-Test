package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ManufacturerDAOImpl;
import domain.Manufacturer;
import domain.Product;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired
	private ManufacturerDAOImpl manufacturerDAOImpl;

	@Override
	public void insertManufacturer(Manufacturer manufacturer) {
		manufacturerDAOImpl.insertManufacturer(manufacturer);
	}

	@Override
	public Manufacturer getManufacturerById(int id) {
		return manufacturerDAOImpl.getManufacturerById(id);
	}

	@Override
	public List<Manufacturer> getAllManufacturer() {
		return manufacturerDAOImpl.getAllManufacturers();
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		manufacturerDAOImpl.updateManufacturer(manufacturer);
	}

	@Override
	public void deleteManufacturer(int id) {
		manufacturerDAOImpl.removeManufacturer(id);
	}
	
	

}
