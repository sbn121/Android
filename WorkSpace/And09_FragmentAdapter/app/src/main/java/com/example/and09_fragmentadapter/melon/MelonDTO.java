package com.example.and09_fragmentadapter.melon;

public class MelonDTO {

    private int imgvRes, rank;

    private String title, artist;

    public int getImgvRes() {
        return imgvRes;
    }

    public void setImgvRes(int imgvRes) {
        this.imgvRes = imgvRes;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public MelonDTO(int imgvRes, int rank, String title, String artist) {
        this.imgvRes = imgvRes;
        this.rank = rank;
        this.title = title;
        this.artist = artist;
    }
}
