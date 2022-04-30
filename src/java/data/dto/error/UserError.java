/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dto.error;

/**
 *
 * @author TungNT
 */
public class UserError {
    
    private String emailError;
    private String fullNameError;
    private String passwordError;
    private String confirm;
    private String roleIDError;
    private String addressError;
    private String birthdayError;
    private String phoneError;
    private String messageError;

    public UserError() {
        this.emailError = "";
        this.fullNameError = "";
        this.passwordError = "";
        this.confirm = "";
        this.roleIDError = "";
        this.addressError = "";
        this.birthdayError = "";
        this.phoneError = "";
        this.messageError = "";
    }

    public UserError(String emailError, String fullNameError, String passwordError, String confirm, String roleIDError, String addressError, String birthdayError, String phoneError, String messageError) {
        this.emailError = emailError;
        this.fullNameError = fullNameError;
        this.passwordError = passwordError;
        this.confirm = confirm;
        this.roleIDError = roleIDError;
        this.addressError = addressError;
        this.birthdayError = birthdayError;
        this.phoneError = phoneError;
        this.messageError = messageError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getBirthdayError() {
        return birthdayError;
    }

    public void setBirthdayError(String birthdayError) {
        this.birthdayError = birthdayError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
    
    
    
    
    
}
