package org.techtown.hackytalky.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.techtown.hackytalky.R;
// MyPageFragment 예시
public class MyPageFragment extends Fragment {
    // ...

    private TextView usernameTextView;
    private TextView messageTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_page, container, false);

        // TextView 참조
        usernameTextView = view.findViewById(R.id.username);
        messageTextView = view.findViewById(R.id.message);

        UserViewModel userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        userViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            // 유저 데이터를 TextView에 표시
            usernameTextView.setText("이름 : " + user.getUser().getUsername());
            messageTextView.setText("메세지 : " + user.getUser().getMessage());
        });

        return view;
    }
}
