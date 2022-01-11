package com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.adapter.CustomAdapter;
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private RecyclerView recyclerView;
        Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewa();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }
    private void initViewa() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter =  new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        members.add(new Member());//for header

        for(int i = 0; i<30; i++){
            if(i == 0|| i == 5|| i == 16 || i == 25){
                members.add(new Member("Sarvarbek"+i,"Khalmatov"+i,false));
            }else {
                members.add(new Member("Sarvarbek"+i,"Khalmatov"+i,true));
            }
            }
        members.add(new Member());//for footer
    return members;
    }
    }

