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
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.myhandclass.R;

import edu.fjut.se1603.lwd34.Entity.MyDatabaseHelper;
import edu.fjut.se1603.lwd34.Fragment.homeworkFragment;
import edu.fjut.se1603.lwd34.Fragment.myClassFragment;
import edu.fjut.se1603.lwd34.Fragment.stuAssessFragment;
import edu.fjut.se1603.lwd34.Fragment.stuAttendFragment;
import edu.fjut.se1603.lwd34.Fragment.stuInforFragment;

public class StudentActivity extends AppCompatActivity {


    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
    Button meBT ;
    Button attendBT;
    Button assessBT;
    Button myclassBT;
    Button homeworkBT;
    String stu_id=null;
    String stuName=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Intent intent =getIntent();
        stu_id=intent.getStringExtra("Sno");
        Log.d("传进的学号：",stu_id);
        meBT= findViewById(R.id.me);
        attendBT= findViewById(R.id.attend);
        assessBT =findViewById(R.id.score_calculate);
        myclassBT =findViewById(R.id.myclass);
        homeworkBT =findViewById(R.id.homework);

        meBT.setOnClickListener(l);
        attendBT.setOnClickListener(l);
        assessBT.setOnClickListener(l);
        myclassBT.setOnClickListener(l);
        homeworkBT.setOnClickListener(l);
//        getStu_id();
//        getStu_name();
    }


    final View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment f = null;
            switch (v.getId()) {
                case R.id.me:
                    f = new stuInforFragment();
                    break;
                case R.id.attend:
                   f = new stuAttendFragment();
                    break;
                case R.id.myclass:
                    f = new myClassFragment();
                    break;
                case R.id.score_calculate:
                    f = new stuAssessFragment();
                    break;
                case R.id.homework:
                    f = new homeworkFragment();
                    break;

                default:
                    break;
            }
            ft.replace(R.id.stuFragment, f);
            ft.commit();
        }

    };

    public String queryNameById(String sid)
    {

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

    public String getStu_id(){
        Log.d("传到fragment的学生id:",stu_id);
        return stu_id;
    }
    public String getStu_name(){
        Log.d("传到fragment的学生姓名:",stuName);
        return stuName;
    }
}