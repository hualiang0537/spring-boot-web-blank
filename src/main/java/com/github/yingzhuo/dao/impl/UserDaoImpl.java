package com.github.yingzhuo.dao.impl;

import com.github.yingzhuo.dao.UserDao;
import com.github.yingzhuo.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Resource
    private SqlSession sqlSession;

    @Override
    public User findById(String userId) {
        if (StringUtils.isBlank(userId)) {
            return null;
        }

        return sqlSession.selectOne("user.findById", userId);
    }

}
