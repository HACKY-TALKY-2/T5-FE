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

    public User() {
    }

    public User(String id, String username, String emoji, String message) {
        this.id = id;
        this.username = username;
        this.emoji = emoji;
        this.message = message;
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
}
