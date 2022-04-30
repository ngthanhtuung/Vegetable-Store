/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.dao.UserDAO;
import data.dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sendemail.UserEmailDTO;

/**
 *
 * @author TungNT
 */
public class VerifyUserController extends HttpServlet {

    private static final String ERROR = "signup.jsp";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserEmailDTO userEmail = (UserEmailDTO) session.getAttribute("AUTHCODE");
            String otp = request.getParameter("otp");
            if (otp.equals(userEmail.getCode())) {
                String email = userEmail.getEmail();
                String fullName = userEmail.getFullName();
                String password = userEmail.getPassword();
                String roleID = userEmail.getRoleID();
                String address = userEmail.getAddress();
                String birthday = userEmail.getBirthday();
                String phone = userEmail.getPhone();
                UserDTO user = new UserDTO(email, fullName, password, roleID, address, birthday, phone);
                UserDAO dao = new UserDAO();
                boolean check = dao.createUser(user);
                if (check) {
                    url = SUCCESS;
                    request.setAttribute("SUCCESS_MESSAGE", "Your account has been activated!");
                    session.invalidate();
                } else {
                    request.setAttribute("ERROR", "Unknown Error, try again!");
                    session.invalidate();
                }
            } else {
                request.setAttribute("ERROR", "OTP code is incorrect, please check and re-enter again!");
                url = "verify.jsp";
            }
        } catch (Exception e) {
            log("Error at VerifyUserController: " + e.toString());
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
