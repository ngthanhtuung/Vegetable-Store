/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author TungNT
 */
public class Constants {
    public static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=VegetableStore";
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "tungntse151167";
    public static final String GOOGLE_CLIENT_ID = "1085468771805-uqqgf4dsts8cct07a66810r6ugdl1s0s.apps.googleusercontent.com";
    public static final String GOOGLE_CLIENT_SECRET = "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";
    public static final String GOOGLE_REDIRECT_URI = "http://localhost:8080/VegetableStore/LoginGoogleController";
    public static final String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static final String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static final String GOOGLE_GRANT_TYPE = "authorization_code";
    
    public static final String LOGIN_CONTROLLER = "LoginController";
    public static final String LOGOUT_CONTROLLER = "LogoutController";
    public static final String REGISTER_USER_CONTROLLER = "RegisterUserController";
    public static final String DELETE_PRODUCT_CONTROLLER = "DeleteProductController";
    public static final String FILTER_CATEGORY_CONTROLLER = "FilterCategoryController";
    public static final String PRODCUT_DETAIL_CONTROLLER = "ProductDetailTransferController";
    public static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";
    public static final String SEND_MAIL_VERIFY_CONTROLLER = "SendOTPController";
    public static final String VERIFY_USER_CONTROLLER = "VerifyUserController";
    public static final String ADD_TO_CART_CONTROLLER = "AddToCartController";
    public static final String UPDATE_QUANTITY_CONTROLLER = "UpdateCartController";
    public static final String REMOVE_PRODUCT_FROM_CART_CONTROLLER = "RemoveProductCartController";
    public static final String CANCEL_SHOPPING_CART_CONTROLLER = "CancelShoppingCartController";
    public static final String SEARCH_PRODUCT_CONTROLLER = "SearchController";
    public static final String ADD_PRODUCT_CONTROLLER = "AddProductController";
    public static final String CHECK_OUT_CONTROLLER = "CheckoutController";
    
}
