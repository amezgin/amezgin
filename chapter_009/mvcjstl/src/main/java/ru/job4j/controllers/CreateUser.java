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
 * The class CreateUser.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2017
 */
public class CreateUser extends HttpServlet {

    /**
     * The field of type UserStore.
     */
    private final UserStore users = UserStore.getInstance();

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
        users.addUser(new User(req.getParameter("name"), req.getParameter("login"),
                req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}