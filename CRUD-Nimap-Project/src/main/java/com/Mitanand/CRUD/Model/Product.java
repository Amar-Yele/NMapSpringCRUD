package com.Mitanand.CRUD.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

//@Data
//@Getter
//@Setter

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	private int productId;
	@JsonProperty
	private String productName;
	@JsonProperty
	private int productPrice;
	@JsonProperty
	private boolean productLive;
	@JsonProperty
	private String productImage;
	@JsonProperty
	private String productDesc;

	//Mapping Relation 
	@ManyToOne(fetch = FetchType.EAGER) 
	private Category category;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public boolean isProductLive() {
		return productLive;
	}
	public void setProductLive(boolean productLive) {
		this.productLive = productLive;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
