package com.jt.service.impl;

import com.jt.dao.UserDao;
import com.jt.pojo.User;
import com.jt.pojo.UserInfo;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public List<User> findPageObject(Integer pageCurrent, Integer pageSize) {
        if(StringUtils.isEmpty(pageCurrent)){

            System.out.println("页码错误");
        }

        int start = (pageCurrent-1)*pageSize;
        List<User> userList = userDao.findPageObject(start, pageSize);

        return userList;
    }

    @Override
    public UserInfo findUserInfo(String name, String password) {

        UserInfo userInfo = userDao.findUserInfo(name, password);

        if(!StringUtils.isEmpty(userInfo)){
            return userInfo;
        }else{
            return null;
        }

    }



}
