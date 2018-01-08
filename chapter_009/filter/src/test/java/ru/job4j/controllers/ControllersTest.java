package ru.job4j.controllers;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ru.job4j.models.User;
import ru.job4j.models.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The class ControllersTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 03.01.2018
 */
public class ControllersTest {

    /**
     * This test for controller CreateUser with added user for role "USER".
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void createUserTest() throws ServletException, IOException {
        CreateUser createUser = new CreateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("test6");
        when(request.getParameter("login")).thenReturn("test6");
        when(request.getParameter("password")).thenReturn("test6");
        when(request.getParameter("role")).thenReturn("2");
        when(request.getParameter("email")).thenReturn("test6@test.ru");

        createUser.doPost(request, response);
        User user = UserStore.INSTANCE.getUser("test6");
        String result = user.getLogin();

        assertThat("test6", is(result));
    }

    /**
     * This test for controller CreateUser with added user for role "ADMIN".
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void createAdminTest() throws ServletException, IOException {
        CreateUser createUser = new CreateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("root1");
        when(request.getParameter("login")).thenReturn("root1");
        when(request.getParameter("password")).thenReturn("root1");
        when(request.getParameter("role")).thenReturn("1");
        when(request.getParameter("email")).thenReturn("root1@root.ru");

        createUser.doPost(request, response);
        User user = UserStore.INSTANCE.getUser("root1");

        assertEquals("root1", user.getLogin());
    }

    /**
     * This test for controller UpdateUser for method doPost().
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void updateUserTestMethodDoPost() throws ServletException, IOException {
        UpdateUser updateUser = new UpdateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("oldLogin")).thenReturn("test6");
        when(request.getParameter("name")).thenReturn("test5");
        when(request.getParameter("login")).thenReturn("test5");
        when(request.getParameter("password")).thenReturn("test5");
        when(request.getParameter("role")).thenReturn("2");
        when(request.getParameter("email")).thenReturn("test5@test.ru");
        when(request.getRequestDispatcher("/user")).thenReturn(dispatcher);

        updateUser.doPost(request, response);
        User user = UserStore.INSTANCE.getUser("test5");

        assertEquals("test5", user.getLogin());
    }

    /**
     * This test for controller UpdateUser for method doGet().
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void updateUserTestMethodDoGet() throws ServletException, IOException {
        UpdateUser updateUser = new UpdateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/updateView.jsp")).thenReturn(dispatcher);
        updateUser.doGet(request, response);

        verify(dispatcher).forward(request, response);
    }

    /**
     * This test for controller UpdateAdmin for method doPost().
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void updateAdminTestMethodDoPost() throws ServletException, IOException {
        UpdateAdmin updateAdmin = new UpdateAdmin();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("oldLogin")).thenReturn("root1");
        when(request.getParameter("name")).thenReturn("root2");
        when(request.getParameter("login")).thenReturn("root2");
        when(request.getParameter("password")).thenReturn("root2");
        when(request.getParameter("role")).thenReturn("2");
        when(request.getParameter("email")).thenReturn("root2@root.ru");
        when(request.getRequestDispatcher("/")).thenReturn(dispatcher);

        updateAdmin.doPost(request, response);
        User user = UserStore.INSTANCE.getUser("root2");

        assertEquals("root2", user.getLogin());
    }

    /**
     * This test for controller UpdateAdmin for method doGet().
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void updateAdminTestMethodDoGet() throws ServletException, IOException {
        UpdateAdmin updateAdmin = new UpdateAdmin();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/updateView.jsp")).thenReturn(dispatcher);
        updateAdmin.doGet(request, response);

        verify(dispatcher).forward(request, response);
    }

    /**
     * This test for controller DeleteUser.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void deleteUserTest() throws ServletException, IOException {
        DeleteUser deleteUser = new DeleteUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test5");

        deleteUser.doPost(request, response);
        User user = UserStore.INSTANCE.getUser("test5");

        assertNull(user);
    }

    /**
     * This test for controller SigninController with invalid parameters.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void whenGetWrongLoginAndPasswordThenReturnError() throws ServletException, IOException {
        SigninController si = new SigninController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        String[] attributes = new String[2];

        when(request.getParameter("login")).thenReturn("wrong");
        when(request.getParameter("password")).thenReturn("wrong");

        doAnswer(new Answer<String[]>() {
            @Override
            public String[] answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();

                attributes[0] = (String) arguments[0];
                attributes[1] = (String) arguments[1];
                return attributes;
            }
        }).when(request).setAttribute("error", "Credentional invalid");
        when(request.getRequestDispatcher("/WEB-INF/views/loginView.jsp")).thenReturn(dispatcher);
        si.doPost(request, response);

        assertEquals("error", attributes[0]);
        assertEquals("Credentional invalid", attributes[1]);
    }

    /**
     * This test for controller SigninController with admins parameters.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void whenGetAdminLoginAndPasswordThenReturnTrue() throws ServletException, IOException {
        SigninController si = new SigninController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("password")).thenReturn("root");
        when(request.getSession()).thenReturn(session);

        si.doPost(request, response);
        verify(session).setAttribute("login", "root");
    }

    /**
     * This test for controller SigninController with user parameters.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void whenGetUserLoginAndPasswordThenReturnTrue() throws ServletException, IOException {
        SigninController si = new SigninController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getParameter("login")).thenReturn("test6");
        when(request.getParameter("password")).thenReturn("test6");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(String.format("%s/user", request.getContextPath()))).thenReturn(dispatcher);

        si.doPost(request, response);
        verify(session).setAttribute("login", "test6");
    }

    /**
     * This test for controller SignoutController.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void whenSingOutThenReturnSessionAttributeIsNull() throws ServletException, IOException {
        SignoutController so = new SignoutController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/WEB-INF/views/loginView.jsp")).thenReturn(dispatcher);

        so.doPost(request, response);
        verify(session).invalidate();
    }

    /**
     * This test for controller SearchUser.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void updateSearchUserTest() throws ServletException, IOException {
        SearchUser searchUser = new SearchUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/searchView.jsp")).thenReturn(dispatcher);
        searchUser.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }

    /**
     * This test for controller UserServlet.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void userServletTest() throws ServletException, IOException {
        UsersServlet usersServlet = new UsersServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/userView.jsp")).thenReturn(dispatcher);
        usersServlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }

    /**
     * This test for controller AdminServlet.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void adminServletTest() throws ServletException, IOException {
        AdminServlet adminServlet = new AdminServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/adminView.jsp")).thenReturn(dispatcher);
        adminServlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }
}