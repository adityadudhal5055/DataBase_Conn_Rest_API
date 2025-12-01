package com.example.demo.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.ProductRepository;
import com.example.demo.entity.Product;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository repo;
	
	@Operation(summary = "Add new Book",
			description = "This API Contain XML/JSON to Add new Book")
	@PostMapping(value = "/addProduct",consumes = "application/json")
	public ResponseEntity<String> addProduct(@RequestBody Product product)
	{
		 repo.save(product);
		
		return new ResponseEntity<>("Product Save Successfully",HttpStatus.CREATED);
	}
	
	@Operation(summary = "To get All Books",description = "This API Contain All Book Details")
	@GetMapping(value = "/getProduct",produces = "application/json")
	public ResponseEntity<List<Product>> getProducts()
	{
		List<Product> all = repo.findAll();
		
		return new ResponseEntity<>(all,HttpStatus.OK);
	}

}
