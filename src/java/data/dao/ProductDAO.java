/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.dto.CategoryDTO;
import data.dto.ProductDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;
import utils.Utils;

/**
 *
 * @author TungNT
 */
public class ProductDAO {

    private static final String GET_CATEGORY = "SELECT categoryID, categoryName FROM tblCategory ORDER BY categoryID DESC";

    private static final String GET_PRODUCT_BY_CATEGORY_NAME = "SELECT productID, productName, price, image, quantity, P.categoryID, categoryName, importDate, usingDate, unit "
            + "FROM tblProduct P INNER JOIN tblCategory C ON P.categoryID = C.categoryID "
            + "WHERE categoryName = ? AND status = 1";

    private static final String GET_ALL_PRODUCT = "SELECT productID, productName, price, image, quantity, P.categoryID, categoryName, importDate, usingDate, unit "
            + "FROM tblProduct P INNER JOIN tblCategory C ON P.categoryID = C.categoryID "
            + "WHERE status = 1";

    private static final String SEARCH_PRODUCT = "SELECT productID, productName, price, image, quantity, P.categoryID, categoryName, importDate, usingDate, unit "
            + "FROM tblProduct P INNER JOIN tblCategory C ON P.categoryID = C.categoryID "
            + "WHERE productName LIKE ? AND status = 1";

    private static final String GET_PRODUCT_QUANTITY = "SELECT quantity FROM tblProduct "
            + "WHERE productID = ? AND status = 1";

    private static final String DELETE_PRODUCT = "UPDATE tblProduct "
            + "SET status = 0 "
            + "WHERE productID = ?";

    private static final String UPDATE_PRODUCT = "UPDATE tblProduct "
            + "SET price = ?, image = ?, quantity = ?, categoryID = (SELECT categoryID FROM tblCategory WHERE categoryName = ?), usingDate = ?, unit = ? "
            + "WHERE productID = ? AND status = 1";

    private static final String UPDATE_PRODUCT_V2 = "UPDATE tblProduct "
            + "SET price = ?, image = ?, quantity = ?, categoryID = (SELECT categoryID FROM tblCategory WHERE categoryName = ?), importDate = GETDATE(), usingDate = ?, unit = ? "
            + "WHERE productID = ? AND status = 1";

    private static final String CHECK_USING_DATE = "{call checkUsingDate(?)}";

    private static final String ADD_PRODUCT = "INSERT INTO tblProduct(productName, price, image, quantity, categoryID, importDate, usingDate, unit, status) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    
    private static final String UPDATE_NEW_QUANTITY = "UPDATE tblProduct "
            + "SET quantity = ? "
            + "WHERE productID = ?";
    private void checkProductUsingDate() throws SQLException {
        Connection conn = null;
        CallableStatement cs = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_PRODUCT);
                cs = conn.prepareCall(CHECK_USING_DATE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    cs.setInt(1, productID);
                    cs.execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public List<CategoryDTO> getAllCategories() throws SQLException {
        List<CategoryDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CATEGORY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");
                    list.add(new CategoryDTO(categoryID, categoryName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getAllProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                checkProductUsingDate();
                ptm = conn.prepareStatement(GET_ALL_PRODUCT);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");
                    String importDate = rs.getString("importDate");
                    String usingDate = rs.getString("usingDate");
                    String unit = rs.getString("unit");
                    list.add(new ProductDTO(productID, productName, price, image, quantity, categoryID, categoryName, importDate, usingDate, unit));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getAllProductsByCategoryName(String categoryName) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRODUCT_BY_CATEGORY_NAME);
                ptm.setString(1, categoryName);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    String categoryID = rs.getString("categoryID");
                    int quantity = rs.getInt("quantity");
                    String importDate = rs.getString("importDate");
                    String usingDate = rs.getString("usingDate");
                    String unit = rs.getString("unit");
                    list.add(new ProductDTO(productID, productName, price, image, quantity, categoryID, categoryName, importDate, usingDate, unit));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> searchProduct(String search) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_PRODUCT);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");
                    String importDate = rs.getString("importDate");
                    String usingDate = rs.getString("usingDate");
                    String unit = rs.getString("unit");
                    list.add(new ProductDTO(productID, productName, price, image, quantity, categoryID, categoryName, importDate, usingDate, unit));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public int getProductQuantity(int productID) throws SQLException {
        int quantity = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRODUCT_QUANTITY);
                ptm.setInt(1, productID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return quantity;
    }

    public boolean deleteProduct(int productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_PRODUCT);
                ptm.setInt(1, productID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean updateProduct(ProductDTO pro) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                if (pro.getQuantity() > getProductQuantity(pro.getProductID())) {
                    ptm = conn.prepareStatement(UPDATE_PRODUCT_V2);
                    ptm.setDouble(1, pro.getPrice());
                    ptm.setString(2, pro.getImage());
                    ptm.setInt(3, pro.getQuantity());
                    ptm.setString(4, pro.getCategoryName());
                    ptm.setString(5, pro.getUsingDate());
                    ptm.setString(6, pro.getUnit());
                    ptm.setInt(7, pro.getProductID());
                    check = ptm.executeUpdate() > 0 ? true : false;
                } else {
                    ptm = conn.prepareStatement(UPDATE_PRODUCT);
                    ptm.setDouble(1, pro.getPrice());
                    ptm.setString(2, pro.getImage());
                    ptm.setInt(3, pro.getQuantity());
                    ptm.setString(4, pro.getCategoryName());
                    ptm.setString(5, pro.getUsingDate());
                    ptm.setString(6, pro.getUnit());
                    ptm.setInt(7, pro.getProductID());
                    check = ptm.executeUpdate() > 0 ? true : false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean createNewProduct(ProductDTO p) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_PRODUCT);
                ptm.setString(1, p.getProductName());
                ptm.setDouble(2, p.getPrice());
                ptm.setString(3, p.getImage());
                ptm.setInt(4, p.getQuantity());
                ptm.setString(5, p.getCategoryID());
                ptm.setString(6, Utils.getCurrentDate());
                ptm.setString(7, p.getUsingDate());
                ptm.setString(8, p.getUnit());
                ptm.setBoolean(9, true);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean updateProductQuantity(int productID, int newQuantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_NEW_QUANTITY);
                ptm.setInt(1, newQuantity);
                ptm.setInt(2, productID);
                check = ptm.executeUpdate() > 0 ? true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
   
}
