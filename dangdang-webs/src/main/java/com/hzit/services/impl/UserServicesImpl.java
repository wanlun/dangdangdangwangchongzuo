package com.hzit.services.impl;

import com.hzit.entity.User;
import com.hzit.mapper.UserMapper;
import com.hzit.services.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/9.
 */
@Service
public class UserServicesImpl implements Userservices {
 @Autowired
 private UserMapper  userMapper;
    @Override
    public int findUesr(String uesrname,String passward) {
           User  user=new User();
        user.setUserName(uesrname);
        user.setPassWord(passward);
        Map map=new HashMap();
          map.put("uesrName",uesrname);
        map.put("passWord",passward);
        List<User>    userList= userMapper.searchUserByParams(map);
        User user1 = null;
        if(userList!=null&&userList.size()!=0) {
                return 1;
        }
            return -1;

    }
}
