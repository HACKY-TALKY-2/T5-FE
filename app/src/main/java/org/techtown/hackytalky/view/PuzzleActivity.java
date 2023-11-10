package org.techtown.hackytalky.view;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.techtown.hackytalky.R;

import model.User;

public class PuzzleActivity extends AppCompatActivity {
    private ImageView puzzleOne;
    private ImageView puzzleTwo;
    private ImageView puzzleThree;
    private ImageView puzzleFour;
    private ImageView puzzleFive;
    private ImageView puzzleSix;
    private ImageView puzzleSeven;
    private ImageView puzzleEight;
    private ImageView puzzleNine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        setPuzzleRadius();
        setHeaderEvent();
        setFooterEvent();
    }
    private void setPuzzleRadius(){
        findViewById(R.id.puzzle1).setClipToOutline(true);
        findViewById(R.id.puzzle2).setClipToOutline(true);
        findViewById(R.id.puzzle3).setClipToOutline(true);
        findViewById(R.id.puzzle4).setClipToOutline(true);
        findViewById(R.id.puzzle5).setClipToOutline(true);
        findViewById(R.id.puzzle6).setClipToOutline(true);
        findViewById(R.id.puzzle7).setClipToOutline(true);
        findViewById(R.id.puzzle8).setClipToOutline(true);
        findViewById(R.id.puzzle9).setClipToOutline(true);
    }

    private void setHeaderEvent() {
        ImageView userIcon = findViewById(R.id.userIcon);
        ImageView testIcon = findViewById(R.id.testIcon);
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
                    // TODO
                } else if (id == R.id.myPuzzle) {
                    // TODO
                } else if (id == R.id.myPage) {
                    // TODO
                } else {
                    return false;
                }
                return true;
            }
        });

    }
}