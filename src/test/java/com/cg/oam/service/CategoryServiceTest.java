package com.cg.oam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.cg.oam.entity.Category;
import com.cg.oam.exception.CategoryNotFoundException;
import com.cg.oam.repository.CategoryRepository;
 
@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();

    @Mock
    CategoryRepository categoryRepository;    

                  

    @Test
    public void testGetCategoryByIdException() {

        when(categoryRepository.findById("01")).thenThrow(CategoryNotFoundException.class);

        assertThrows(CategoryNotFoundException.class,()->categoryServiceImpl.getcategoryById("01"));
    }

    @Test
    public void testGetAllCategorys() {

    	Category category = new Category();
        category.setCategoryId("01");
        category.setCategoryName("Privhti");
        
        Category category2 = new Category();
        category2.setCategoryId("02");
        category2.setCategoryName("Apa");
        
        Category category3 = new Category();
        category3.setCategoryId("03");
        category3.setCategoryName("Tej");
        
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category3);
        categoryList.add(category2);
        categoryList.add(category);

        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<Category> categorys = categoryServiceImpl.getAllCategory();

        assertEquals(3, categorys.size());
    }

     @Test
    public void testDeleteCategory() {

    	Category category = new Category();
        category.setCategoryId("01");
        category.setCategoryName("Privhti");
        
        Optional<Category> optionalCategory = Optional.of(category);

        when(categoryRepository.findById("01")).thenReturn(optionalCategory);

        doNothing().when(categoryRepository).deleteById("01");

        categoryServiceImpl.deleteCategory("01");

        verify(categoryRepository,times(1)).findById("01");
        verify(categoryRepository,times(1)).deleteById("01");
    }

}