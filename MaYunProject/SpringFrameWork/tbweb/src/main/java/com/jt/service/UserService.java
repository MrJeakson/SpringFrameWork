package com.jt.service;

import com.jt.pojo.User;
import com.jt.pojo.UserInfo;

import java.util.List;

public interface UserService {

    List<User> findPageObject(Integer pageCurrent,Integer pageSize);

    UserInfo findUserInfo(String name,String password);

}
