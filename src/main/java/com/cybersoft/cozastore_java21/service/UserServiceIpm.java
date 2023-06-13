package com.cybersoft.cozastore_java21.service;
import com.cybersoft.cozastore_java21.entity.UserEntity;
import com.cybersoft.cozastore_java21.payload.request.SignUpRequest;
import org.springframework.security.core.userdetails.User;

public interface UserServiceIpm {
    UserEntity findByEmail(String email);
    boolean insertUser(SignUpRequest request);
}
