package com.github.zhangkaitao.shiro.chapter7.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-1-29
 * <p>
 * Version: 1.0
 */
@WebServlet(name = "unauthorizedServlet", urlPatterns = "/unauthorized")
public class UnAuthorizedServlet extends HttpServlet {

	/** */
	private static final long serialVersionUID = 4754631547368113064L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/unauthorized.jsp").forward(req,
				resp);
	}

}
