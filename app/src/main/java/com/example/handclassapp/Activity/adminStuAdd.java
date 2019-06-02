package com.example.handclassapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.handclassapp.DAO.MyDb;
import com.example.handclassapp.R;

public class adminStuAdd extends AppCompatActivity {
    private MyDb dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_add);
        dbHelper = new MyDb(this, "HandClass.db", null, 2);
        /*Button addAcc =  findViewById(R.id.addStuAcc);
        addAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // 开始插入 用户密码表的教师登录账号
                values.put("ID", 9);//0表示身份是学生,1表示老师，9表示管理员
                values.put("UserName", "000000");
                values.put("Pwd", "000000");
                db.insert("Account", null, values);
               // Toast.makeText(null, "数据插入成功!", Toast.LENGTH_SHORT).show();

            }
        });*/

        Button addInf =  findViewById(R.id.addStuInf);
        addInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminStuAdd.this, AddStuInforActivity.class);
              Toast.makeText(getApplicationContext(),"进入添加学生基本信息界面",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                adminStuAdd.this.finish();
            }
        });
    }
}


/*
public class LoginActivity extends AppCompatActivity {

    private MyDb dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDb(this, "HandClass.db", null, 2);

        Button createDatabase = (Button) findViewById(R.id.login);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });


      //按一个按钮向表中插入数据
        Button insertB = (Button) findViewById(R.id.login);
        insertB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // 开始插入 用户密码表的教师登录账号
                values.put("ID", 9);//1表示教师
                values.put("UserName", "admin");
                values.put("Pwd", "123456");
                db.insert("Account", null, values);
                values.clear();
               // 开始插入 学生登录账号
                values.put("ID", 0);//0表示学生
                values.put("UserName", "31689");
                values.put("Pwd", "31689");
                db.insert("Account", null, values);
                values.put("ID", 1);//0表示学生
                values.put("UserName", "16529");
                values.put("Pwd", "16529");
                db.insert("Account", null, values);
            }
        });


    }*/