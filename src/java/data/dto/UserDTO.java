/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dto;

/**
 *
 * @author TungNT
 */
public class UserDTO {

    private String email;
    private String fullName;
    private String password;
    private String roleID;
    private String address;
    private String birthday;
    private String phone;

    public UserDTO() {
        this.email = "";
        this.fullName = "";
        this.password = "";
        this.roleID = "";
        this.address = "";
        this.birthday = "";
        this.phone = "";
    }

    public UserDTO(String email, String fullName, String address, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    
    public UserDTO(String email, String fullName, String password, String roleID, String address, String birthday, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.roleID = roleID;
        this.address = address;
        this.birthday = birthday;
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
