/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import common.Actions;
import common.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TungNT
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            switch (action) {
                case Actions.LOGIN:
                    url = Constants.LOGIN_CONTROLLER;
                    break;
                case Actions.LOGOUT:
                    url = Constants.LOGOUT_CONTROLLER;
                    break;
                case Actions.REGISTER_USER:
                    url = Constants.REGISTER_USER_CONTROLLER;
                    break;
                case Actions.DELETE_PRODUCT:
                    url = Constants.DELETE_PRODUCT_CONTROLLER;
                    break;
                case Actions.FILTER_CATEGORY:
                    url = Constants.FILTER_CATEGORY_CONTROLLER;
                    break;
                case Actions.EDIT_PRODUCT:
                    url = Constants.PRODCUT_DETAIL_CONTROLLER;
                    break;
                case Actions.UPDATE_PRODUCT:
                    url = Constants.UPDATE_PRODUCT_CONTROLLER;
                    break;
                case Actions.SEARCH_PRODUCT:
                    url = Constants.SEARCH_PRODUCT_CONTROLLER;
                    break;
                case Actions.VERIFY:
                    url = Constants.VERIFY_USER_CONTROLLER;
                    break;
                case Actions.ADD_TO_CART:
                    url = Constants.ADD_TO_CART_CONTROLLER;
                    break;
                case Actions.UPDATE_QUANTITY:
                    url = Constants.UPDATE_QUANTITY_CONTROLLER;
                    break;
                case Actions.REMOVE_PRODCUT:
                    url = Constants.REMOVE_PRODUCT_FROM_CART_CONTROLLER;
                    break;
                case Actions.CANCEL_CART:
                    url = Constants.CANCEL_SHOPPING_CART_CONTROLLER;
                    break;
                case Actions.ADD_PRODUCT:
                    url = Constants.ADD_PRODUCT_CONTROLLER;
                    break;
                case Actions.CHECK_OUT:
                    url = Constants.CHECK_OUT_CONTROLLER;
                    break;

            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

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
