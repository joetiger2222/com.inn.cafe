package com.inn.cafe.rest;

import com.inn.cafe.DTO.AuthRequest;
import com.inn.cafe.DTO.LoginResponse;
import com.inn.cafe.DTO.UserForGetAll;
import com.inn.cafe.POJO.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/user")
public interface UserRest {
    @PostMapping(path="/signUp")
    public ResponseEntity<String>signUp(@RequestBody(required = true)Map<String,String>requestMap);

    @PostMapping(path = "/login")
    public ResponseEntity<?>login(@RequestBody(required = true) AuthRequest request);

    @GetMapping(path = "/data")
    public ResponseEntity<User>getUserData(@RequestParam(required = true)String email);

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserForGetAll>>getAllUsers();
}
