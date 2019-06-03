package edu.fjut.se1603.lwd34.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myhandclass.R;

import edu.fjut.se1603.lwd34.Entity.MyDatabaseHelper;

public class StudentActivity extends AppCompatActivity {


    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
    private TextView nameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Intent intent =getIntent();
        String stu_id=intent.getStringExtra("Sno");
        Log.d("传进的学号：",stu_id);
        nameText=findViewById(R.id.stuNameText);
        nameText.setText("学生姓名："+queryNameById(stu_id));
    }



    public String queryNameById(String sid)
    {
        String stuName=null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select SName from student where SNo=?", new String[]{sid});
        if (cursor.moveToFirst()) {
            do {
                // 遍历Cursor对象，取出数据并打印
                stuName = cursor.getString(cursor.getColumnIndex("SName"));
                Log.d("学生姓名", stuName);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return stuName;
    }
}