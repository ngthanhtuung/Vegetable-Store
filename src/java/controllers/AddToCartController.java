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
public class AddToCartController extends HttpServlet {

    private static final String ERROR = "OnlineShoppingController";
    private static final String SUCCESS = "FilterCategoryController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
            String productName = request.getParameter("productName");
            String image = request.getParameter("image");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            ProductDAO dao = new ProductDAO();
            HttpSession session = request.getSession();
            boolean check = quantity <= dao.getProductQuantity(productID) ? true : false;
            if (check) {
                ProductDTO p = new ProductDTO(productID, productName, price, image, quantity);
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart == null) {
                    cart = new Cart();
                    cart.add(p);
                    session.setAttribute("CART", cart);
                    url = SUCCESS;
                    String message = "Add '" + productName + "' to your cart successfully!";
                    request.setAttribute("SHOPPING_MESSAGE", message);
                } else {
                    int cartQuantity = cart.getQuantityProductInCart(productID);
                    int inventory = dao.getProductQuantity(productID);
                    boolean checkCart = (cartQuantity + quantity) <= inventory ? true : false;
                    if (checkCart) {
                        cart.add(p);
                        session.setAttribute("CART", cart);
                        url = SUCCESS;
                        String message = "Add '" + productName + "' to your cart successfully!";
                        request.setAttribute("SHOPPING_MESSAGE", message);
                    } else {
                        String message = productName + " only has " + (dao.getProductQuantity(productID) - cart.getQuantityProductInCart(productID)) + "kg in warehouse.";
                        request.setAttribute("ERROR_SHOPPING_MESSAGE", message);
                    }
                }
            } else {
                String message = productName + " does not have enough stock to supply.";
                request.setAttribute("ERROR_SHOPPING_MESSAGE", message);
            }

        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
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
