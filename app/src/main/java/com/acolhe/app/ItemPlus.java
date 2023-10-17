package com.acolhe.app;

public class ItemPlus {
    private String title;
    private String subtitle;
    private int imageResourceId;

    public ItemPlus(String title, String subtitle, int imageResourceId) {
        this.title = title;
        this.subtitle = subtitle;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
