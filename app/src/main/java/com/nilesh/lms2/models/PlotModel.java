package com.nilesh.lms2.models;

public class PlotModel {
    String ids, img1_url,title,desc,location,phone,author;

    public PlotModel() {
    }

    public PlotModel(String id, String img1_url,  String title, String desc, String location, String phone, String author) {
        this.ids = ids;
        this.img1_url = img1_url;
        this.title = title;
        this.desc = desc;
        this.location = location;
        this.phone = phone;
        this.author = author;
    }

    public String getId() {
        return ids;
    }

    public void setId(String id) {
        this.ids = ids;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getImg1_url() {
        return img1_url;
    }

    public void setImg1_url(String img1_url) {
        this.img1_url = img1_url;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
