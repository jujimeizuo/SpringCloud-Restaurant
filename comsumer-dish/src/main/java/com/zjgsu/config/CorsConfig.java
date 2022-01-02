package com.zjgsu.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1 设置访问源地址
        corsConfiguration.addAllowedOriginPattern("*");
        // 2 设置访问源请求头
        corsConfiguration.addAllowedHeader("*");
        // 3 设置访问源请求方法
        corsConfiguration.addAllowedMethod("*");

        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        // 4 暴露哪些头部信息
        corsConfiguration.addExposedHeader("*");

        return corsConfiguration;
    }
    /**
     @Bean
     public CorsFilter corsFilter() {
     log.info("跨域设置。。。。");
     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
     // 对接口配置跨域设置
     source.registerCorsConfiguration("/**", buildConfig());
     return new CorsFilter(source);
     }
     */

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 5 对接口配置跨域设置
        source.registerCorsConfiguration("/**", buildConfig());
        //有多个filter时此处设置改CorsFilter的优先执行顺序
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
