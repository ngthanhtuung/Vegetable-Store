/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.dto.OrderDTO;
import data.dto.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import utils.DBUtils;
import utils.Utils;

/**
 *
 * @author TungNT
 */
public class OrderDAO {

    private static final String CREATE_ORDER = "INSERT INTO tblOrder(orderID, orderDate, total, email, fullName, phone, address, status) "
            + "VALUES (?,?,?,?,?,?,?,?)";
     private static final String CREATE_DETAIL_ORDER = "INSERT INTO tblOrderDetail(detailID, price, quantity, orderID, productID) "
            + "VALUES (?,?,?,?,?)";
     
    public OrderDTO createOrder(OrderDTO order) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_ORDER);
                ptm.setString(1, order.getOrderID());
                ptm.setString(2, Utils.getCurrentDate());
                ptm.setDouble(3, order.getTotal());
                ptm.setString(4, order.getEmail());
                ptm.setString(5, order.getFullName());
                ptm.setString(6, order.getPhone());
                ptm.setString(7, order.getAddress());
                ptm.setBoolean(8, true);
                if (ptm.executeUpdate() > 0) {
                   if (createOrderDetail(order.getOrders()) != null){
                       return order;
                   }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return null;
    }
    
    public List<OrderDetailDTO> createOrderDetail(List<OrderDetailDTO> orderD) throws SQLException{
        int effectedRow = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_DETAIL_ORDER);
                OrderDetailDTO order;
                for (int i = 0; i < orderD.size(); i++) {
                    order = orderD.get(i);
                    ptm.setString(1, order.getDetailID());
                    ptm.setDouble(2, order.getPrice());
                    ptm.setInt(3, order.getQuantity());
                    ptm.setString(4, order.getOrderID());
                    ptm.setInt(5, order.getProductID());
                    if (ptm.executeUpdate() > 0) {
                        effectedRow++;
                    }
                }  
                if (effectedRow == orderD.size()){
                    return orderD;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return null;
    }
}
