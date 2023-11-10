package org.techtown.hackytalky.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

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
}