package com.cybersoft.cozastore_java21.service;


import com.cybersoft.cozastore_java21.entity.UserEntity;
import com.cybersoft.cozastore_java21.exception.CustomException;
import com.cybersoft.cozastore_java21.payload.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cybersoft.cozastore_java21.repository.UserRepository;

@Service
public class UserService implements UserServiceIpm {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean insertUser(SignUpRequest request) {
        boolean isSuccess = false;
       try {
           UserEntity user = new UserEntity();
           user.setEmail(request.getEmailAddress());
           user.setUsername(request.getUsername());
           user.setPassword(passwordEncoder.encode(request.getPassword()));
           userRepository.save(user);
           isSuccess = true;

       }catch (Exception e){
           throw new CustomException(400,"",e.getMessage());
       }
       return isSuccess;

    }
}
