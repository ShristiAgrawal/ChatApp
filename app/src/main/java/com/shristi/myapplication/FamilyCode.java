package com.shristi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FamilyCode extends AppCompatActivity {
    Button enter;
    EditText code;
    String fcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_code);
        enter=findViewById(R.id.enter);
        code=findViewById(R.id.f_code);
        fcode=code.getText().toString();
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FamilyCode.this,InitialActivity.class);
                intent.putExtra("familycode",fcode);
                startActivity(intent);
            }
        });
    }
}