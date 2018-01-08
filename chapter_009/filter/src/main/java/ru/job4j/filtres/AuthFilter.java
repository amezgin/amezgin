package ru.job4j.filtres;

import ru.job4j.models.User;
import ru.job4j.models.UserStore;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The class AuthFilter.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 29.12.2017
 */
public class AuthFilter implements Filter {

    /**
     * The field of type UserStore.
     */
    private final UserStore users = UserStore.INSTANCE;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(true);
        User user = users.getUser((String) session.getAttribute("login"));
        if (request.getRequestURI().contains("/signin")) {
            chain.doFilter(req, resp);
        } else if (user == null) {
            ((HttpServletResponse) resp).sendRedirect("/signin");
        } else if ("USER".equals(user.getRole().getName())) {
            if (request.getRequestURI().contains("/user")) {
                chain.doFilter(req, resp);
            } else {
                ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            if ("ADMIN".equals(user.getRole().getName())) {
                chain.doFilter(req, resp);
            } else {
                ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }

    @Override
    public void destroy() {

    }
}