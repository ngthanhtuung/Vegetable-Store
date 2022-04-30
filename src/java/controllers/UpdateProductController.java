/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.dao.ProductDAO;
import data.dto.ProductDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TungNT
 */
public class UpdateProductController extends HttpServlet {

    private static final String ERROR = "productdetail.jsp";
    private static final String SUCCESS = "FilterCategoryController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
            String productName = request.getParameter("productName");
            double newPrice = Double.parseDouble(request.getParameter("price"));
            String image = request.getParameter("image");
            int newQuantity = Integer.parseInt(request.getParameter("quantity"));
            String categoryID = request.getParameter("cmbCategory").trim();
            String importDate = request.getParameter("importDate");
            String usingDate = request.getParameter("usingDate");
            String unit = request.getParameter("unit");
            ProductDTO pro = new ProductDTO(productID, productName, newPrice, image, newQuantity, categoryID, categoryID, importDate, usingDate, unit);
            if (pro != null) {
                ProductDAO proDao = new ProductDAO();
                boolean check = proDao.updateProduct(pro);
                if (check) {
                    request.setAttribute("MESSAGE", "Update successfully!");
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            log("Error at UpdateProductController");
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
