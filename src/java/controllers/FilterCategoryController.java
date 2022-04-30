/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.dao.ProductDAO;
import data.dto.CategoryDTO;
import data.dto.ProductDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author TungNT
 */
public class FilterCategoryController extends HttpServlet {

    private static final String ERROR = "error-404.html";
    private static final String ADMIN_PAGE = "admin.jsp";
    private static final String INDEX_PAGE = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            String position = request.getParameter("position");
            String categoryName = request.getParameter("cmbCategory").trim();
            ProductDAO proDao = new ProductDAO();
            List<CategoryDTO> cateList = proDao.getAllCategories();
            List<ProductDTO> proList = proDao.getAllProductsByCategoryName(categoryName);
            request.setAttribute("LIST_CATEGORIES", cateList);
            request.setAttribute("LIST_PRODUCTS", proList);
            if (categoryName.equals("All Product")) {
                switch (position) {
                    case "admin_page":
                        url = "TransferDataToAdminController";
                        break;
                    case "index_page":
                        url = "OnlineShoppingController";
                        break;
                }
            } else if (categoryName.isEmpty()) {
                switch (position) {
                    case "admin_page":
                        url = ADMIN_PAGE;
                        break;
                    case "index_page":
                        url = INDEX_PAGE;
                        break;
                }
            } else {
                switch (position) {
                    case "admin_page":
                        url = ADMIN_PAGE;
                        break;
                    case "index_page":
                        url = INDEX_PAGE;
                        break;
                }
            }

        } catch (Exception e) {
            log("Error at FilterCategoryController: " + e.toString());
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
