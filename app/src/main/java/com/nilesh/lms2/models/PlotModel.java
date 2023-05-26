package com.nilesh.lms2.models;

public class PlotModel {
    String id, img1_url,img2_url,img3_url,title,desc,ad1,ad2,ad3,pincode,author;

    public PlotModel() {
    }

    public PlotModel(String id, String img1_url, String img2_url, String img3_url, String title, String desc, String ad1, String ad2, String ad3, String pincode, String author) {
        this.id = id;
        this.img1_url = img1_url;
        this.img2_url = img2_url;
        this.img3_url = img3_url;
        this.title = title;
        this.desc = desc;
        this.ad1 = ad1;
        this.ad2 = ad2;
        this.ad3 = ad3;
        this.pincode = pincode;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg1_url() {
        return img1_url;
    }

    public void setImg1_url(String img1_url) {
        this.img1_url = img1_url;
    }

    public String getImg2_url() {
        return img2_url;
    }

    public void setImg2_url(String img2_url) {
        this.img2_url = img2_url;
    }

    public String getImg3_url() {
        return img3_url;
    }

    public void setImg3_url(String img3_url) {
        this.img3_url = img3_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAd1() {
        return ad1;
    }

    public void setAd1(String ad1) {
        this.ad1 = ad1;
    }

    public String getAd2() {
        return ad2;
    }

    public void setAd2(String ad2) {
        this.ad2 = ad2;
    }

    public String getAd3() {
        return ad3;
    }

    public void setAd3(String ad3) {
        this.ad3 = ad3;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
