package edu.fjut.se1603.lwd34.Activity;
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
import android.widget.Toast;

import com.example.myhandclass.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.fjut.se1603.lwd34.Entity.MyDatabaseHelper;
import edu.fjut.se1603.lwd34.Entity.Student;

public class LoginActivity extends AppCompatActivity {
    private RadioButton StuButton;
    private RadioButton TeaButton;
    private RadioButton AdminButton;
    private Button loginButton;
    private EditText username;
    private EditText pwd;
    Bundle bundle = new Bundle();
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.loginButton);
        StuButton = findViewById(R.id.radioStu);
        TeaButton = findViewById(R.id.radioTea);
        AdminButton = findViewById(R.id.radioAdmin);
        username = findViewById(R.id.editUsername);
        pwd = findViewById(R.id.editPwd);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStu();
                String input_id=username.getText().toString();//输入的账号
                String input_pwd=pwd.getText().toString();//输入的密码
                if(input_id.isEmpty()||input_pwd.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "账号或密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if (StuButton.isChecked()) {
                        String back_stupwd =queryStuPwd(input_id);
                      if(input_pwd.equals(back_stupwd)) {
                           Toast.makeText(getApplicationContext(), "学生已登录成功", Toast.LENGTH_SHORT).show();

                          Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
                         intent.putExtra("Sno",input_id);
                          startActivity(intent);
                          LoginActivity.this.finish();
                      }
                      else
                          Toast.makeText(getApplicationContext(), "账号或密码错误！", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else if(TeaButton.isChecked()){
                        String back_teapwd =querTeaPwd(input_id);
                        if(input_pwd.equals(back_teapwd)) {
                            Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
                            intent.putExtra("teaNo", input_id);
                            Toast.makeText(getApplicationContext(), "教师已登录成功", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            LoginActivity.this.finish();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "账号或密码错误！", Toast.LENGTH_SHORT).show();
                             return;
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "请选择登录身份", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        });
    }



//DAO:

    public String queryStuPwd(String Sno) {
        String pwd=null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select Pwd from student where SNo=?", new String[]{Sno});
        if (cursor.moveToFirst()) {
            do {
                pwd = cursor.getString(cursor.getColumnIndex("Pwd"));
                Log.d("学生密码", pwd);
              } while (cursor.moveToNext());
        }
        cursor.close();

        return pwd;
    }

    public String querTeaPwd(String Tno) {
        String pwd=null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select Pwd from teacher where TNo=?", new String[]{Tno});
        if (cursor.moveToFirst()) {
            do {
                // 遍历Cursor对象，取出数据并打印
                pwd = cursor.getString(cursor.getColumnIndex("Pwd"));
                Log.d("教师密码", pwd);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return pwd;
    }
    private long addStu( ){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("SName", "test");
        values.put("SProfess", "通信工程");
        values.put("SClass", "2");
        values.put("BirthDate", "1997-6-2");
        values.put("SSex", "1");
        values.put("Photo", "0101");
        values.put("Pwd", "0");
        long id= db.insert("student", null, values);
        values.clear();
        db.close();
        return id;
    }
    private long addTea( ){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("TName", "王教授");
        values.put("TProfess", "软件工程");
        values.put("TClass", "123");
        values.put("BirthDate", "1966-1-2");
        values.put("TSex", "1");
        values.put("Photo", "010111");
        values.put("Pwd", "wang");
        long id= db.insert("teacher", null, values);
        values.clear();
        db.close();
        return id;
    }
}
