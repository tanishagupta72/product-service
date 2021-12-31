package com.ibm.product.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.product.entity.Product;
import com.ibm.product.exception.ProductNotFoundException;
import com.ibm.product.model.InsertProductRequestBody;
import com.ibm.product.model.ProductObject;
import com.ibm.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	public List<ProductObject> getAllProducts()
	{
		try {
		 List<Product> productEntityList= productRepo.findAll();
		 List<ProductObject> productList = new ArrayList<ProductObject>();
		 for (Product p :  productEntityList)
		 {
			 ProductObject po = new ProductObject();
			 po.setProductId(p.getProductId());
			 po.setAvailableQuantity(p.getQuantity());
			 po.setPrice(p.getPrice());
			 po.setProductName(p.getProductName());
			 productList.add(po);
		 }
		return productList;
		}
		catch(Exception e)
		{
			throw new ProductNotFoundException();
		}
	}
	
	public ProductObject getProductById(int productId)
	{
		try {
			Product productEntity = productRepo.findById(productId);
			ProductObject product = new ProductObject();
			product.setProductId(productEntity.getProductId());
			product.setAvailableQuantity(productEntity.getQuantity());
			product.setPrice(productEntity.getPrice());
			product.setProductName(productEntity.getProductName());
			return product;
		}
		catch(Exception e)
		{
			throw new ProductNotFoundException();
		}
	}
	
	public ProductObject insertProduct(InsertProductRequestBody req)
	{
		Product product = new Product(req.getProductName(),req.getPrice(),req.getQuantity(),req.getManufacturer(),new Date(),new Date());
		Product savedProduct = productRepo.save(product);
		ProductObject po = new ProductObject(savedProduct.getProductId(),savedProduct.getProductName(),savedProduct.getQuantity(),savedProduct.getPrice()); 
		return po;
	}
}
