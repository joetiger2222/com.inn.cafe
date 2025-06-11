package com.inn.cafe.service;

import com.inn.cafe.DTO.UserForGetAll;
import com.inn.cafe.POJO.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<String>signUp(Map<String,String>requestMap);
    User getUserData(String email);
    List<UserForGetAll>getAllUsers();
}
