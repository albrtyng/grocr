package com.albertandmanisha.grocr;

/**
 * @author albertyang .
 */
public class GalleryStyle9Model {

    public GalleryStyle9Model(String mTitle, String mAddress, String url){
        title = mTitle;
        address = mAddress;
        imageUrl = url;
    }

    public GalleryStyle9Model(){

    }

    private String id;
    private String imageUrl;
    private String title;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setPictureCount(String address) {
        this.address = address;
    }
}
