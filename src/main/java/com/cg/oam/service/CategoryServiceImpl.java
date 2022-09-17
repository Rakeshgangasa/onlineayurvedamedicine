package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Category;
import com.cg.oam.exception.CategoryAlreadyExistsException;
import com.cg.oam.exception.CategoryNotFoundException;
import com.cg.oam.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		Category cat = categoryRepository.findCategoryByCategoryName(category.getCategoryName());
		if (cat != null) {
			String exceptionMessage = "Category already exist in the database.";
			LOG.warn(exceptionMessage);
			throw new CategoryAlreadyExistsException(exceptionMessage);
		} else {
			LOG.info("List returned successfully.");
			return categoryRepository.save(category);
		}

	}
    public List<Category> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()) {
        	String exceptionMessage = "Category doesnt exist in database";
        	LOG.warn(exceptionMessage);
        	throw new CategoryNotFoundException(exceptionMessage);
        }else {
        	LOG.info("List returned Succesfully.");
        }
        return categoryList;
    }
	
	@Override
	public Category getcategoryById(String categoryId) {
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new CategoryNotFoundException("category not existing with id: "+categoryId);
		}
		Category category = optionalCategory.get();
		return category;
	}
	

	@Override
	public void deleteCategory(String categoryId) {
		
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new CategoryNotFoundException("Category not existing with id : "+categoryId);
		}
		categoryRepository.deleteById(categoryId);
		
	}
	
	
	@Override
	public Category getCategoryByName(String name) {
		Category cat = categoryRepository.findCategoryByCategoryName(name);
		if (cat == null) {
			String exceptionMessage = "Category does not exist .";
			LOG.warn(exceptionMessage);
			throw new CategoryNotFoundException(exceptionMessage);
		} else {
			LOG.info("List returned successfully.");
			return cat;
		}
	}



	

	

	

}