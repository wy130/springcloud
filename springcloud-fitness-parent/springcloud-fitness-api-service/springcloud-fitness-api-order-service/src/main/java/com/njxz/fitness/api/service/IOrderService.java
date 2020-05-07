package com.njxz.fitness.api.service;

import com.njxz.fitness.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 吴玥
 * @Title IOrderService
 * @Description
 * @date 2019/12/11
 */
public interface IOrderService {
    // 订单服务调用会员服务接口信息 feign
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);

    // 订单服务接口调用会员服务接口
    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo();

    // 订单服务接口
    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo();
}
