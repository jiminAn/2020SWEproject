package com.example.reading_group_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NotificationReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_reg);

        final Intent intent = getIntent();

        //noteList에서 전송된 회차 정보, spinner에서 사용
        final String[] rounds= intent.getExtras().getStringArray("rounds");


        final EditText notetitle = (EditText)findViewById(R.id.edittext_note_reg_title);
        final EditText notecon = (EditText)findViewById(R.id.edittext_note_reg_contents);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner_note_reg_rounds);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, rounds);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        Button comp = findViewById(R.id.button_notie_reg_comp);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //       parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // DB에  저장, comp
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentB = new Intent();
                intentB.putExtra("title", notetitle.getText().toString());
                intentB.putExtra("list",spinner.getSelectedItem().toString());
                intentB.putExtra("con", notecon.getText().toString());
                setResult(RESULT_OK, intentB);
                finish();
            }
        });


    }
}
