package com.imooc.sell.service.usr;

import com.imooc.sell.dataobject.usr.User;

/**
 * @description: 用户信息
 * @author: WangXue
 * @create: 2018-12-11 18:29
 */
public interface UserService {

    User findByUserName(String userName);

}
