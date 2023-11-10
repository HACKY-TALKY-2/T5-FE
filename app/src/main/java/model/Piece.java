package model;

import com.google.gson.annotations.SerializedName;

public class Piece {
    @SerializedName("index")
    private int index;

    @SerializedName("image")
    private String image;

    // Getters and Setters
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

