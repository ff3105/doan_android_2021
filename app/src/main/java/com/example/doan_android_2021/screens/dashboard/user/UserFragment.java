package com.example.doan_android_2021.screens.dashboard.user;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.doan_android_2021.MainActivity;
import com.example.doan_android_2021.R;
import com.example.doan_android_2021.models.User;
import com.example.doan_android_2021.screens.login.LoginActivity;
import com.example.doan_android_2021.screens.order.OrderActivity;
import com.example.doan_android_2021.utlis.SharedPref;

import java.util.Random;

public class UserFragment extends Fragment implements UserContact.UserView {
    private UserPresent userPresent;
    private LinearLayout llLogin;
    private LinearLayout llTitle;
    private LinearLayout userLogout;
    private LinearLayout userOrder;
    private TextView userName;
    private TextView userPhone;
    private RelativeLayout userAvatar;
    private TextView userAvatarText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_user, container, false);

        llLogin = root.findViewById(R.id.user_view_login);
        llTitle = root.findViewById(R.id.user_view_title);
        userName = root.findViewById(R.id.user_name);
        userPhone = root.findViewById(R.id.user_phone);
        userAvatar = root.findViewById(R.id.user_avatar);
        userAvatarText = root.findViewById(R.id.user_avatar_text);
        userLogout = root.findViewById(R.id.user_logout);
        userOrder = root.findViewById(R.id.user_order);

        SharedPref pref = new SharedPref(getContext());

        llLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        userLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref.clear();
                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        userOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), OrderActivity.class);
                startActivity(intent);
            }
        });

        userPresent = new UserPresent(this, pref);
        userPresent.init();

        return root;
    }

    @Override
    public void authSuccess(User user) {
        llLogin.setVisibility(View.GONE);
        llTitle.setVisibility(View.VISIBLE);
        userName.setText(user.getUser().getFullName());
        userPhone.setText(user.getUser().getPhoneNumber());
        userAvatarText.setText(user.getUser().getFullName().substring(0, 1).toUpperCase());
    }

    @Override
    public void authFail() {
        llLogin.setVisibility(View.VISIBLE);
        llTitle.setVisibility(View.GONE);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}