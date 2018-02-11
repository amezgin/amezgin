package ru.job4j.controllers;

import ru.job4j.models.User;
import ru.job4j.models.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The class SigninController.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 29.12.2017
 */
public class SigninController extends HttpServlet {

    /**
     * The field of type UserStore.
     */
    private final UserStore users = UserStore.INSTANCE;

    /**
     * Overrides method doGet.
     *
     * @param req  request.
     * @param resp response.
     * @throws ServletException ServletException.
     * @throws IOException      IOException.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("loginView.html").forward(req, resp);
    }

    /**
     * Overrides method doPost.
     *
     * @param req  request.
     * @param resp response.
     * @throws ServletException ServletException.
     * @throws IOException      IOException.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        if (users.isCredentional(login, password)) {
            HttpSession session = req.getSession();
            User user = users.getUser(login);
            session.setAttribute("login", login);
            if ("ADMIN".equals(user.getRole().getName())) {
                resp.getWriter().write("./adminView.html");
            } else if ("USER".equals(user.getRole().getName())) {
                resp.getWriter().write("./userView.html");
            }
        } else {
            resp.getWriter().write("false");
        }
    }
}