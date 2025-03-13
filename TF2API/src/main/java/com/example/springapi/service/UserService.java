package com.example.springapi.service;


import com.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user = new User(1,"Ida",32,"ida@mail.com");
        userList.add(user);
    }


    public Optional<User> getUser(Integer id) {

        Optional optional = Optional.empty();


        for (User user : userList) {
            if (user.getId() == id) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
