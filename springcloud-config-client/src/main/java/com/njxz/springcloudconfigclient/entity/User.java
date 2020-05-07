package com.njxz.springcloudconfigclient.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


/**
 * @author 吴玥
 * @Title User
 * @Description
 * @date 2019/12/19
 */
@Component
@ConfigurationProperties
@Data
//@RefreshScope
public class User {
//    @Value("${foo}")
   private String foo;

    private String name;
    private Integer age;
    private String sex;

}
