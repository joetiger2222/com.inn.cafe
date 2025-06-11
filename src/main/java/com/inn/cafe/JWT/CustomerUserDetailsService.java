package com.inn.cafe.JWT;

import com.inn.cafe.dao.UserDoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    UserDoa userDoa;

    private com.inn.cafe.POJO.User userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetails=userDoa.findByEmailId(username);
        if(!Objects.isNull(userDetails)){
            return new User(userDetails.getEmail(),userDetails.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+userDetails.getRole().toUpperCase())));
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }

    public com.inn.cafe.POJO.User getUserDetail(){
        return userDetails;
    }
}
