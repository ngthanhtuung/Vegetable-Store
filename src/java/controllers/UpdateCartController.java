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
import javax.servlet.http.HttpSession;
import shopping.Cart;

/**
 *
 * @author TungNT
 */
public class UpdateCartController extends HttpServlet {

    private static final String ERROR = "cart.jsp";
    private static final String SUCCESS = "cart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
            int newQuantity = Integer.parseInt(request.getParameter("quantity"));
            ProductDAO dao = new ProductDAO();
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            ProductDTO pro = null;
            for (ProductDTO p : cart.getCart().values()) {
                if (p.getProductID() == productID) {
                    String productName = p.getProductName();
                    String image = p.getImage();
                    double price = p.getPrice();
                    pro = new ProductDTO(productID, productName, price, image, newQuantity);
                    break;
                }
            }
            boolean check = newQuantity <= dao.getProductQuantity(productID) ? true : false;
            if (check) {
                cart.update(productID, pro);
                session.setAttribute("CART", cart);
                url = SUCCESS;
            } else {
                request.setAttribute("PRODUCT_ERROR", pro);
                request.setAttribute("ERROR_SHOPPING_MESSAGE", "This product does not have enough stock to supply.");
            }
        } catch (Exception e) {
            log("Error at UpdateQuantityController: " + e.toString());
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
