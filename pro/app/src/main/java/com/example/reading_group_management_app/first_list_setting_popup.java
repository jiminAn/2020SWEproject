package com.example.reading_group_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class first_list_setting_popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_list_setting_popup);
        Button button1 = findViewById(R.id.vote_date);
        Button button2 = findViewById(R.id.vote_location);
        Button button3 = findViewById(R.id.vote_book);
        Button button4 = findViewById(R.id.vote_presentation);
        Button button5 = findViewById(R.id.cancel_firs_list_seting_popup);
        Button button6 = findViewById(R.id.commit_first_list_seting_popup);


        //날짜 투표
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),calendar_popup.class);
                finish();
                startActivity(intent);
            }
        });
        //위치 투표
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),place_popup.class);
                finish();
                startActivity(intent);
            }
        });
        //책 투표
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),book_popup.class);
                finish();
                startActivity(intent);
            }
        });
        //발제하기
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),presentation_popup.class);
                finish();
                startActivity(intent);
            }
        });
        //취소하기
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }
}
