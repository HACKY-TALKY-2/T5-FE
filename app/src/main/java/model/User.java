package model;

public class User {
    private String userName;
    private String userLocation;

    public User(String userName, String userLocation){
        this.userName = userName;
        this.userLocation = userLocation;
    }

    public String getUserName(){
        return userName;
    }

    public String getUserLocation(){
        return userLocation;
    }
}
