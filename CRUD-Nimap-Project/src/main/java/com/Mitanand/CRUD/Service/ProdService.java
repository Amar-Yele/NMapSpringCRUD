package com.Mitanand.CRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mitanand.CRUD.Model.Category;
import com.Mitanand.CRUD.Model.Product;
import com.Mitanand.CRUD.Repository.CategoryRepository;
import com.Mitanand.CRUD.Repository.ProductRepository;

@Service
public class ProdService {

	@Autowired
	private ProductRepository prodReposiry;
	
	@Autowired
	private CategoryRepository catRepo;
	 
	public Product createProduct(Product product, int catid)
	{
		
		Category catPro = this.catRepo.findById(catid);
		
		product.setCategory(catPro);
		
		Product save = prodReposiry.save(product);
		
		return save;
	}  
	
	public List<Product> viewProducts()
	{
		return prodReposiry.findAll();
	}
	
	public Product getProductById(int productId)
	{
		
		 Product byId = prodReposiry.findById(productId);
		 
		 return byId;
	}
	
	//Deleting the product
	
	public void deleteProd(int productId)
	{
		prodReposiry.deleteById(productId);
		
		System.out.println("Proudct Deleted Successfully.....");
	}
	
	//Updating the Product
	public Product updateProd(int productId, Product newProduct)
	{
		Product oldProd = prodReposiry.findById(productId);
		
		oldProd.setProductName(newProduct.getProductName());
		oldProd.setProductPrice(newProduct.getProductPrice());
		oldProd.setProductLive(newProduct.isProductLive());
		oldProd.setProductImage(newProduct.getProductImage());
		oldProd.setProductDesc(newProduct.getProductDesc());
		
		Product save = prodReposiry.save(oldProd);	
		return save;
	}
	
}
