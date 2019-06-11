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
    private Button adminButton;
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
        username = findViewById(R.id.editUsername);
        adminButton = findViewById(R.id.adminButton);
        pwd = findViewById(R.id.editPwd);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
              //  addStu();
               // db.delete("student", "SName =?", new String[] { "test" });
               // queryStuNONAME();
                Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          testLogin();
        }

public void normalLogin()
{
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
            }
            else
                Toast.makeText(getApplicationContext(), "账号或密码错误！", Toast.LENGTH_SHORT).show();
            return;

        }
        else if(TeaButton.isChecked()){
            String back_teapwd =querTeaPwd(input_id);
            if(input_pwd.equals(back_teapwd)) {
                Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
                intent.putExtra("TNo", input_id);
                Toast.makeText(getApplicationContext(), "教师已登录成功", Toast.LENGTH_SHORT).show();
                startActivity(intent);
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

public void testLogin()
{
    int input_id=1;
    if (StuButton.isChecked()) {
        Toast.makeText(getApplicationContext(), "学生已登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
        intent.putExtra("Sno", input_id);
        startActivity(intent);
    }
    else if(TeaButton.isChecked()){

            Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
            intent.putExtra("TNo", input_id);
            Toast.makeText(getApplicationContext(), "教师已登录成功", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

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
    public void queryStuNONAME() {
        String sno=null;
        String sname =null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from student where SNo>?", new String[]{"0"});
        if (cursor.moveToFirst()) {
            do {
                sno = cursor.getString(cursor.getColumnIndex("SNo"));
                sname= cursor.getString(cursor.getColumnIndex("SName"));
                Log.d("学号",sno);
                Log.d("学生姓名", sname);
            } while (cursor.moveToNext());
        }
        cursor.close();

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

        values.put("SName", "1");
        values.put("SProfess", "通信工程");
        values.put("SClass", "2");
        values.put("BirthDate", "1997-7-7");
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

        values.put("TName", "林老师");
        values.put("TProfess", "通信工程");
        values.put("TClass", "123");
        values.put("BirthDate", "1966-1-2");
        values.put("TSex", "1");
        values.put("Photo", "010111");
        values.put("Pwd", "1");
        long id= db.insert("teacher", null, values);
        values.clear();
        db.close();
        return id;
    }
    private long addAttend( ){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("SNo", "8");
        values.put("AttendDate", "2019-6-1");
        values.put("Week", "5");
        values.put("ClassId", "8");
        values.put("AttendStatus", "-1");
        values.put("ClassName", "计算机英语");
        long id= db.insert("stu_attend", null, values);
        values.clear();
        db.close();
        return id;
    }
}
