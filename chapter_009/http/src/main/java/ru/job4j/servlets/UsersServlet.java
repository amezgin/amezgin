package ru.job4j.servlets;

import ru.job4j.UserStore;
import ru.job4j.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * The class UsersServlet.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 20.12.2017
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
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append(users.getUser(req.getParameter("login")).toString());
        pw.flush();
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
        resp.setContentType("text/html");
        users.addUser(new User(req.getParameter("name"), req.getParameter("login"),
                req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
    }

    /**
     * Overrides method doPut.
     *
     * @param req  request.
     * @param resp response.
     * @throws ServletException ServletException.
     * @throws IOException      IOException.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        users.editUser(req.getParameter("login"), new User(req.getParameter("name"),
                req.getParameter("login"), req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
    }

    /**
     * Overrides method doDelete.
     *
     * @param req  request.
     * @param resp response.
     * @throws ServletException ServletException.
     * @throws IOException      IOException.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        users.removeUser(req.getParameter("login"));
    }

    @Override
    public void destroy() {
        users.disconnectDB();
    }
}