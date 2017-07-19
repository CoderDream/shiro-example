package com.github.zhangkaitao.shiro.chapter7.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-1-29
 * <p>
 * Version: 1.0
 */
@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

	/** */
	private static final long serialVersionUID = 1791565745620209254L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SecurityUtils.getSubject().logout();
		req.getRequestDispatcher("/WEB-INF/jsp/logoutSuccess.jsp").forward(req,
				resp);
	}

}
