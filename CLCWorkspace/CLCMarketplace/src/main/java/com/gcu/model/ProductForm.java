package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

//model for Product additions
public class ProductForm {
	
	//Data validation
	@NotNull(message="Product color is a required field")
	@Size(min=1, max=32, message="Product color must be within 1 to 32 characters")
	private String color;
	
	@NotNull(message="Product size is a required field")
	@Size(min=1, max=32, message="Product size must be within 1 to 32 characters")
	private String size;
	
	@NotNull(message="Product stock qty is a required field")
	@Range(min=0L, message="Product stock qty must be a number between 1 and 32")
	private int stock;
	private int id;
	
	//Constructor
	public ProductForm(String color, String size, int stock, int id) {
		super();
		this.color = color;
		this.size = size;
		this.stock = stock;
		this.id = id;
	}
	//default constructor
	public ProductForm() {
		super();
	}

	//getters and setters
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
