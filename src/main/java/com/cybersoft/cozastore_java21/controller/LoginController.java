package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.payload.request.SignUpRequest;
import com.cybersoft.cozastore_java21.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.utils.JwtHelper;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    // statusCode : 200;
    // message : announce;
    // data :
    @CrossOrigin("*")
   @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public ResponseEntity<?> sigin(@RequestParam String email,@RequestParam String password){
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
       // success :
       String jwt = jwtHelper.GenerateToken(email);
       BaseResponse baseResponse = new BaseResponse();
       baseResponse.setStatusCode(200);
       baseResponse.setData(jwt);
       baseResponse.setMessage("");

       return new ResponseEntity<>(baseResponse, HttpStatus.OK);
   }
   @Autowired
   private UserService userService;
   @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpRequest request){
       BaseResponse baseResponse = null;
    boolean isSucess = userService.insertUser(request);
    if(isSucess){
        String jwt = jwtHelper.GenerateToken(request.getEmailAddress());
       baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(jwt);
        baseResponse.setMessage("");
    }
       return new ResponseEntity<>(baseResponse,HttpStatus.OK);
   }
}
