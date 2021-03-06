package ru.job4j.filtres;

import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The class AuthFilterTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 03.01.2018
 */
public class AuthFilterTest {

    /**
     * This test for filter AuthFilter.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void whenRequestContainsSigninThenChain() throws IOException, ServletException {
        AuthFilter authFilter = new AuthFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("login")).thenReturn("root");
        when(request.getRequestURI()).thenReturn("/signin");

        authFilter.doFilter(request, response, chain);

        verify(request).getSession(true);
        verify(session).getAttribute("login");
        verify(request).getRequestURI();
        verify(chain).doFilter(request, response);
    }

    /**
     * This test for filter AuthFilter.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void whenUserIsNullThenSendRedirect() throws IOException, ServletException {
        AuthFilter authFilter = new AuthFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("login")).thenReturn("wrong");
        when(request.getRequestURI()).thenReturn("/login");

        authFilter.doFilter(request, response, chain);

        verify(request).getSession(true);
        verify(session).getAttribute("login");
        verify(request).getRequestURI();
        verify(response).sendRedirect("/signin");
    }

    /**
     * This test for filter AuthFilter.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void whenGetUserAndURIContainsUserThenCallChain() throws IOException, ServletException {
        AuthFilter authFilter = new AuthFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("login")).thenReturn("test6");
        when(request.getRequestURI()).thenReturn("/user");

        authFilter.doFilter(request, response, chain);

        verify(request).getSession(true);
        verify(session).getAttribute("login");
        verify(request, times(2)).getRequestURI();
        verify(chain).doFilter(request, response);
    }

    /**
     * This test for filter AuthFilter.
     *
     * @throws ServletException servlet exception.
     * @throws IOException      IOException.
     */
    @Test
    public void whenGetAdminCallChain() throws IOException, ServletException {
        AuthFilter authFilter = new AuthFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("login")).thenReturn("root");
        when(request.getRequestURI()).thenReturn("/");

        authFilter.doFilter(request, response, chain);

        verify(request).getSession(true);
        verify(session).getAttribute("login");
        verify(request).getRequestURI();
        verify(chain).doFilter(request, response);
    }
}