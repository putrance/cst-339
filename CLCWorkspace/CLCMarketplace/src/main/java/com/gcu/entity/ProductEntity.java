package com.gcu.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class ProductEntity {
	
	@Column("color")
	private String color;
	@Column("size")
	private String size;
	@Column("stock")
	private int stock;
	private int id;
	
	//Constructor
	public ProductEntity(String color, String size, int stock, int id) {
		super();
		this.color = color;
		this.size = size;
		this.stock = stock;
		this.setId(id);
	}
	//default constructor
	public ProductEntity() {
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
