package com.njxz.fitness.api.fallback;

import com.njxz.fitness.api.entity.UserEntity;
import com.njxz.fitness.api.feign.MemberServiceFeign;
import com.njxz.fitness.base.BaseApiService;
import com.njxz.fitness.base.ResponseBase;
import org.springframework.stereotype.Component;

/**
 * @author 吴玥
 * @Title MemberServiceFallback
 * @Description
 * @date 2019/12/18
 */
@Component
public class MemberServiceFallback extends BaseApiService implements MemberServiceFeign {
    @Override
    public UserEntity getMember(String name) {
        return null;
    }

    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务器忙，请稍后重试（以类的形式服务降级）");
    }
}
