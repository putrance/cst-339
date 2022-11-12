package com.gcu.model;

// Model for shirts
public class ShirtModel{
	private String color;
	private String size;
	private int stock;
	
	// Constructor for shirts
	public ShirtModel(String color, String size, int stock){
		this.color = color;
		this.size = size;
		this.stock = stock;
	}
	
	//Getter and Setter for color
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	//Getter and Setter for size
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	//Getter and Setter for stock
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}