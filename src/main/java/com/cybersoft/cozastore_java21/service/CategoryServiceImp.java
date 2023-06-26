package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.payload.response.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public interface CategoryServiceImp {
    public ArrayList<CategoryResponse> getAllCategory();
}
