/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dto;

import utils.Utils;

/**
 *
 * @author TungNT
 */
public class ProductDTO {

    private int productID;
    private String productName;
    private double price;
    private String image;
    private int quantity;
    private String categoryID;
    private String categoryName;
    private String importDate;
    private String usingDate;
    private String priceShow;
    private String unit;

    public ProductDTO() {
        this.productID = 0;
        this.productName = "";
        this.price = 0;
        this.image = "";
        this.quantity = 0;
        this.categoryID = "";
        this.categoryName = "";
        this.importDate = "";
        this.usingDate = "";
        this.priceShow = "";
        this.unit = "";
    }

    public ProductDTO(int productID) {
        this.productID = productID;
    }

    public ProductDTO(int productID, String productName, double price, String image) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.image = image;
    }

    public ProductDTO(int productID, String productName, double price, String image, int quantity, String categoryID, String categoryName, String importDate, String usingDate, String unit) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.importDate = importDate;
        this.usingDate = usingDate;
        this.unit = unit;
    }
    

    
    public ProductDTO(int productID, String productName, double price, String image, int quantity, String categoryName, String importDate, String usingDate) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.importDate = importDate;
        this.usingDate = usingDate;
    }
    
  
    public ProductDTO(int productID, String productName, double price, String image, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }

    public ProductDTO(String productName, double price, String image, int quantity, String categoryID, String usingDate, String unit) {
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.usingDate = usingDate;
        this.unit = unit;
    }    

    public ProductDTO(int productID, String productName, double price, String image, int quantity, String categoryID, String categoryName, String importDate, String usingDate) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.importDate = importDate;
        this.usingDate = usingDate;
    }

    
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(String usingDate) {
        this.usingDate = usingDate;
    }

    public String getPriceShow() {
        return priceShow;
    }

    public void setPriceShow(String priceShow) {
        this.priceShow = priceShow;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    

    
    public String showPrice(double price) {
        return Utils.convertPrice(price);
    }
    
    public String showPriceTotal(double price, int quantity) {
        return Utils.convertPrice(price * quantity);
    }

}
