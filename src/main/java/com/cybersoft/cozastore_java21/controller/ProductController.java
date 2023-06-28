package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.service.ProductService;
import com.cybersoft.cozastore_java21.service.ProductServiceImp;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    private Gson gson = new Gson();
    private  Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategoryId(@PathVariable String id){

        logger.info("id :"+id); // info : info kiem tra data, not error, error ( dung trong error)
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(productServiceImp.getListProductByCategoryId(id));

        baseResponse.setMessage("List product by categoryId");
        logger.info("Response :"+gson.toJson(baseResponse));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
