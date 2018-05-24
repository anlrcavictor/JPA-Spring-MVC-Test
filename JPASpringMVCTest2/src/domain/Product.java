package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Product {
	
	@Id
	@TableGenerator(name="PRO_GEN")
	@GeneratedValue(generator="PRO_GEN")
	private int id;
	private String name;
	private double price;
	private long stok;
	
	@Transient
	private String transDate; 
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	@Transient
	private String manufacturerName;
	@ManyToOne
	private Manufacturer manufacturer;

	public Product() {
		super();
	}
	
	public Product(String name, double price, long stok,String transDate,Date addedDate,String manufacturerName, Manufacturer manufacturer) {
		super();
		this.name = name;
		this.price = price;
		this.stok = stok;
		this.transDate=transDate;
		this.addedDate=addedDate;
		this.manufacturerName=manufacturerName;
		this.manufacturer = manufacturer;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getStok() {
		return stok;
	}

	public void setStok(long stok) {
		this.stok = stok;
	}
	
	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stok=" + stok + ", transDate="
				+ transDate + ", addedDate=" + addedDate + ", manufacturerName=" + manufacturerName + ", manufacturer="
				+ manufacturer + "]";
	}

	

	

	

	
	
	
	
	

}
