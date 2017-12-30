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
 * The class UpdateUser.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2017
 */
public class UpdateUser extends HttpServlet {
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
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Searched User</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h3>Enter the new data for user!</h3>"
                + "<br>\n"
                + "<form action = '" + req.getContextPath() + "/update' method = 'post'>\n");
        pw.append(String.format("<input type = 'hidden' name = 'oldLogin' value = '%s'/>\n", login));
        pw.append("Name: <input type = 'text' name = 'name'/>\n"
                + "Login: <input type = 'text' name = 'login'/>\n"
                + "Email: <input type = 'text' name = 'email'/>\n"
                + "<input type = 'submit' value = 'update'/>\n"
                + "</form>\n");
        pw.append("</body>\n");
        pw.append("</html>");
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
        users.editUser(req.getParameter("oldLogin"), new User(req.getParameter("name"), req.getParameter("login"),
                req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
        resp.sendRedirect(req.getContextPath() + "/user");
    }
}