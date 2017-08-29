package com.sys.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter {

	 static final String ORIGIN = "Origin";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 response.addHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Allow-Credentials", "true");
         response.addHeader("Access-Control-Max-Age", "10");
         response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
       System.out.println(request.getSession().getId());
		
        if (request.getMethod().equals("OPTIONS")) {
            try {
                response.getWriter().print("OK");
                response.getWriter().flush();
            } catch (IOException e) {
            e.printStackTrace();
            }
        } else{
            filterChain.doFilter(request, response);
        }
	}

}
