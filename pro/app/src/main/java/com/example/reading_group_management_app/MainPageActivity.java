package com.example.reading_group_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        editSearch = (EditText) findViewById(R.id.edit_search);
        listView = (ListView) findViewById(R.id.list_view);

        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 검색에 사용할 데이터을 미리 저장한다.
        listTitle = new ArrayList<String>();
        settingGroupList();


        arraylistTitle = new ArrayList<String>();
        arraylistTitle.addAll(listTitle);

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
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
                Toast.makeText(this, "내 그 보기로 이동", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout_menu:
                Toast.makeText(this, "로그아웃 실행", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylistTitle.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // Group list
    List<GroupList> mGroupList = new ArrayList<GroupList>();
    private List<String> listTitle;
    private ArrayList<String> arraylistTitle;


    // book list class
    public class GroupList {
        public String groupTitle;
        public String[] groupTag;
    }

    // setting book list
    private void settingGroupList() {
        GroupList group = new GroupList();
        group.groupTag = new String[4];

        group.groupTitle = "자기계발을 사랑하는 모임";
        group.groupTag[0] = "#자기계발";
        group.groupTag[1] = "\0";


        mGroupList.add(group);

        group = new GroupList();
        group.groupTag = new String[4];

        group.groupTitle = "철학모임";
        group.groupTag[0] = "#철학";
        group.groupTag[1] = "#전공심화";
        group.groupTag[2] = "\0";
        mGroupList.add(group);

        group = new GroupList();
        group.groupTag = new String[4];

        group.groupTitle = "IT를 알자!";
        group.groupTag[0] = "#IT";
        group.groupTag[1] = "#컴퓨터공학";
        group.groupTag[2] = "#기술";
        group.groupTag[3] = "\0";
        mGroupList.add(group);

        group = new GroupList();
        group.groupTag = new String[4];

        group.groupTitle = "자기계발서 읽기";
        group.groupTag[0] = "#자기계발";
        group.groupTag[1] = "#자소서";
        group.groupTag[2] = "\0";
        mGroupList.add(group);

        settingSearchList();
    }

    // setting search list
    private void settingSearchList() {
        for (int i = 0; i < mGroupList.size(); i++) {
            list.add(mGroupList.get(i).groupTitle + "\n"+groupTag(mGroupList.get(i).groupTag) );
            listTitle.add(mGroupList.get(i).groupTitle);
        }
    }

    private String groupTag(String[] groupTag){
        String allTag = "";
        int i = 0;
        while(groupTag[i] != "\0" && i <= 3){
            allTag = allTag.concat(groupTag[i++]);
            allTag = allTag.concat(" ");

        }
        return allTag;
    }
}