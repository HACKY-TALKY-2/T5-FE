package org.techtown.hackytalky.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.techtown.hackytalky.R;

import model.UserMeResponse;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuzzleActivity extends AppCompatActivity {
    private ServiceApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);
        setHeaderEvent();
        setFooterEvent();
        getUserData();

        Fragment selectedFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit();
    }

    private void getUserData() {
        service = RetrofitClient.getClient().create(ServiceApi.class);
        service.userMe(new User("b637f9d7-838b-4026-9e38-2e3e0faf278e", "37.50070054008517", "127.03649436112231")).enqueue(new Callback<UserMeResponse>() {
            @Override
            public void onResponse(Call<UserMeResponse> call, Response<UserMeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserMeResponse userMeResponse = response.body();
                    UserViewModel userViewModel = new ViewModelProvider(PuzzleActivity.this).get(UserViewModel.class);
                    userViewModel.setUser(userMeResponse);
                    Toast.makeText(PuzzleActivity.this, "로그인 성공 !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PuzzleActivity.this, "Failed to retrieve user data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserMeResponse> call, Throwable t) {
                Toast.makeText(PuzzleActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setHeaderEvent() {
        ImageView appIcon = findViewById(R.id.appIcon);
        ImageView userIcon = findViewById(R.id.userIcon);
        ImageView testIcon = findViewById(R.id.testIcon);

        appIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
        });

        userIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Dialog dialog1 = new Dialog(PuzzleActivity.this);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.dialog_nice_to_meet);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();

                Button niceToMeetButton = dialog1.findViewById(R.id.niceToMeetButton);
                niceToMeetButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                        Dialog dialog2 = new Dialog(PuzzleActivity.this);
                        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog2.setContentView(R.layout.dialog_get_puzzle);
                        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog2.show();

                        Button okButton = dialog2.findViewById(R.id.getPuzzleOkButton);
                        okButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog2.dismiss();
                            }
                        });
                    }
                });
            }
        });

        testIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(PuzzleActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_first_visit);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                Button okButton = dialog.findViewById(R.id.firstVisitOkButton);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void setFooterEvent() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selectedFragment = null;
                int id = item.getItemId();

                if (id == R.id.home) {
                    selectedFragment = new HomeFragment();
                } else if (id == R.id.myPuzzle) {
                    selectedFragment = new MyPuzzleFragment();
                } else if (id == R.id.myPage) {
                    selectedFragment = new MyPageFragment();
                } else {
                    return false;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
                return true;
            }
        });

    }
}