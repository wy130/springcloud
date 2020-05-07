package com.njxz.fitness.api.service;

import com.njxz.fitness.api.entity.UserEntity;
import com.njxz.fitness.base.ResponseBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴玥
 * @Title IMemberService
 * @Description
 * @date 2019/12/11
 */

public interface IMemberService {
// 实体类是存放接口项目还是 存放在实现项目 实体类存放在接口项目里面
    // 实体类和定义接口信息存放在接口项目
    // 代码实现存放在接口实现类里面

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name);

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo();
}
