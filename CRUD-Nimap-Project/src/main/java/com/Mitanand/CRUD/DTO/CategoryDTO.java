package com.Mitanand.CRUD.DTO;

public class CategoryDTO {
	
	private int catId;
	private String catName;
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public CategoryDTO(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
