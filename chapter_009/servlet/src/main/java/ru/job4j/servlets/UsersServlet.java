package ru.job4j.servlets;

import ru.job4j.UserStore;
import ru.job4j.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Users</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h3>Create the new user</h3>\n"
                + "<form action = '" + req.getContextPath() + "/create' method = 'post'>\n"
                + "Name: <input type = 'text' name = 'name'/>\n"
                + "Login: <input type = 'text' name = 'login'/>\n"
                + "Email: <input type = 'text' name = 'email'/>\n"
                + "<input type = 'submit' value = 'create'/>\n"
                + "</form>\n"
                + "<br>\n"
                + "<h3>Search the user</h3>\n"
                + "<form action = '" + req.getContextPath() + "/search' method = 'post'>\n"
                + "Login: <input type = 'text' name = 'login'/>\n"
                + "<input type = 'submit' value = 'search'/>\n"
                + "</form>\n"
                + "<br>\n"
                + "<h3>List of users</h3>\n"
                + "<table border=\"1\">"
                + "<tr>\n"
                + "    <th>Name</th>\n"
                + "    <th>Login</th>\n"
                + "    <th>Email</th>\n"
                + "    <th>Create date</th>\n"
                + "    <th>Edit user</th>\n"
                + "    <th>Delete user</th>\n"
                + "</tr>\n");
        List<User> listUsers = users.getAllUser();
        for (User user : listUsers) {
            pw.append(String.format("<tr>\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n"
                            + "<td>\n"
                            + "<form action = '" + req.getContextPath() + "/update' method = 'get'>\n"
                            + "<input type = 'hidden' name = 'login' value = '%s'/>\n"
                            + "<button type='submit'>Edit user</button>\n"
                            + "</form>\n"
                            + "</td>\n"
                            + "<td>\n"
                            + "<form action = '" + req.getContextPath() + "/delete' method = 'post'>\n"
                            + "<input type = 'hidden' name = 'login' value = '%s'/>\n"
                            + "<button type='submit'>Delete user</button>\n"
                            + "</form>\n"
                            + "</td>\n"
                            + "</tr>\n", user.getName(), user.getLogin(), user.getEmail(), user.getCreateDate(),
                    user.getLogin(), user.getLogin()));
        }
        pw.append("</table>\n");
        pw.append("</body>\n");
        pw.append("</html>");
        pw.flush();
    }
}