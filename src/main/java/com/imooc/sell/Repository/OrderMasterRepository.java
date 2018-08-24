package com.imooc.sell.Repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 买家订单git
 * @author: WangXue
 * @create: 2018-08-23 17:18
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {



}
