package com.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/servletone")
public class servletone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public static final int TAILLE_TAMPON = 10240;
	 public static final String CHEMIN_FICHIERS = "C:/file-dest/"; // A changer
	     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletone() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("prenom")) {
	                    request.setAttribute("prenom", cookie.getValue());
	                }
	            }
	        }
	             
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        
	        Cookie cookie = new Cookie("prenom", prenom);
	        cookie.setMaxAge(60 * 60 * 24 * 30);
	        response.addCookie(cookie);
	        
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);


	    }   
	}
