package com.github.yingzhuo.controller;

import com.github.yingzhuo.domain.User;
import com.github.yingzhuo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/{userId}")
    public User get(@PathVariable("userId") String userId) {
        User user = userService.findUserById(userId);
        return user;
    }

}
