package com.crow.filter;

import com.crow.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:Auth
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/19 8:06
 * @Role
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    private RedisUtils redisUtils;

    @Autowired
    public AuthFilter(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    private String[] open = {"/auth/login","/auth/role"};

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = String.valueOf(exchange.getRequest().getPath());
        for (String s : open) {
            if (path.equals(s)){
                return chain.filter(exchange);
            }
        }

        // 获取传入的tok
        String tok = exchange.getRequest().getQueryParams().getFirst("tok");
        System.out.println(tok);
        if (tok != null){
            if (redisUtils.exists(tok)){
                // 获取登录后的tok
                String auth = (String) redisUtils.getKey(tok);
                System.out.println("取出后："+auth);
                if (tok.equals(auth)){
                    System.out.println("权限完毕");
                    return chain.filter(exchange);
                }
            }
        }

        System.out.println("失败");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
