/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dto;

import java.util.List;

/**
 *
 * @author TungNT
 */
public class OrderDTO {

    private String orderID;
    private String orderDate;
    private double total;
    private String email;
    private String fullName;
    private String phone;
    private String address;
    private List<OrderDetailDTO> orders;

    public OrderDTO() {
        this.orderID = "";
        this.orderDate = "";
        this.total = 0;
        this.email = "";
        this.fullName = "";
        this.phone = "";
        this.address = "";
        this.orders = null;
    }

    public OrderDTO(String orderID, String orderDate, double total, String email, String fullName, String phone, String address, List<OrderDetailDTO> orders) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.total = total;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.orders = orders;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderDetailDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetailDTO> orders) {
        this.orders = orders;
    }

}
