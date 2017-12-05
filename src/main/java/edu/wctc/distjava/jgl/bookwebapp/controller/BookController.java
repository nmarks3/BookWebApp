/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
//package edu.wctc.distjava.jgl.bookwebapp.controller;
////
//
//import edu.wctc.distjava.jgl.bookwebapp.model.Author;
//import edu.wctc.distjava.jgl.bookwebapp.model.AuthorFacade;
//import edu.wctc.distjava.jgl.bookwebapp.model.Book;
//import edu.wctc.distjava.jgl.bookwebapp.model.BookFacade;
//import java.io.IOException;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "BookController", urlPatterns = {"/bookController"})
//public final class BookController extends HttpServlet {
//
//    @EJB
//    private BookFacade bookFacade;
//
//    public static final String ACTION = "action";
//    public static final String AUTHOR_ID = "id";
//    public static final String LIST_ACTION = "list";
//    public static final String DELETE_ACTION = "delete";
//    public static final String ADD_ACTION = "add";
//    public static final String UPDATE_ACTION = "update";
//    public static final String AUTHOR_NAME = "name";
//    public static final String BOOK_ID = "bookId";
//    public static final String BOOK_TITLE = "title";
//    public static final String BOOK_ISBN = "isbn";
//
//////    // method that requests the database data and executes the user inputs to the database 
//    protected final void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        String destination = "/bookList.jsp"; // default
//
//        List<Book> bookList = null;
//        bookList = bookFacade.findAll();
////            request.setAttribute("bookList", bookList);
////            System.out.println("OUTPUTTING THE LIST NOW");
////            System.out.println(bookList);
//
//        try {
////            List<Book> bookList = null;
//            // bookList = bookFacade.findAll();
////            request.setAttribute("bookList", bookList);
////            System.out.println("OUTPUTTING THE LIST NOW");
////            System.out.println(bookList);
////            
//            String action = request.getParameter(ACTION);
////            String id = request.getParameter(AUTHOR_ID);
////            String name = request.getParameter(AUTHOR_NAME);
////            List<Author> authorList = null;
//
//            // Retrives list of authors
//            if (action.equalsIgnoreCase(LIST_ACTION)) {
//                bookList = bookFacade.findAll();
//                request.setAttribute("bookList", bookList);
//            } else if (action.equalsIgnoreCase(ADD_ACTION)) {
//                String title = request.getParameter(BOOK_TITLE);
//                String isbn = request.getParameter(BOOK_ISBN);
//                String authorId = request.getParameter(AUTHOR_ID);
//                //bookFacade.addOrUpdateNewBook(null, title, isbn, authorId);
//                bookFacade.createBook(title, isbn, authorId);
//                bookList = bookFacade.findAll();
//                request.setAttribute("bookList", bookList);
//            } else if (action.equalsIgnoreCase(DELETE_ACTION)) {
//                String bookId = request.getParameter(BOOK_ID);
//                // bookFacade.deleteBook(bookId);
//                bookFacade.deleteBookById(bookId);
//                bookList = bookFacade.findAll();
//                request.setAttribute("bookList", bookList);
//            } else if (action.equalsIgnoreCase(UPDATE_ACTION)) {
//                destination = "/bookUpdate.jsp";
//                String title = request.getParameter(BOOK_TITLE);
//                String isbn = request.getParameter(BOOK_ISBN);
//                String authorId = request.getParameter(AUTHOR_ID);
//                String bookId = request.getParameter(BOOK_ID);
//
//                request.setAttribute("bookId", bookId);
//                request.setAttribute("title", title);
//                request.setAttribute("isbn", isbn);
//                request.setAttribute("authorId", authorId);
//                bookFacade.updateBookById(bookId, title, isbn, authorId);
//            }
//        } catch (Exception e) {
//            destination = "/bookList.jsp";
//            request.setAttribute("errMessage", e.getMessage());
//            System.out.println(e.getMessage());
//        }
//        RequestDispatcher view
//                = request.getRequestDispatcher(destination);
//        view.forward(request, response);
//    }
//
//    @Override
//    public void init() throws ServletException {
//
//    }
//
////     <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
