package com.sapiece.filter;

import com.sapiece.util.Const;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author SAPiece
 * @Create 2023-11-21 18:47
 * @Package com.sapiece.filter
 * @Project GraduationDesign
 * @Filename CorsFilter
 * @Version 1.0
 */
@Component
@Order(Const.ORDER_CORS)
public class CorsFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request,
                            HttpServletResponse response,
                            FilterChain chain) throws IOException, ServletException {
        this.addCorsHeader(request, response);
        chain.doFilter(request,response);
    }
    public void addCorsHeader(HttpServletRequest request,
                              HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin",Const.ORIGINAL_REQUEST);
        response.addHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,OPTIONS");
        response.addHeader("Access-Control-Allow-Headers","Authorization,Content-Type");
    }
}
