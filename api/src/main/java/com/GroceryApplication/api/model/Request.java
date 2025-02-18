package com.GroceryApplication.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {

	@JsonProperty("GroceryDetails")
	private List<GroceryDetails> groceryDetails;

	public List<GroceryDetails> getGroceryDetails() {
		return groceryDetails;
	}

	public void setGroceryDetails(List<GroceryDetails> groceryDetails) {
		this.groceryDetails = groceryDetails;
	}

}
