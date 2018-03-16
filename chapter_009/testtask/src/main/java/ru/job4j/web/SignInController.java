package ru.job4j.web;

import ru.job4j.dao.DaoFactoryImpl;
import ru.job4j.dao.UserDaoImpl;
import ru.job4j.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The class SigninController.
 *
 * @author Alexander Mezgin
 * @version 1.1
 * @since 29.12.2017
 */
public class SignInController extends HttpServlet {

    /**
     * The field of type DaoFactoryImpl.
     */
    private final DaoFactoryImpl daoFactory = DaoFactoryImpl.INSTANCE;

    /**
     * The field of type UserDaoImpl.
     */
    private UserDaoImpl users;

    /**
     * The init().
     * @param config config.
     * @throws ServletException ServletException.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            users = new UserDaoImpl(daoFactory.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
            User user = users.getByLogin(login);
            session.setAttribute("login", login);
            if ("ADMIN".equals(user.getRole().getName())) {
                resp.getWriter().write("./adminView.html");
            } else if ("USER".equals(user.getRole().getName())) {
                resp.getWriter().write("./userView.html");
            } else if ("MANDATOR".equals(user.getRole().getName())) {
                resp.getWriter().write("./mandatorView.html");
            }
        } else {
            resp.getWriter().write("false");
        }
    }
}