package com.shristi.myapplication.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shristi.myapplication.Chat.ChatListAdapter;
import com.shristi.myapplication.R;

public class TodoActivity extends AppCompatActivity {
    private ListView tasks_listview;
    private DatabaseReference mDatabaseReference;
    private TodoAdapter mAdapter;

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo2);

        tasks_listview = (ListView) findViewById(R.id.tasks_lv);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        b=findViewById(R.id.addnewtask);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    todomodel todo = new todomodel("User","Task","DD/MM");

                    mDatabaseReference.child("new").child("todo").push().setValue(todo);
            }
        });


    }
    @Override
    public void onStart(){
        super.onStart();
        mAdapter = new TodoAdapter(this,FirebaseDatabase.getInstance().getReference(),"User1","Task1","DD/MM","new");
        tasks_listview.setAdapter(mAdapter);
    }
//
//    @Override
//    public void onStop(){
//        super.onStop();
//        mAdapter.cl;
//    }

}