package com.imooc.sell.service.impl.usr;

import com.imooc.sell.Repository.usr.UserRepository;
import com.imooc.sell.dataobject.usr.User;
import com.imooc.sell.service.usr.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户信息处理
 * @author: WangXue
 * @create: 2018-12-11 18:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
