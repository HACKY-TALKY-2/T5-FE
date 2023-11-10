package org.techtown.hackytalky.view;

import model.UserMeResponse;
import model.Puzzle;
import model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceApi {
    @POST("/api/user/me")
    @Headers("Content-Type: application/json")
    Call<UserMeResponse> userMe(@Body User userData);
    @POST("/api/user/puzzle")
    @Headers("Content-Type: application/json")
    Call<UserMeResponse> userPuzzle(@Body Puzzle puzzleData);
    @POST("/api/bump/exchange")
    @Headers("Content-Type: application/json")
    Call<UserMeResponse> bumpExchange(@Body User userData);
}
