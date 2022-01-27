package com.ibm.product.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.product.model.InsertProductRequestBody;
import com.ibm.product.model.ProductObject;
import com.ibm.product.model.ProductServiceResponseBody;
import com.ibm.product.service.ProductService;

@RestController
public class ProductServiceController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/allProducts")
	public ResponseEntity<?> getAllProducts()
	{
		List<ProductObject> productList = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(new ProductServiceResponseBody(productList));
	}
	
	@GetMapping("/productById/{id}")
	public ResponseEntity<?> getProductbyId(@PathVariable int id)
	{
		ProductObject po = productService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(po);
	}
	
	@PostMapping("/insertProduct")
	public ResponseEntity<?> insert(@RequestBody InsertProductRequestBody request)
	{
		List<ProductObject> po = productService.insertProduct(request);
		return ResponseEntity.status(HttpStatus.OK).body(po);
	}
}
