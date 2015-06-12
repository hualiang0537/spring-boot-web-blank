package com.github.yingzhuo.service.impl;

import com.github.yingzhuo.domain.User;
import com.github.yingzhuo.service.UserService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final Date DEFAULT_DOB = new Date();

    @Override
    public User findUserById(String userId) {
        if (userId == null || userId.trim().equals("")) {
            return null;
        }

        User u = new User();
        u.setId(userId);
        u.setDob(DEFAULT_DOB);
        u.setName("Spring's Fan");
        return u;
    }

}
