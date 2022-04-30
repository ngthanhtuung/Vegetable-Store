/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import data.dto.ProductDTO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TungNT
 */
public class Cart {
    
    private Map<Integer, ProductDTO> cart;

    public Cart() {
    }

    public Cart(Map<Integer, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<Integer, ProductDTO> getCart() {
        return this.cart;
    }

    public void setCart(Map<Integer, ProductDTO> cart) {
        this.cart = cart;
    }

    
    
    public void add(ProductDTO pro) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(pro.getProductID())){
            int currentQuantity = this.cart.get(pro.getProductID()).getQuantity();
            pro.setQuantity(currentQuantity + pro.getQuantity());
        }
        cart.put(pro.getProductID(), pro);
    }
    
    public void delete(int id) {
        if(this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public void update(int id, ProductDTO newPro) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.replace(id, newPro);
        }
    }
    
    public int getQuantityProductInCart(int productID) {
        int quantity = 0;
        if (this.cart.containsKey(productID)) {
            quantity = this.cart.get(productID).getQuantity();
        }
        return quantity;
    } 
    
    
    public int getSizeCart(){
        int size = 0;
        size = this.cart.size();
        return size;
    }
}
