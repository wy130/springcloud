package com.njxz.fitness.api.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.njxz.fitness.api.entity.UserEntity;
import com.njxz.fitness.api.feign.MemberServiceFeign;
import com.njxz.fitness.api.service.IOrderService;
import com.njxz.fitness.base.BaseApiService;
import com.njxz.fitness.base.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴玥
 * @Title OrderServiceImpl
 * @Description
 * @date 2019/12/11
 */
@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {
    // 订单服务继承会员服务接口，用来实现feign客户端 减少重复接口代码
    @Autowired
    private MemberServiceFeign memberServiceFeigin;

    @RequestMapping("/orderToMember")
    public String orderToMember(String name) {
        UserEntity user = memberServiceFeigin.getMember(name);
        return user == null ? "没有找到用户信息" : user.toString();
    }

    //没有解决服务雪崩效应

    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo() {
        return memberServiceFeigin.getUserInfo();
    }

    // 解决服务雪崩效应
    // fallbackMethod 方法的作用：服务降级执行
    // @HystrixCommand 默认开启线程池隔离方式,服务降级,服务熔断
    // 设置Hystrix服务超时时间
    /**
     * @HystrixCommand<br>
     * 					默认开启服务隔离方式 以线程池方式<br>
     *                     默认开启服务降级执行方法orderToMemberUserInfoHystrixFallback<br>
     *                     默认开启服务熔断机制<br>
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberUserInfoHystrix")
    public ResponseBase orderToMemberUserInfoHystrix() {
        System.out.println("orderToMemberUserInfoHystrix:" + "线程池名称:" + Thread.currentThread().getName());
        return memberServiceFeigin.getUserInfo();
    }

    public ResponseBase orderToMemberUserInfoHystrixFallback() {
        return setResultSuccess("返回一个友好的提示：服务降级,服务器忙，请稍后重试!");
    }

    // 订单服务接口
    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo() {
        System.out.println("orderInfo:" + "线程池名称:" + Thread.currentThread().getName());
        return setResultSuccess();
    }

    // Hystrix 有两种方式配置保护服务 通过注解和接口形式
}
