package org.techtown.hackytalky.view;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.techtown.hackytalky.R;

import java.util.ArrayList;
import java.util.List;

import model.Piece;
import model.Puzzle;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_page, container, false);
        setPuzzleRadius(view);

        List<ImageView> puzzleList = new ArrayList<ImageView>();
        puzzleList.add(view.findViewById(R.id.puzzle1));
        puzzleList.add(view.findViewById(R.id.puzzle2));
        puzzleList.add(view.findViewById(R.id.puzzle3));
        puzzleList.add(view.findViewById(R.id.puzzle4));
        puzzleList.add(view.findViewById(R.id.puzzle5));
        puzzleList.add(view.findViewById(R.id.puzzle6));
        puzzleList.add(view.findViewById(R.id.puzzle7));
        puzzleList.add(view.findViewById(R.id.puzzle8));
        puzzleList.add(view.findViewById(R.id.puzzle9));


        UserViewModel userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        userViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            // 유저 데이터를 TextView에 표시
            Puzzle puzzle = user.getPuzzle();
            for (Piece piece : puzzle.getPieces()) {
                Log.d("TAG123", String.valueOf(piece.getIndex()));
                puzzleList.get(piece.getIndex()).setImageResource(R.drawable.channel_06);
            }

        });

        Button getBonusButton = view.findViewById(R.id.getBonus);
        getBonusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(getContext());
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.get_bonus);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();

                Button okButton = dialog1.findViewById(R.id.getBonusOkButton);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });
            }
        });

        return view;
    }
    private void setPuzzleRadius(View view){
        view.findViewById(R.id.puzzle1).setClipToOutline(true);
        view.findViewById(R.id.puzzle2).setClipToOutline(true);
        view.findViewById(R.id.puzzle3).setClipToOutline(true);
        view.findViewById(R.id.puzzle4).setClipToOutline(true);
        view.findViewById(R.id.puzzle5).setClipToOutline(true);
        view.findViewById(R.id.puzzle6).setClipToOutline(true);
        view.findViewById(R.id.puzzle7).setClipToOutline(true);
        view.findViewById(R.id.puzzle8).setClipToOutline(true);
        view.findViewById(R.id.puzzle9).setClipToOutline(true);
    }
}