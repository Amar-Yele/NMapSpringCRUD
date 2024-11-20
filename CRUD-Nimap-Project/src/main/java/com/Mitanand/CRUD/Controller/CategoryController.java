package com.Mitanand.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mitanand.CRUD.DTO.ApiResponse;
import com.Mitanand.CRUD.DTO.CategoryDTO;
import com.Mitanand.CRUD.Service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService catSer;
	
	
	//Creating the Category
	@PostMapping("/create")
	public ResponseEntity<CategoryDTO> createCat(@RequestBody CategoryDTO catDto)
	{
		CategoryDTO creatDto = this.catSer.createCat(catDto);
		
		return new ResponseEntity<CategoryDTO>(creatDto, HttpStatus.CREATED);
	}
	
	//Updating the Category
	@PutMapping("/update/{catId}")
	public ResponseEntity<CategoryDTO> updateCat(@RequestBody CategoryDTO catDto, @PathVariable int catId)
	{
		CategoryDTO updatDto = this.catSer.updateCat(catDto, catId);
		
		return new ResponseEntity<CategoryDTO>(updatDto, HttpStatus.OK);
	}
	
	//Deleting the Category
	@DeleteMapping("/delete/{catId}")
	public ResponseEntity<ApiResponse> deleteCat(@PathVariable int catId)
	{
		this.catSer.deleteCat(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is Deleted Successfully...", true), HttpStatus.OK);
	}
	
	//Getting category by id
	@GetMapping("/getcat/{catId}")
	public ResponseEntity<CategoryDTO> getCatById(@PathVariable int catId)
	{
		CategoryDTO cat = this.catSer.getById(catId);
		return new ResponseEntity<CategoryDTO>(cat, HttpStatus.OK);
	}
	
	//get All categories
	@GetMapping("/getAllcat")
	public ResponseEntity<List<CategoryDTO>> getAllcat()
	{
		List<CategoryDTO> allCat = this.catSer.getAllCat();
		return new ResponseEntity<List<CategoryDTO>>(allCat, HttpStatus.OK);
	}
	
}
