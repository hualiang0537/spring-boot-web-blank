package com.github.yingzhuo.controller;

import com.github.yingzhuo.domain.User;
import com.github.yingzhuo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/{userId}")
    public
    @ResponseBody
    User get(@PathVariable("userId") String userId) {
        User user = userService.findUserById(userId);
        return user;
    }

    @RequestMapping("/say-hello")
    public String test(ModelMap modelMap) {
        modelMap.addAttribute("name", "spring-boot");
        return "say-hello";
    }

}
