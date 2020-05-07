package com.njxz.fitness.api.feign;

import com.njxz.fitness.api.fallback.MemberServiceFallback;
import com.njxz.fitness.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 吴玥
 * @Title MemberServiceFeign
 * @Description
 * @date 2019/12/11
 */
@FeignClient(value = "app-fitness-member",fallback = MemberServiceFallback.class)
public interface MemberServiceFeign extends IMemberService {
     // 服务降级 熔断
    // 实体类是存放接口项目还是 存放在实现项目 实体类存放在接口项目里面
    // 实体类和定义接口信息存放在接口项目
    // 代码实现存放在接口实现类里面

}
