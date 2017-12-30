package ru.job4j.servlets;

import ru.job4j.UserStore;
import ru.job4j.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        resp.setContentType("text/html");
        User user = users.getUser(req.getParameter("login"));
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Searched User</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h3>The searched user</h3>"
                + "<br>\n"
                + "<table border=\"1\">"
                + "<tr>\n"
                + "    <th>Name</th>\n"
                + "    <th>Login</th>\n"
                + "    <th>Email</th>\n"
                + "    <th>Create date</th>\n"
                + "</tr>");
        if (user != null) {
            pw.append(String.format("<tr>\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n</tr>\n",
                    user.getName(), user.getLogin(), user.getEmail(), user.getCreateDate()));
        } else {
            pw.append(String.format("User with login '%s' not found!", req.getParameter("login")));
        }
        pw.append("</table>\n");
        pw.append("<br>\n");
        pw.append("<form action = '" + req.getContextPath() + "/user' method = 'get'>\n"
                + "<button type='submit'>Return to the home page!</button>\n"
                + "</form>\n");
        pw.append("</body>\n");
        pw.append("</html>");
        pw.flush();
    }
}