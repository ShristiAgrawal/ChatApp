package com.shristi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shristi.myapplication.Chat.ChatActivity;
import com.shristi.myapplication.Locations.MapsActivity;
import com.shristi.myapplication.todo.TodoActivity;

public class InitialActivity extends AppCompatActivity {
    Button chat,expense,todo,contact,location;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        i=getIntent();

        chat=findViewById(R.id.chat_b);
        expense=findViewById(R.id.expense_b);
        todo=findViewById(R.id.todo_b);
        contact=findViewById(R.id.contacts_b);
        location=findViewById(R.id.location_b);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(InitialActivity.this,ChatActivity.class);
                intent.putExtra("familycode",i.getStringExtra("familycode"));
                startActivity(intent);
            }
        });


        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(InitialActivity.this, TodoActivity.class);
                intent.putExtra("familycode",i.getStringExtra("familycode"));
                startActivity(intent);
            }
        });


//        expense.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(InitialActivity.this,InitialActivity.class);
//                intent.putExtra("familycode",i.getStringExtra("familycode"));
//                startActivity(intent);
//            }
//        });
//
//        contact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(InitialActivity.this,InitialActivity.class);
//                intent.putExtra("familycode",i.getStringExtra("familycode"));
//                startActivity(intent);
//            }
//        });
//
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(InitialActivity.this, MapsActivity.class);
                intent.putExtra("familycode",i.getStringExtra("familycode"));
                startActivity(intent);
            }
        });
    }
}