package com.imooc.sell.dataobject.usr;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description: 注册用户
 * @author: WangXue
 * @create: 2018-12-11 18:27
 */
@Data
@Entity
@DynamicUpdate
public class User {

    @Id
    private Integer id;
    private String userName;
    private String password;

}
