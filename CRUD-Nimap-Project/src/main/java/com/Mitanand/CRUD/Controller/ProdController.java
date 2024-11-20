package com.Mitanand.CRUD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mitanand.CRUD.Model.Product;
import com.Mitanand.CRUD.Service.ProdService;

@RestController
@RequestMapping("/product")
public class ProdController {
	
	@Autowired
	private ProdService prodeService;
	
	//Creating the new Product
	
	@PostMapping("/create/{catid}")
	@ResponseBody
	public Product createProduct(@RequestBody Product prod, @PathVariable int catid)
	{
		
//		System.out.println("product is Created.....");
//		System.out.println(prodeService);
		
//		System.out.println(prod.getProdName());
		Product crtProduct = prodeService.createProduct(prod,catid);
		
		return crtProduct;
	}
	
	//Getting All Product
	
	@GetMapping("/view")
	public List<Product>viewAllProduct(){
		
		List<Product> allProducts = prodeService.viewProducts();
		
		return allProducts;
	}
	
	//Getting product By ID
	
	@GetMapping("/view/{productId}")
	public Product getProdByID(@PathVariable int productId)
	{
		return prodeService.getProductById(productId);
	}
	
//	Deleting the product by ID
	
	@DeleteMapping("/del/{productId}")
	public void deleteProduct(@PathVariable int productId)
	{
		prodeService.deleteProd(productId);
		System.out.println("delete method called from ProdController.>>>>>>");
	}
	
	//Updating the product by id
	
	@PutMapping("/update/{productId}")
	public Product updateProduct(@PathVariable int productId, @RequestBody Product newProd)
	{
		Product updatedProduct = prodeService.updateProd(productId, newProd);
		return updatedProduct;
	}

}
