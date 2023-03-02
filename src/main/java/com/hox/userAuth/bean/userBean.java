package com.hox.userAuth.bean;

import org.springframework.context.annotation.ComponentScan;

public class userBean {
    private String password;
    private String email;
    private String username;
    private String documentID;

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void userBean(String us, String ps, String email, String documentID){
        this.documentID = documentID;
        username = us;
        password = ps;
        this.email = email;
    }

    public userBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "userBean{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
