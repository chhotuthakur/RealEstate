package com.nilesh.lms2.models;

public class UserModel {
    String id,username,email,phone,add1,add2,add3,pincode,dpurl;

    public UserModel() {
    }

    public UserModel(String id, String username, String email, String phone, String add1, String add2, String add3, String pincode, String dpurl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
        this.pincode = pincode;
        this.dpurl = dpurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDpurl() {
        return dpurl;
    }

    public void setDpurl(String dpurl) {
        this.dpurl = dpurl;
    }
}
