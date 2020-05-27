package com.example.reading_group_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        final Intent intent = getIntent();
        final String title= intent.getExtras().getString("title");
        final String round = intent.getExtras().getString("list");
        final String contents = intent.getExtras().getString("con");

        final TextView noteTitle = (TextView)findViewById(R.id.textView_note_title);
        final TextView noteRound = (TextView)findViewById(R.id.textView_note_round);
        final TextView noteContents = (TextView)findViewById(R.id.textView_note_contents);
        Button button = findViewById(R.id.button_note_comp);

        noteTitle.setText(title);
        noteRound.setText(round);
        noteContents.setText(contents);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }
}
