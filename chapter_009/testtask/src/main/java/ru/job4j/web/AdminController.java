package ru.job4j.web;

import com.google.gson.Gson;
import ru.job4j.dao.AddressDaoImpl;
import ru.job4j.dao.DaoFactoryImpl;
import ru.job4j.dao.MusicTypeDaoImpl;
import ru.job4j.dao.RoleDaoImpl;
import ru.job4j.dao.UserDaoImpl;
import ru.job4j.model.Address;
import ru.job4j.model.MusicType;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class AdminController.
 *
 * @author Alexander Mezgin
 * @version 1.1
 * @since 24.12.2017
 */
public class AdminController extends HttpServlet {
    /**
     * The field of type DaoFactoryImpl.
     */
    private final DaoFactoryImpl daoFactory = DaoFactoryImpl.INSTANCE;

    /**
     * The field of type UserRepositoryImpl.
     */
    private UserRepositoryImpl users;

    /**
     * Override destroy.
     */
    @Override
    public void destroy() {
        daoFactory.closeConnectionsPool();
        super.destroy();
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
        String action = req.getParameter("action");
        if (action == null) {
            try (Connection conn = daoFactory.getConnection()) {
                users = new UserRepositoryImpl(conn);
                resp.setContentType("text/json");
                resp.setCharacterEncoding("UTF-8");
                String json = new Gson().toJson(users.getAllUserWithAllDependencies());
                PrintWriter writer = new PrintWriter(resp.getOutputStream());
                writer.append(json);
                writer.flush();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("search")) {
            try (Connection conn = daoFactory.getConnection()) {
                resp.setContentType("text/json");
                resp.setCharacterEncoding("UTF-8");
                users = new UserRepositoryImpl(conn);
                User user = new UserDaoImpl(conn).getByLogin(req.getParameter("searchLogin"));
                if (user != null) {
                    Address address = users.getUserAddress(user);
                    List<MusicType> musicTypes = users.getUserMusicType(user);
                    user.setAddress(address);
                    user.setMusicTypeList(musicTypes);
                }
                String json = new Gson().toJson(user);
                PrintWriter writer = new PrintWriter(resp.getOutputStream());
                writer.append(json);
                writer.flush();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("delete")) {
            try (Connection conn = daoFactory.getConnection()) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                UserDaoImpl userDao = new UserDaoImpl(conn);
                userDao.delete(id);
                resp.sendRedirect("./adminView.html");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp.setContentType("text/json");
            resp.setCharacterEncoding("UTF-8");
            User user = null;
            Address address = null;
            if (action.equals("create")) {
                user = new User(null, null, null, null, null);
                user.setId(0);
                address = new Address(null, null, null, null, null);
            } else {
                try (Connection conn = daoFactory.getConnection()) {
                    Integer id = Integer.parseInt(req.getParameter("id"));
                    user = new UserDaoImpl(conn).getById(id);
                    address = new AddressDaoImpl(conn).getById(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            List<MusicType> musicType = null;
            try (Connection conn = daoFactory.getConnection()) {
                musicType = new MusicTypeDaoImpl(conn).getAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String userJson = new Gson().toJson(user);
            String addressJson = new Gson().toJson(address);
            String musicTypeJson = new Gson().toJson(musicType);
            PrintWriter writer = new PrintWriter(resp.getOutputStream());
            writer.append("[");
            writer.append(userJson);
            writer.append(",");
            writer.append(addressJson);
            writer.append(",");
            writer.append(musicTypeJson);
            writer.append("]");
            writer.flush();
        }
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
        Integer id = Integer.parseInt(req.getParameter("id"));
        Role role = null;
        try (Connection conn = daoFactory.getConnection()) {
            Integer idRole = Integer.parseInt(req.getParameter("role"));
            role = new RoleDaoImpl(conn).getById(idRole);
            role.setId(idRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Address address = new Address(req.getParameter("postcode"), req.getParameter("city"),
                req.getParameter("street"), req.getParameter("home"), id);
        String[] music = req.getParameter("musictype").split(",");
        List<MusicType> musicTypes = new ArrayList<>();
        for (String mus : music) {
            musicTypes.add(new MusicType(mus));
        }
        User user = new User(req.getParameter("login"), req.getParameter("password"),
                role, address, musicTypes);
        user.setId(id);
        users.add(user);
    }
}