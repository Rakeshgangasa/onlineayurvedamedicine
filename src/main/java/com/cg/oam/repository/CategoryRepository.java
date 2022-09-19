package com.cg.oam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entity.Category;
@Repository
public interface CategoryRepository  extends JpaRepository<Category,String>{

	Category findCategoryByCategoryName(String categoryName);
	
	  Category save(Category category);
	  
	  List<Category> findAll();
	  
	  Category findCategoryByCategoryId(String categoryId);
	  
	  void deleteById(String categoryId);

}
