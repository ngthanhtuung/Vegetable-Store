/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.dto.UserDTO;
import utils.DBUtils;
import utils.Encryption;
import utils.Utils;

/**
 *
 * @author TungNT
 */
public class UserDAO {

    private static final String LOGIN = "SELECT fullName, roleID, address, birthday, phone FROM tblUsers "
            + "WHERE email = ? AND password = ? AND status = 1";
    private static final String EMAIL_LOGIN = "SELECT email, fullName, password, roleID, address, birthday, phone "
            + "FROM tblUsers "
            + "WHERE email = ? AND status = 1";
    private static final String CHECK_DUPLICATE = "SELECT fullName FROM tblUsers "
            + "WHERE email = ? AND status = 1";
    private static final String CREATE_USER = "INSERT INTO tblUsers(email, fullName, password, roleID, address, birthday, phone, status) "
            + "VALUES(?,?,?,?,?,?,?,?)";

    public UserDTO getUser(String email, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                boolean check = rs.next();
                if (check) {
                    String fullName = rs.getString("fullName");
                    String roleID = Utils.convertRoleID(rs.getInt("roleID"));
                    String address = rs.getString("address");
                    String birthday = rs.getString("birthday");
                    String phone = rs.getString("phone");
                    user = new UserDTO(email, fullName, password, roleID, address, birthday, phone);
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
        return user;
    }

    public UserDTO getUserByEmail(String email) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(EMAIL_LOGIN);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = Utils.convertRoleID(rs.getInt("roleID"));
                    String address = rs.getString("address");
                    String birthday = rs.getString("birthday");
                    String phone = rs.getString("phone");
                    user = new UserDTO(email, fullName, "****", roleID, address, birthday, phone);
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
        return user;
    }

    public boolean checkDuplicate(String email) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }
    
    public boolean createUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_USER);
                ptm.setString(1, user.getEmail());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, Encryption.getPasswordEncryption(user.getPassword()));
                ptm.setInt(4, Utils.convertRoleID(user.getRoleID()));
                ptm.setString(5, user.getAddress());
                ptm.setString(6, user.getBirthday());
                ptm.setString(7, user.getPhone());
                ptm.setBoolean(8, true);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return check;
    }
}
