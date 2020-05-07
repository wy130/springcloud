package com.njxz.fitness.api.service.impl;

import com.njxz.fitness.api.entity.UserEntity;
import com.njxz.fitness.api.service.IMemberService;
import com.njxz.fitness.base.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴玥
 * @Title MemberServiceImpl
 * @Description
 * @date 2019/12/11
 */
@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/getMember",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name + "端口号:" + serverPort);
        userEntity.setAge(20);
        return userEntity;
    }

    @RequestMapping(value = "/getUserInfo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseBase getUserInfo() {
        System.out.println(" 我是会员服务,会员服务调用订单服务开始啦！！");
        try {
            // 会员服务接口产生1.5秒的延迟
            Thread.sleep(1500);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return setResultSuccess("订单服务接口调用会员服务接口成功....");
    }
}
