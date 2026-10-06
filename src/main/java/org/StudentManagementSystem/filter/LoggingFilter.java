package org.StudentManagementSystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //Request log filter->dispatcher->controller
        System.out.println("Incoming request : " + httpRequest.getMethod() + " "
                + httpRequest.getRequestURI());
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            //Response log controller->dispatcher->filter
            System.out.println("Response :" + httpServletResponse.getStatus());
        }

    }
}
