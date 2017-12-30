package ru.job4j.controllers;

import ru.job4j.models.UserStore;
import ru.job4j.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The class SearchUser.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2017
 */
public class SearchUser extends HttpServlet {

    /**
     * The field of type UserStore.
     */
    private final UserStore users = UserStore.INSTANCE;

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
        User user = users.getUser(req.getParameter("searchLogin"));
        req.setAttribute("searchedUser", user);
        req.getRequestDispatcher("/WEB-INF/views/searchView.jsp").forward(req, resp);
    }
}