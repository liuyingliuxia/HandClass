package edu.fjut.se1603.lwd34.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myhandclass.R;

import edu.fjut.se1603.lwd34.Entity.MyDatabaseHelper;

public class StudentActivity extends AppCompatActivity {


    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
    Button stuInf ;
    Button stuXiuxi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Intent intent =getIntent();
        String stu_id=intent.getStringExtra("Sno");
        Log.d("传进的学号：",stu_id);
        stuInf= findViewById(R.id.inforAdmin);
        stuXiuxi= findViewById(R.id.xiuxiQuery);
        stuInf.setOnClickListener(l);
        stuXiuxi.setOnClickListener(l);
    }


    final View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment f = null;
            switch (v.getId()) {
                case R.id.inforAdmin:
                    f = new stuInforFragment();
                    break;
                case R.id.xiuxiQuery:
                    f = new stuXiuxiFragment();
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment, f);
            ft.commit();
        }

    };

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