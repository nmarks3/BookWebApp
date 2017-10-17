/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.jgl.bookwebapp.controller;

import edu.wctc.distjava.jgl.bookwebapp.model.Author;
import edu.wctc.distjava.jgl.bookwebapp.model.AuthorDao;
import edu.wctc.distjava.jgl.bookwebapp.model.AuthorService;
import edu.wctc.distjava.jgl.bookwebapp.model.IAuthorDao;
import edu.wctc.distjava.jgl.bookwebapp.model.MySqlDataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jlombardo
 */
@WebServlet(name = "AuthorController", urlPatterns = {"/authorController"})
public class AuthorController extends HttpServlet {

    public static final String ACTION = "action";
    public static final String AUTHOR_ID = "id";
    public static final String LIST_ACTION = "list";
    public static final String DELETE_ACTION = "delete";
    public static final String ADD_ACTION = "add";
    public static final String UPDATE_ACTION = "update";
    public static final String AUTHOR_NAME = "name";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String destination = "/authorList.jsp"; // default

        try {
            String action = request.getParameter(ACTION);
            String id = request.getParameter(AUTHOR_ID);
            String name = request.getParameter(AUTHOR_NAME);
            String errorMsg = "";


            Date date = new Date();

            IAuthorDao dao = new AuthorDao(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/book",
                    "root", "root",
                    new MySqlDataAccess()
            );

            AuthorService authorService = new AuthorService(dao);

            List<Author> authorList = null;

            // Retrives list of authors
            if (action.equalsIgnoreCase(LIST_ACTION)) {
                authorList = authorService.getAuthorList();
                request.setAttribute("authorList", authorList);
                // Deletes author 
            } else if (action.equalsIgnoreCase(DELETE_ACTION)) {
                authorService.removeAuthorById(id);
                authorList = authorService.getAuthorList();
                request.setAttribute("authorList", authorList);
                // Adds author
            } else if (action.equalsIgnoreCase(ADD_ACTION)) {
                authorService.addAuthor(Arrays.asList(name, date));
                authorList = authorService.getAuthorList();
                request.setAttribute("authorList", authorList);
                // Updates author
            } else if (action.equalsIgnoreCase(UPDATE_ACTION)) {
                destination = "/authorUpdate.jsp";
                request.setAttribute("id", id);
                authorService.updateAuthorById(Arrays.asList(name, date), Integer.parseInt(id));            
            }
        } catch (Exception e) {
            destination = "/authorList.jsp";
            request.setAttribute("errMessage", e.getMessage());
        }

        RequestDispatcher view
                = request.getRequestDispatcher(destination);
        view.forward(request, response);

    }

    // use if statements for actionresults ex edit? or delete?
    // url AuthorController?action=create&authorName=Bob%20Smith
    // date added is a new date();
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
