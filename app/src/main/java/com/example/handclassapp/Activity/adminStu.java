package com.example.handclassapp.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.handclassapp.R;

public class adminStu extends AppCompatActivity {
    private Button queryB;
    private Button addB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_stu);
        queryB = findViewById(R.id.stuQuery);
        addB = findViewById(R.id.stuAdd);

        queryB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminStu.this, adminStuQuery.class);
                Toast.makeText(getApplicationContext(),"进入查询学生信息界面",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                adminStu.this.finish();

            }
        });

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminStu.this, adminStuAdd.class);
                Toast.makeText(getApplicationContext(),"进入添加学生信息界面",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                adminStu.this.finish();
            }
        });
    }
}
