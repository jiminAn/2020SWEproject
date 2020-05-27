package com.example.reading_group_management_app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class non_member_group_home extends AppCompatActivity {

    Button button_joingroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_member_group_home);

        button_joingroup=(Button)findViewById(R.id.button_joingroup);
        button_joingroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(non_member_group_home.this);
                ad.setTitle("가입 신청");
                ad.setMessage("해당 그룹에 가입을 신청하시겠습니까?\n(그룹장 승인이 있으신 후에 멤버 정식 등록이 가능합니다.)");
                ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                ad.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                ad.show();
            }
        });

    }
}
