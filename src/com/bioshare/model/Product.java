package com.bioshare.model;

public class Product {
	private String idProduct;
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String string) {
		this.idProduct = string;
	}

	private String title;
	private String description;
	private int type;
	private int price;
	private int quantity;
	private String dateFrom;
	private String dateTo;
	private String label;
	private String category;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	@Override
	public String toString() {
		return "Product [title=" + title +"=> Label = "+ label + " => Category = "+ category +  ", description=" + description + ", type=" + type + ", price=" + price
				+ ", quantity=" + quantity + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}

	
	
	

}
