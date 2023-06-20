package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.payload.response.ProductRespone;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ProductServiceImp {
    public ArrayList<ProductRespone> getListProductByCategoryId(String id);

}
