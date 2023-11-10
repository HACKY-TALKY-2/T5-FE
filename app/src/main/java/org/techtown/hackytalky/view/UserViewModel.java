package org.techtown.hackytalky.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import model.User;
import model.UserMeResponse;

public class UserViewModel extends ViewModel {
    private MutableLiveData<UserMeResponse> userLiveData = new MutableLiveData<>();

    public void setUser(UserMeResponse userMeResponse) {
        userLiveData.setValue(userMeResponse);
    }

    public LiveData<UserMeResponse> getUser() {
        return userLiveData;
    }
}

