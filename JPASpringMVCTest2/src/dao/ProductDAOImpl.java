package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ProductDAO;
import domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void insertProduct(Product product) {
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();		
	}

	@Override
	public Product getProductById(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public List<Product> getAllProdcts() {
		TypedQuery<Product> query = entityManager.createQuery("Select e from Product e", Product.class);
		return query.getResultList();
	}

	@Override
	public void updateProduct(Product product) {
		Product foundProduct = getProductById(product.getId());
		if(foundProduct!=null){
			System.out.println("DAO Founded Product: "+foundProduct);
			entityManager.getTransaction().begin();
			foundProduct.setName(product.getName());
			foundProduct.setPrice(product.getPrice());
			foundProduct.setStok(product.getStok());
			entityManager.getTransaction().commit();
		}
		
	}

	@Override
	public void deleteProduct(int id) {
		Product product = getProductById(id);
		if (product != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(product);
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public List<Product> getProductSearchedByDate(Date startDate, Date endDate) {
			List<Product> allProducts = entityManager.createQuery(
			    "SELECT p FROM Product p WHERE p.addedDate BETWEEN :startDate AND :endDate")  
			  .setParameter("startDate", startDate, TemporalType.DATE)  
			  .setParameter("endDate", endDate, TemporalType.DATE)  
			  .getResultList();
			  return allProducts;  
	}

}
