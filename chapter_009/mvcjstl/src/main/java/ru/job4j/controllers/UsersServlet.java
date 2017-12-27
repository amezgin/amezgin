package ru.job4j.controllers;

import ru.job4j.models.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The class UsersServlet.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2017
 */
public class UsersServlet extends HttpServlet {

    /**
     * The field of type UserStore.
     */
    private final UserStore users = UserStore.getInstance();

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
        req.setAttribute("usersList", users.getAllUser());
        req.getRequestDispatcher("/WEB-INF/views/userView.jsp").forward(req, resp);
    }
}