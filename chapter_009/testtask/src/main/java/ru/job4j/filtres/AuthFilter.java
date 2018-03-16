package ru.job4j.filtres;

import ru.job4j.dao.DaoFactoryImpl;
import ru.job4j.dao.UserDaoImpl;
import ru.job4j.model.User;

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
import java.sql.SQLException;

/**
 * The class AuthFilter.
 *
 * @author Alexander Mezgin
 * @version 1.1
 * @since 29.12.2017
 */
public class AuthFilter implements Filter {

    /**
     * The field of type DaoFactoryImpl.
     */
    private final DaoFactoryImpl daoFactory = DaoFactoryImpl.INSTANCE;

    /**
     * The field of type UserDaoImpl.
     */
    private UserDaoImpl users;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            users = new UserDaoImpl(daoFactory.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(true);
        User user = users.getByLogin((String) session.getAttribute("login"));
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