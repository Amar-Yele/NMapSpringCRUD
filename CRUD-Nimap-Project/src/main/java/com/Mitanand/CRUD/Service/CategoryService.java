package com.Mitanand.CRUD.Service;

import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mitanand.CRUD.DTO.CategoryDTO;
//import com.Mitanand.CRUD.Exceptions.ResourceNotFoundException;
import com.Mitanand.CRUD.Model.Category;
import com.Mitanand.CRUD.Repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private ModelMapper modMap;
	
	public CategoryDTO createCat(CategoryDTO catDto)
	{
		//catDto to cat
		Category cMap = modMap.map(catDto, Category.class);
		
		Category save = catRepo.save(cMap);
		
		//cat to catDto in return
		return this.modMap.map(save, CategoryDTO.class);
		
	}
	
	public CategoryDTO updateCat(CategoryDTO catDto, int catId)
	{
		Category oldCat = this.catRepo.findById(catId); //For Handling the exceptions please make the exception class and package related.
		
//		oldCat.setCatId(catDto.getCatId());
		oldCat.setCatName(catDto.getCatName());
		
		Category save = this.catRepo.save(oldCat);
		
		return this.modMap.map(save, CategoryDTO.class); 
		
	}

	public void deleteCat(int id) {
		
		Category byId = this.catRepo.findById(id);
		this.catRepo.delete(byId);
	}
	
	//get by id
	public CategoryDTO getById(int catDto) {
		
		Category byId = this.catRepo.findById(catDto);
		
		return this.modMap.map(byId, CategoryDTO.class);
		
	}
	
	//get all categories
	public List<CategoryDTO> getAllCat()
	{
		List<Category> all = this.catRepo.findAll();
		List<CategoryDTO> allDto = all.stream().map(cat->this.modMap.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return allDto;
	}
	
}
