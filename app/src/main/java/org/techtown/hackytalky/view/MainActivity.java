package org.techtown.hackytalky.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.techtown.hackytalky.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, PuzzleActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            // '홈' 아이템 클릭 시 수행할 작업
            Intent intent = new Intent(MainActivity.this, PuzzleActivity.class);
            startActivity(intent);
        } else if (id == R.id.myPuzzle) {
            setContentView(R.layout.my_puzzle);
        } else if (id == R.id.myPage) {
            // '마이페이지' 아이템 클릭 시 수행할 작업
        }

        return super.onOptionsItemSelected(item);
    }

}