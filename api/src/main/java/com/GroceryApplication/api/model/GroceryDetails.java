package com.GroceryApplication.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class GroceryDetails {
	
	@JsonProperty("name")
	@NotNull(message = "name cannot be null")
	private String 	name;
	
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("unit")
	@NotNull(message = "unit cannot be null")
	private int unit;
	
	@JsonProperty("price")
	@NotNull(message = "price cannot be null")
	private long price;
	
	@JsonProperty("info")
	@NotNull(message = "info cannot be null")
	private String info;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	

}
