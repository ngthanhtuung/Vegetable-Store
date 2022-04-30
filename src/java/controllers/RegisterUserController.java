/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import common.Constants;
import data.dao.UserDAO;
import data.dto.UserDTO;
import data.dto.error.UserError;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Utils;

/**
 *
 * @author TungNT
 */
public class RegisterUserController extends HttpServlet {

    private static final String ERROR = "signup.jsp";
    private static final String SUCCESS = Constants.SEND_MAIL_VERIFY_CONTROLLER;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        try {
            String email = request.getParameter("email");
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String birthday = Utils.convertDate(request.getParameter("birthday"));
            String roleID = request.getParameter("roleID");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            boolean checkValidation = true;
            if (!password.equals(confirm)) {
                userError.setConfirm("Password is not matching");
                checkValidation = false;
            }
            if (checkValidation) {
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(email, fullName, password, roleID, address, birthday, phone);
                boolean checkDuplicate = dao.checkDuplicate(email);
                if (checkDuplicate) {
                    userError.setEmailError(email + " is existed, try another one.");
                    request.setAttribute("USER_ERROR", userError);
                } else {
                    request.setAttribute("USER_VERIFY", user);
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }

        } catch (Exception e) {
            log("Error at RegisterUserController: " + e.toString());
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
