package com.akbarprojec.loginmvp.View.AllfragmrntView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akbarprojec.loginmvp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentProfile extends Fragment {
    public static String KEY_USER = "user";
    public static String KEY_LEVEL = "level";

    TextView userid, level;
    String user,lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userid = view.findViewById(R.id.tv_user);
        level = view.findViewById(R.id.tv_level);

        //mengambil argument yang dikirim dari ActivityMain
        user = getArguments().getString(KEY_USER);
        lv = getArguments().getString(KEY_LEVEL);

        //menampilkan ke TextView
        userid.setText(user);
        level.setText(lv);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


}
