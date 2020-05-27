package com.example.reading_group_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class FirstListInfor extends AppCompatActivity {

    //임시, 추후 데이터베이스 참조
    String[] speechs = {"발제문 1","발제문 2","발제문 3", "발제문 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_list_infor);


        final TextView meetingRound = (TextView) findViewById(R.id.textView_meeting_round);
        final TextView voteResult = (TextView) findViewById(R.id.textView_metting_vote_result);

        Button buttonSet = findViewById(R.id.button_meeting_set);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, speechs);
        ListView listView = (ListView) findViewById(R.id.listview_meeting_speech_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }

}
