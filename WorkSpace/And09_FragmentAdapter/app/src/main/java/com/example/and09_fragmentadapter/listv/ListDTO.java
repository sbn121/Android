package com.example.and09_fragmentadapter.listv;

public class ListDTO {
    private int imgRes;
    private int age;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListDTO(int imgRes, int age, String name) {
        this.imgRes = imgRes;
        this.age = age;
        this.name = name;
    }



}
