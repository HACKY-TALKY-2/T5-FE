package model;
import com.google.gson.annotations.SerializedName;

public class UserMeResponse {
    @SerializedName("user")
    private User user;
    @SerializedName("puzzle")
    private Puzzle puzzle;

    public UserMeResponse(User user, Puzzle puzzle) {
        this.user = user;
        this.puzzle = puzzle;
    }

    public User getUser() {
        return user;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }
}
