package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.entity.CategoryEntity;
import com.cybersoft.cozastore_java21.payload.response.CategoryResponse;
import com.cybersoft.cozastore_java21.repository.CategoryRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
//    @Cacheable("listcategory")

    public ArrayList<CategoryResponse> getAllCategory() {
        ArrayList<CategoryResponse> categoryResponses = new ArrayList<>();
        System.out.println("Check category");
        Gson gson = new Gson();
        // kiem tra key co ton tai tren redis hay khong
        if(redisTemplate.hasKey("listcategory")){
            System.out.println("Check exist on Redis");
            // lay gia tri luu tru tren redis
            String data = redisTemplate.opsForValue().get("listcategory").toString();
            // do json khong convert duoc list object, nen phai custom handle
            Type listType = new TypeToken<ArrayList<CategoryResponse>>(){}.getType();
            categoryResponses = new Gson().fromJson(data, listType);
        } else {
            // query database, and day no len redis
            for(CategoryEntity item : categoryRepository.findAll() ){
                categoryResponses.add(new CategoryResponse(item.getId(), item.getName()));

            }
            String data = gson.toJson(categoryResponses);
            // day data len redis
            redisTemplate.opsForValue().set("listcategory",data);
        }



            return categoryResponses;
    }
}
