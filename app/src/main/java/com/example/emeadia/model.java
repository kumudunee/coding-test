package com.example.emeadia;

public class model {

    String img;
    String title;
    String address;

    public model(String img, String title, String address)
    {
        this.img = img;
        this.title = title;
        this.address = address;
    }

    //constructor
    public model(){

    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
