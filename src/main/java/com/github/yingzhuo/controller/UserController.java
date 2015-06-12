package com.github.yingzhuo.controller;

import com.github.yingzhuo.domain.User;
import com.github.yingzhuo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/{userId}")
    @ResponseBody
    public User get(@PathVariable("userId") String userId) {
        User user = userService.findUserById(userId);
        return user;
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("user-list");

        List<User> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            list.add(userService.findUserById("" + i));
        }
        mav.addObject("userList", list);
        return mav;
    }
}
