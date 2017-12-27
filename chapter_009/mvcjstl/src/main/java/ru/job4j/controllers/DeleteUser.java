package ru.job4j.controllers;

import ru.job4j.models.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The class DeleteUser.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2017
 */
public class DeleteUser extends HttpServlet {
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
        users.removeUser(req.getParameter("login"));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}