package com.cms.servlets;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.cms.core.UsersImpl;
import com.cms.utils.CMS_Utilities;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users/*")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UsersServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getPathInfo();
		String res = "00-Invalid request!";
		if ((url != null) && (CMS_Utilities.isValidUsersUrl(url) == true)) {
			UsersImpl users = new UsersImpl();
			int i = 0;
			String value = "";
			BufferedReader br = request.getReader();
			while ((i = br.read()) != -1) {
				value += (char) i;								
			}
			
			System.out.println("---" + value + "---");
			res = users.signIn(value);
			if (res.length() < 5){
				res = "success";
				request.getSession().setAttribute("userId", res);				
			}
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.write(res);
		out.close();
	}
}
