package com.github.yingzhuo.dao;

import com.github.yingzhuo.domain.User;

public interface UserDao {

    public User findById(String userId);

}
