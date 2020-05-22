package com.example.reading_group_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Presentation1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation1);

        final EditText commentEditTextView=(EditText)findViewById(R.id.comment_edit_text_view);
        Button commentCompleteBtn=(Button)findViewById(R.id.comment_complete_btn);
        final TextView commentTextView=(TextView)findViewById(R.id.comment_text_view);
        commentCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentTextView.setText(commentEditTextView.getText());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile_menu:
                Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.newgroup_menu:
                Intent intent1 = new Intent(getApplicationContext(),new_group.class);
                startActivity(intent1);


            case R.id.mygroup_menu:
                Toast.makeText(this, "내 그룹 보기로 이동", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout_menu:
                Toast.makeText(this, "로그아웃 실행", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
