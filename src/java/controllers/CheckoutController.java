/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.dao.OrderDAO;
import data.dao.ProductDAO;
import data.dto.OrderDTO;
import data.dto.OrderDetailDTO;
import data.dto.ProductDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shopping.Cart;
import utils.Utils;

/**
 *
 * @author TungNT
 */
public class CheckoutController extends HttpServlet {

    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "success.html";
    private static final String CART_PAGE = "cart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String email = request.getParameter("email");
            String fullName = request.getParameter("fullName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            OrderDAO orderDao = new OrderDAO();
            HttpSession session = request.getSession();
            if (session != null) {
                Cart cart = (Cart) session.getAttribute("CART");
                double totalOrderPrice = 0;
                String orderID = Utils.createOrderID();
                List<OrderDetailDTO> orderDetails = new ArrayList<>();
                ProductDAO proDao = new ProductDAO();
                ProductDTO pro = null;
                List<ProductDTO> listProductID = new ArrayList<>();
                boolean checkInventory = true;
                if (cart != null) {
                    Map<Integer, ProductDTO> product = cart.getCart();
                    if (!product.isEmpty()) {
                        for (ProductDTO p : product.values()) {
                            if (p.getQuantity() > proDao.getProductQuantity(p.getProductID())) {
                                String productName = p.getProductName();
                                double price = p.getPrice();
                                String image = p.getImage();
                                listProductID.add(new ProductDTO(p.getProductID(), productName, price, image));
                            }
                        }
                        if (listProductID.isEmpty()) {
                            for (ProductDTO p : product.values()) {
                                totalOrderPrice += (p.getPrice() * p.getQuantity());
                                String orderDetailID = Utils.createOrderID();
                                orderDetails.add(new OrderDetailDTO(orderDetailID, p.getPrice(), p.getQuantity(), orderID, p.getProductID()));
                                int inventory = proDao.getProductQuantity(p.getProductID());
                                boolean check = proDao.updateProductQuantity(p.getProductID(), (inventory - p.getQuantity()));
                                if (check == false) {
                                    return;
                                }

                            }
                            session.removeAttribute("CART");
                            OrderDTO orderDTO = new OrderDTO(orderID, Utils.getCurrentDate(), totalOrderPrice, email, fullName, phone, address, orderDetails);
                            orderDao.createOrder(orderDTO);
                            request.setAttribute("SHOPPING_MESSAGE", "Check out successfully!");
                            url = SUCCESS;
                        } else {
                            request.setAttribute("PRODUCT_ERROR_CHECKOUT", listProductID);
                            request.setAttribute("ERROR_SHOPPING_MESSAGE", "This product does not have enough stock to supply.");
                            url = CART_PAGE;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("Error at CheckoutController: " + e.toString());
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
