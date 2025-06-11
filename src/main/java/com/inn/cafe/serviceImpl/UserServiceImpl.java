package com.inn.cafe.serviceImpl;

import com.inn.cafe.DTO.UserForGetAll;
import com.inn.cafe.POJO.User;
import com.inn.cafe.constants.CafeConstants;
import com.inn.cafe.dao.UserDoa;
import com.inn.cafe.service.UserService;
import com.inn.cafe.utils.CafeUtils;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDoa userDoa;
    @Autowired
    EntityManager entityManager;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("inside signup",requestMap);
        try{
            if(validateRequestMap(requestMap)){
                User user = userDoa.findByEmailId(requestMap.get("email"));
                if(Objects.isNull(user)){
                    userDoa.save(getUserFromMap(requestMap));
                    return CafeUtils.getResponseEntity("Successfully registered",HttpStatus.OK);
                }else{
                    return CafeUtils.getResponseEntity("Email already exist",HttpStatus.BAD_REQUEST);
                }
            }else{
                return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public User getUserData(String email) {
        return userDoa.findByEmailId(email);
    }

    @Override
    public List<UserForGetAll> getAllUsers() {
        List<UserForGetAll>users=entityManager.createQuery("select new com.inn.cafe.DTO.UserForGetAll(u.id,u.name,u.contactNumber,u.email,u.status) from User u where u.role='user'").getResultList();
        return users;
    }

    private boolean validateRequestMap(Map<String,String>requestMap){
        if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email") && requestMap.containsKey("password")){
            return true;
        }else{
            return false;
        }
    }

    private User getUserFromMap(Map<String,String>requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
}
