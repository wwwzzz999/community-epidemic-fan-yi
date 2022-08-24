package com.smf.wqphd.vo;


import java.util.Date;


public class LoginVo {
    private String username;
    private String password;
    private String validate;

    public LoginVo(String username, String password, String validate) {
        this.username = username;
        this.password = password;
        this.validate = validate;
    }

    public LoginVo() {
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", validate='" + validate + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
}
