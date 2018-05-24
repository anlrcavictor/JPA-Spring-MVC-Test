package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.Manufacturer;
import domain.Product;

@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	
	@Override
	public void insertManufacturer(Manufacturer manufacturer) {

		entityManager.getTransaction().begin();
		entityManager.persist(manufacturer);
		entityManager.getTransaction().commit();

	}

	@Override
	public Manufacturer getManufacturerById(int id) {
		return entityManager.find(Manufacturer.class, id);
	}

	@Override
	public List<Manufacturer> getAllManufacturers() {
		TypedQuery<Manufacturer> query = entityManager.createQuery("Select e from Manufacturer e", Manufacturer.class);
		return query.getResultList();
	}

	@Override
	public void removeManufacturer(int id) {
		Manufacturer manufacturer = getManufacturerById(id);
		if (manufacturer != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(manufacturer);
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		Manufacturer foundManufacturer = getManufacturerById(manufacturer.getId());
		if(foundManufacturer!=null){
			System.out.println("DAO Founded Manufacturer: "+foundManufacturer);
			entityManager.getTransaction().begin();
			foundManufacturer.setName(manufacturer.getName());
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public Manufacturer getManufacturerByName(String name) {
		TypedQuery<Manufacturer> query = entityManager.createQuery("Select m from Manufacturer m where m.name= ?1",
				 Manufacturer.class).setParameter(1, name);
		return query.getSingleResult();
		
	}

}
