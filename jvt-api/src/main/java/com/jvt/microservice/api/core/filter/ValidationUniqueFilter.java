package com.jvt.microservice.api.core.filter;


import com.jvt.microservice.infrastructure.http.HttpHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@SuppressWarnings("restriction")
public class ValidationUniqueFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if ("POST".equalsIgnoreCase(httpServletRequest.getMethod()) || "PUT".equalsIgnoreCase(httpServletRequest.getMethod())) {
            // 防止流读取一次后就没有了, 所以需要将流继续写出去
            ServletRequest requestWrapper = new BodyReaderHttpServletRequest(httpServletRequest);
            String body = HttpHelper.getBodyString(requestWrapper);
            requestWrapper.setAttribute("_validationUnique", body);
            chain.doFilter(requestWrapper, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
