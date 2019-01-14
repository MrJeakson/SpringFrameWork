package com.jt.dao;

import com.jt.pojo.User;
import com.jt.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface UserDao {

    List<User> findPageObject(@Param(value = "startIndex") Integer startIndex,
                              @Param(value = "pageSize") Integer pagSize);

    UserInfo findUserInfo(@Param(value = "name") String name,
                          @Param(value = "password") String password);
}
