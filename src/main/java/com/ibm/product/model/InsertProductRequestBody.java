package com.ibm.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertProductRequestBody {

	@JsonProperty("ProductName")
	private String productName;
	
	@JsonProperty("Manufacturer")
	private String manufacturer;
	
	@JsonProperty("Price")
	private double price;
	
	@JsonProperty("Quantity")
	private int quantity;
	
}
