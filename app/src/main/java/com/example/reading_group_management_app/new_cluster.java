package com.example.reading_group_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;





import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Map;

public class new_cluster extends AppCompatActivity {
    DatabaseReference mDBReference = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cluster);

        TextView tx1 = (TextView)findViewById(R.id.textView5);
        Intent get = getIntent();
        String name = get.getExtras().getString("name");
        tx1.setText(name);

        Button button = findViewById(R.id.create_cluster);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
                Intent intent = new Intent(getApplicationContext(),member_group_home.class);
                finish();
            }
        });


    }

    public void insert(){
        mDBReference = FirebaseDatabase.getInstance().getReference();

        Member m = new Member("kim",0,24,"user6","zzzz");

        HashMap<String, Object> childUpdates = null;
        Map<String, Object> userValue = m.toMap();


        mDBReference.child("tbl_group").child(m.getId()).setValue(userValue);





    }

}
