package com.imooc.sell.Repository.usr;

import com.imooc.sell.dataobject.usr.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 用户信息处理
 * @author: WangXue
 * @create: 2018-11-07 20:23
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

}
