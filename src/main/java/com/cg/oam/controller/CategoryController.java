package com.cg.oam.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.entity.Category;
import com.cg.oam.service.CategoryService;

@RestController

@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	/********************************************************
	 * Method: getAllCategory Description: It is used to view all category in
	 * categories table
	 * 
	 * 
	 ********************************************************/

	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory() {
		List<Category> allCategoryList = (List<Category>) categoryService.getAllCategory();
		return allCategoryList;
	}


	/***************************************************************************************
	 * Method: getCategoryByName
	 * 
	 ***************************************************************************************/

	@GetMapping("/getcategorybyname/{name}")
	public ResponseEntity<Category> getCategoryByName(@PathVariable(name = "name") String name) {

		Category category = categoryService.getCategoryByName(name);
		if (category == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(category));
	}

	
	@PostMapping(value = "/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {

		Category c = categoryService.addCategory(category);
		if (c != null) {
			return new ResponseEntity<Category>(c, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	
	@DeleteMapping("/category/{cId}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("cId") String categoryId) {
		categoryService.deleteCategory (categoryId);
	    ResponseEntity<String> responseEntity = new ResponseEntity<>("Category Deleted successfully.",HttpStatus.OK);
	    return responseEntity;
	}
	
}
