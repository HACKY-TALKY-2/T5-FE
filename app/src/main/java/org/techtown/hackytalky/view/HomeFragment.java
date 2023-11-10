package org.techtown.hackytalky.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import org.techtown.hackytalky.R;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        setPuzzleRadius();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_page, container, false);
        setPuzzleRadius(view);
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