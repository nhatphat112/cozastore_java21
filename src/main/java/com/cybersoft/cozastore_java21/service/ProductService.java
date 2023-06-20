package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.entity.ProductEntity;
import com.cybersoft.cozastore_java21.payload.response.ProductRespone;
import com.cybersoft.cozastore_java21.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements ProductServiceImp{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ArrayList<ProductRespone> getListProductByCategoryId(String id){
        ArrayList<ProductRespone> productRespones = new ArrayList<>();
        for(ProductEntity item : productRepository.findByCategoryId(Integer.parseInt(id))){
            ProductRespone respone = new ProductRespone();
            respone.setId(item.getId());
            respone.setCategoryId(item.getCategory().getId());
            respone.setImg(item.getImage());
            respone.setPrices(item.getPrice());
            productRespones.add(respone);

        }
        return productRespones;
    }
}
