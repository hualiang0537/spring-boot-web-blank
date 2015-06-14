package com.github.yingzhuo.service.impl;

import com.github.yingzhuo.dao.UserDao;
import com.github.yingzhuo.domain.User;
import com.github.yingzhuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final static Date DEFAULT_DOB = new Date();

    @Resource
    @Autowired(required = false)
    private UserDao userDao;

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
