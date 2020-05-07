package com.njxz.springcloudconfigclient.controller;

import com.njxz.springcloudconfigclient.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 吴玥
 * @Title TestController
 * @Description
 * @date 2019/12/13
 */

@RestController
@Slf4j

//@Configuration
//@EnableConfigurationProperties(User.class)
public class TestController {
    @Autowired
    public User user;
//    @Value("${foo}")
//    private String foo;

    @RequestMapping("/getTestInfo")
    private String name() {
        System.out.println("dddddddddddd");
        System.out.println("ssss"+user.getFoo());
        return user.getFoo();
    }

//    @RequestMapping("/getUser")
//    private User getUser() {
//        System.out.println(user.toString());
//        return user;
//    }
}
