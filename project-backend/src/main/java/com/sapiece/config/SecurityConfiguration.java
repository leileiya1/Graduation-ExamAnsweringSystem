package com.sapiece.config;

import com.sapiece.entity.RestBean;
import com.sapiece.entity.vo.response.AuthorizeVO;
import com.sapiece.util.JwtUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

/**
 * @Author SAPiece
 * @Create 2023-11-08 11:38
 * @Package com.sapiece.config
 * @Project GraduationDesign
 * @Filename SecurityConfiguration
 * @Version 1.0
 */
@Configuration
public class SecurityConfiguration {
    @Resource
    JwtUtils jwtUtils;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(config -> config
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(config->config
                        .loginProcessingUrl("/api/auth/login")
                        .successHandler(this::onAuthenticationSuccess)
                        .failureHandler(this::onAuthenticationFailure))
                .logout(config->config
                        .logoutUrl("/api/auth/logout")
                        .logoutSuccessHandler(this::onLogoutSuccess))
                .csrf(AbstractHttpConfigurer::disable)
                //将session进行关闭由jwt进行处理
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
    response.setContentType("application/json;utf-8");
        User user = (User) authentication.getPrincipal();
        String token=jwtUtils.createJwt(user,1,"小米");
        AuthorizeVO vo = new AuthorizeVO();
        vo.setExpire(jwtUtils.expireTime());
        vo.setRole("1");
        vo.setToken(token);
        vo.setUsername("小米");
        response.getWriter().write(RestBean.success(vo).asJsonString());
    }
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;utf-8");
response.getWriter().write(RestBean.failure(401, exception.getMessage()).asJsonString());
    }
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

    }
}
