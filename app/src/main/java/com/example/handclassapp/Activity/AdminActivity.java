package com.example.handclassapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.handclassapp.R;

public class AdminActivity extends AppCompatActivity {
    public Button stuB;
    public Button teaB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        stuB = findViewById(R.id.StuAdminButton);
        teaB = findViewById(R.id.TeaAdminButton);

            stuB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent intent = new Intent(AdminActivity.this, adminStu.class);
                    Toast.makeText(getApplicationContext(),"进入学生管理界面",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    AdminActivity.this.finish();

                }
            });

            teaB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminActivity.this, adminTea.class);
                    Toast.makeText(getApplicationContext(),"进入教师管理界面",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    AdminActivity.this.finish();
                }
            });
        }
}
