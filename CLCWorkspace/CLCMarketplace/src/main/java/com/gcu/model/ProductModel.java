package com.gcu.model;

//model for Product additions
public class ProductModel {
	private String color;
	private String size;
	private int stock;
	private int id;
	
	//Constructor
	public ProductModel(String color, String size, int stock, int id) {
		super();
		this.color = color;
		this.size = size;
		this.stock = stock;
		this.setId(id);
	}
	//default constructor
	public ProductModel() {
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
