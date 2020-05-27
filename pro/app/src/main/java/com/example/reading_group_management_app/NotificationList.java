package com.example.reading_group_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Vector;

public class NotificationList extends AppCompatActivity {

    static final int REQ_ADD_CONTACT = 1;

    //임시, 회차
    ArrayList<String> listMenu = new ArrayList<String>();

    //공지사항 (제목, 내용, 회차 담긴) 클래스의 어레이 리스트
    ArrayList<NotedataStructure> groupNotice = new ArrayList<NotedataStructure>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //임시, 임의로 회차 기입, 추후 데이터베이스에서 참조할 것
        listMenu.add("main");
        listMenu.add("round 1");
        listMenu.add("round 2");
        listMenu.add("round 3");
        listMenu.add("round 4");

        setContentView(R.layout.activity_notification_list);

        //공지사항 어레이 리스트에서 특정 값 추출하여 어레이어댑터에 적합한 형식에 입력
        Vector<String> buf = new Vector<String>();
        int size = groupNotice.size();
        for(int i = 0; i < size; i++) {
            buf.add(groupNotice.get(i).getTitle());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,buf);
        ListView listView = (ListView)findViewById(R.id.ListView_notes);
        listView.setAdapter(adapter);

        //리스트 온클릭 상호작용, --> notification activity에 공지사항 클래스 내용 전송
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Notification.class);
                intent.putExtra("title", groupNotice.get(position).getTitle());
                intent.putExtra("list",groupNotice.get(position).getRound());
                intent.putExtra("con", groupNotice.get(position).getContents());
                startActivity(intent);
            }
        });

        //new버튼 온클릭 상호작용, noteReg에서 공지사항 클래스 내용 받아 저장 (~onactivityresult)
        Button button = findViewById(R.id.button_note_list_new);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NotificationReg.class);
                String[] rounds = listMenu.toArray(new String[0]);
                intent.putExtra("rounds",rounds);
                startActivityForResult(intent,REQ_ADD_CONTACT);
            }
        });

    }

    @Override   //notificationReg에서 기입한 값 불러와 저장, 액티비티 환기
    protected void onActivityResult(int requestCode, int resultCode, Intent intentB){
        super.onActivityResult(requestCode,resultCode,intentB);

        if(requestCode== REQ_ADD_CONTACT){
            if(resultCode == RESULT_OK){

                NotedataStructure note = new NotedataStructure();

                final String title= intentB.getExtras().getString("title");
                final String list = intentB.getExtras().getString("list");
                final String con = intentB.getExtras().getString("con");
                note.getNote(title, list, con);
                groupNotice.add(note);

                //이하 oncreate와 같은 내용
                setContentView(R.layout.activity_notification_list);

                Vector<String> buf = new Vector<String>();
                int size = groupNotice.size();
                for(int i = 0; i < size; i++) {
                    buf.add(groupNotice.get(i).getTitle());
                }

                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,buf);
                ListView listView = (ListView)findViewById(R.id.ListView_notes);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(),Notification.class);
                        intent.putExtra("title", groupNotice.get(position).getTitle());
                        intent.putExtra("list",groupNotice.get(position).getRound());
                        intent.putExtra("con", groupNotice.get(position).getContents());
                        startActivity(intent);
                    }
                });

                Button button = findViewById(R.id.button_note_list_new);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), NotificationReg.class);
                        String[] rounds = listMenu.toArray(new String[0]);
                        intent.putExtra("rounds",rounds);
                        startActivityForResult(intent,REQ_ADD_CONTACT);
                    }
                });
            }
        }

    }



}

//임시. 제목, 회자, 내용 저장하는 클래스. 데이터베이스 대용
class NotedataStructure {
    private String title;
    private String round;
    private String contents;

    public void putTitle(String tit) {
        title = tit;
    }

    public void putRound(String rnd) {
        round = rnd;
    }

    public void putContents(String con) {
        contents = con;
    }

    public void getNote(String tit, String rnd, String con) {
        title = tit;
        round = rnd;
        contents = con;
    }

    public String getTitle() {
        return title;
    }

    public String getRound() {
        return round;
    }

    public String getContents() {
        return contents;
    }
}