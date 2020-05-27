package com.example.reading_group_management_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button loginBtn = (Button)findViewById(R.id.login_btn);
        Button mainpageBtn = (Button)findViewById(R.id.mainpage_btn);
        Button listSettingBtn = (Button)findViewById(R.id.list_setting_btn);
        Button presentationBtn = (Button)findViewById(R.id.presentation_btn);
        Button non_member_group_homeBtn = (Button)findViewById(R.id.non_member_group_home_btn);
        Button noteBtn = (Button)findViewById(R.id.button_note);
        Button speechBtn = (Button)findViewById(R.id.button_speechlist);

        mainpageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainPageActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        listSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), first_list_setting_popup.class);
                startActivity(intent);
            }
        });
        presentationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Presentation1Activity.class);
                startActivity(intent);
            }
        });
        non_member_group_homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), non_member_group_home.class);
                startActivity(intent);
            }
        });
        noteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NotificationList.class);
                startActivity(intent);
            }
        });
        speechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FirstListInfor.class);
                startActivity(intent);
            }
        });
    }
}
