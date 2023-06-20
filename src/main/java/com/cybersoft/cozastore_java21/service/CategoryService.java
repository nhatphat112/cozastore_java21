package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.entity.CategoryEntity;
import com.cybersoft.cozastore_java21.payload.response.CategoryResponse;
import com.cybersoft.cozastore_java21.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class CategoryService implements CategoryServiceImp{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ArrayList<CategoryResponse> getAllCategory() {
        ArrayList<CategoryResponse> categoryResponses = new ArrayList<>();
            for(CategoryEntity item : categoryRepository.findAll() ){
                categoryResponses.add(new CategoryResponse(item.getId(), item.getName()));
            }
            return categoryResponses;
    }
}
