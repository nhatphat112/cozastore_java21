package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.payload.response.CategoryResponse;
import com.cybersoft.cozastore_java21.repository.CategoryRepository;
import com.cybersoft.cozastore_java21.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Cacheable;
import java.util.ArrayList;

@RestController

@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;
    @GetMapping("")

    public ResponseEntity<?> getAllCategory(){
        BaseResponse response = new BaseResponse();
        ArrayList<CategoryResponse> responseCategory = categoryServiceImp.getAllCategory();
        if(responseCategory.size()!=0){
            response.setStatusCode(200);
            response.setData(responseCategory);
        }else {
        }
        return new ResponseEntity<>( response , HttpStatus.OK);
    }
    @CacheEvict(value = "listcategory",allEntries = true)
    @GetMapping("/clear-cache")
    public ResponseEntity<?> clearCache(){
        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
