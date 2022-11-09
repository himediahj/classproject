package com.firstcoding.firstapp.product;

public class Product {
    private String[] list = {"item1", "item2", "item3", "item4", "item5"};

    private int price = 1000;

    // VO(value object)개념으로 getter만 만듦
    public String[] getList() {
        return list;
    }

    public int getPrice() {
        return price;
    }
}
