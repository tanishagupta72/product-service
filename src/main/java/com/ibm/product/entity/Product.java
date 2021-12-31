package com.ibm.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	@Column
	private int productId;
	
	@Column
	private String productName;
	
	@Column
	private double price;
	
	@Column
	private int quantity;
	
	@Column
	private String manufacturer;
	
	@Column
	private Date cretTs;
	
	@Column
	private Date updtTs;

	public Product()
	{
		
	}
	
	public Product(String productName, double price, int quantity, String manufacturer, Date cretTs, Date updtTs) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
		this.cretTs = cretTs;
		this.updtTs = updtTs;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getCretTs() {
		return cretTs;
	}

	public void setCretTs(Date cretTs) {
		this.cretTs = cretTs;
	}

	public Date getUpdtTs() {
		return updtTs;
	}

	public void setUpdtTs(Date updtTs) {
		this.updtTs = updtTs;
	}

	
	
}
