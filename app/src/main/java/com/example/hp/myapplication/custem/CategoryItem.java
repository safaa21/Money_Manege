package com.example.hp.myapplication.custem;
public class CategoryItem {
    private String mCategoryName;
    private int mcatImage;

    public CategoryItem(String countryName, int flagImage) {
        mCategoryName = countryName;
        mcatImage = flagImage;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public int getcatImage() {
        return mcatImage;
    }
}