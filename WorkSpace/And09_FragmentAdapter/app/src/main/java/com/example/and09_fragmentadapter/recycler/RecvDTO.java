package com.example.and09_fragmentadapter.recycler;

public class RecvDTO {
    private int imgRes, age;

    private String gedner, name, address;

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGedner() {
        return gedner;
    }

    public void setGedner(String gedner) {
        this.gedner = gedner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RecvDTO(int imgRes, int age, String gedner, String name, String address) {
        this.imgRes = imgRes;
        this.age = age;
        this.gedner = gedner;
        this.name = name;
        this.address = address;
    }

}
