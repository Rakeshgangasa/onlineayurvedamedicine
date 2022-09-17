package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.Category;


public interface CategoryService {

     
	
	List<Category> getAllCategory();
	
	Category addCategory(Category category);
	
	Category getCategoryByName(String name);

	

	void deleteCategory(String name);

	Category getcategoryById(String id);

	Category updateCategory(Category category);

}
