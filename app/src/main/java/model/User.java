package model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("username")
    private String username;
    @SerializedName("emoji")
    private String emoji;
    @SerializedName("message")
    private String message;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;

    public User() {
    }

    public User(String id, String lat, String lng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getMessage() {
        return message;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
