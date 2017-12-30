package ru.job4j.controllers;

import ru.job4j.models.UserStore;
import ru.job4j.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * The class UpdateAdmin.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2017
 */
public class UpdateAdmin extends HttpServlet {
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
        User user = users.getUser(req.getParameter("login"));
        req.setAttribute("user", user);
        req.setAttribute("admin", "yes");
        req.getRequestDispatcher("/WEB-INF/views/updateView.jsp").forward(req, resp);
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
        users.editUser(req.getParameter("oldLogin"), new User(req.getParameter("name"),
                req.getParameter("login"), req.getParameter("password"),
                users.getRole(Integer.parseInt(req.getParameter("role"))),
                req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
        req.setAttribute("login", req.getParameter("login"));
        req.getRequestDispatcher("/").forward(req, resp);
    }
}