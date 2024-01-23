package com.swaggerdemo.services;


import com.swaggerdemo.security.models.JwtUser;
import com.swaggerdemo.security.repositories.JwtUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JwtUserRepository jwtUserRepository;
//    private final List<User> userList = new ArrayList<>();

//    public UserService() {
//        this.userList.add(new User(UUID.randomUUID().toString(),"Nitendra","nitendra@gmail.com"));
//        this.userList.add(new User(UUID.randomUUID().toString(),"Jitendra","jitendra@gmail.com"));
//        this.userList.add(new User(UUID.randomUUID().toString(),"Ramonda","Ramonda@gmail.com"));
//        this.userList.add(new User(UUID.randomUUID().toString(),"Shanahan","Shanahan@gmail.com"));
//    }

    public List<JwtUser> getUsers(){
        return jwtUserRepository.findAll();
    }

    public JwtUser createUser(JwtUser jwtUser){
        return jwtUserRepository.save(jwtUser);
    }
}
