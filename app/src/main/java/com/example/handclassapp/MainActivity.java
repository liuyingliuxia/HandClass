package com.example.handclassapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyDb dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Account acc = new Account();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper= new MyDb(this);
        Button button =(Button)findViewById(R.id.login);
        final EditText editText=(EditText)findViewById(R.id.editText);
        final EditText editText1 = (EditText)findViewById(R.id.editText2);
        RadioButton radioStu =(RadioButton)findViewById(R.id.radioStu);
        RadioButton radioTea=(RadioButton)findViewById(R.id.radioTea);
        button.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View v){
                List<Account> acc = DataSupport.findAll(Account.class);
                for(Account account:acc) {
                    if (editText.equals(account.getUserName()) && editText1.equals(account.getPwd())) {
                        Toast.makeText(getApplicationContext(), "登录成功！", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "账号或密码错误！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

            }



        });

    }
/*
public class MainActivity extends AppCompatActivity {

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

*/
    }

