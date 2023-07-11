package com.crow.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
public class CorsConfig {
    @Bean
    @ConditionalOnMissingBean(WebFilter.class)
    public WebFilter corsFilter() {
        return (ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) -> {
            // 获取request对象
            ServerHttpRequest request = serverWebExchange.getRequest();
            if (!CorsUtils.isCorsRequest(request)) {
                return webFilterChain.filter(serverWebExchange);
            }

            // 跳过登录
            if ("/user/login".equals(request.getPath().toString())){
                return webFilterChain.filter(serverWebExchange);
            }

            // 获取请求头
            HttpHeaders requestHeaders = request.getHeaders();
            // 获取response对象
            ServerHttpResponse response = serverWebExchange.getResponse();
            // 获取请求头的请求方法
            HttpMethod requestMethod = requestHeaders.getAccessControlRequestMethod();
            // 获取响应头
            HttpHeaders responseHeaders = response.getHeaders();
            // 允许跨域
            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
            // 允许请求头
            responseHeaders.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                    requestHeaders.getAccessControlRequestHeaders());
            // 允许方法
            if (requestMethod != null) {
                responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, requestMethod.name());
            }
            // 允许证书
            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
            // 暴露响应头
            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, CorsConfiguration.ALL);
            // 每1个小时发送一次预请求
            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");

            // 获取方法
            HttpMethod method = request.getMethod();
            if (method == HttpMethod.OPTIONS) {
                response.setStatusCode(HttpStatus.OK);
                return Mono.empty();
            }

            return webFilterChain.filter(serverWebExchange);
        };
    }
}
