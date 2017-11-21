package com.albertandmanisha.grocr;

/**
 * @author albertyang .
 */
public class ItemModel {

    public ItemModel(String mTitle, String mCategory, String url, Double mPrice){
        title = mTitle;
        category = mCategory;
        imageUrl = url;
        price = mPrice;
    }

    public ItemModel(){

    }

    private String id;
    private String imageUrl;
    private String title;
    private String category;
    private Double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}
}
