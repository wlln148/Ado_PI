package br.com.carStore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter("/admin/*")
public class AutenticationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if(isUSerLoggedOn(httpServletRequest)) {
            chain.doFilter(servletRequest, response);

        } else {
            servletRequest.setAttribute("message", "Usuário não autenticado");
            servletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);
        }
    }

    @Override
    public void destroy() {}

    private boolean isUSerLoggedOn(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getSession().getAttribute("LoggedUser") != null;
    }
}