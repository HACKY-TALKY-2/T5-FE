package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Puzzle {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("size")
    private String size;
    @SerializedName("location")
    private String location;
    @SerializedName("pieces")
    private List<Piece> pieces;

    public Puzzle() {
    }

    public Puzzle(String id, String title, String size, String location, List<Piece> pieces) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.location = location;
        this.pieces = pieces;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
