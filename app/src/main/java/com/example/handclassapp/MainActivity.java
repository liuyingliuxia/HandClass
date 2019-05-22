package com.example.handclassapp;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyDb dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper= new MyDb(this,"HandClass.db",null,2);
        Button button =(Button)findViewById(R.id.login);
        final EditText editText=(EditText)findViewById(R.id.editText);
        final EditText editText1 = (EditText)findViewById(R.id.editText2);
        final RadioButton radioStu =(RadioButton)findViewById(R.id.radioStu);
        RadioButton radioTea=(RadioButton)findViewById(R.id.radioTea);
        button.setOnClickListener(new View.OnClickListener(){

            public void  onClick(View v){
                //使用游标查询账户信息，用于登录验证
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                Cursor cursor=db.query("Account",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        int id=cursor.getInt(cursor.getColumnIndex("ID"));
                        String username=cursor.getString(cursor.getColumnIndex("UserName"));
                        String pwd=cursor.getString(cursor.getColumnIndex("Pwd"));
                      //判断输入信息是否正确
                        String inputUser=editText.getText().toString();
                        String inputPwd =editText1.getText().toString();
                       if(username.equals(inputUser)&&pwd.equals(inputPwd)) {
                           Toast.makeText(getApplicationContext(), "登录成功！", Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                           startActivity(intent);
                           return;
                       }
                       else
                           Toast.makeText(getApplicationContext(),"账号或密码错误！",Toast.LENGTH_SHORT).show();


                    }while (cursor.moveToNext());
                       }
                cursor.close();
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

