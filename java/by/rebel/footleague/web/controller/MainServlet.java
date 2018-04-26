package by.rebel.footleague.web.controller;

import static by.rebel.footleague.web.util.WebConstantDeclaration.REQUEST_PARAM_ACTION;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.rebel.footleague.web.action.ActionManagerContext;
import by.rebel.footleague.web.action.BaseAction;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	private static void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		String action = request.getParameter(REQUEST_PARAM_ACTION);
		BaseAction baseAction = ActionManagerContext.getAction(action, context);
		String page = baseAction.executeAction(request);
		if (action != null) {
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			response.getWriter().println("Incorrect Action!");
		}

	}
}
