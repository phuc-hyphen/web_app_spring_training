package fr.lernejo.todo;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApplicationIdentifierFilter implements javax.servlet.Filter {

    private final String ID = UUID.randomUUID().toString();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //before the rest
        if (servletResponse instanceof HttpServletResponse) {
            ((HttpServletResponse) servletResponse).addHeader("Instance-Id",this.ID);
        }
        filterChain.doFilter(servletRequest, servletResponse);
        //before the rest

    }
}
