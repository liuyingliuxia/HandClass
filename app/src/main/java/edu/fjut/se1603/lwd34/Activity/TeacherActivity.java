package edu.fjut.se1603.lwd34.Activity;

import android.net.Uri;
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
import edu.fjut.se1603.lwd34.Fragment.teaAssessFragment;
import edu.fjut.se1603.lwd34.Fragment.teaAttendFragment;
import edu.fjut.se1603.lwd34.Fragment.teaHomeworkFragment;
import edu.fjut.se1603.lwd34.Fragment.teaInforFragment;

public class TeacherActivity extends AppCompatActivity implements teaInforFragment.OnFragmentInteractionListener
{


    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
    Button meBT ;
    Button attendBT;
    Button assessBT;
    Button homeworkBT;
    String tea_id=null;
    String teaName=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Intent intent =getIntent();
//        tea_id=intent.getStringExtra("Tno");
//        Log.d("传进的职工号：",tea_id);
        meBT= findViewById(R.id.meT);
        attendBT= findViewById(R.id.attendT);
        assessBT =findViewById(R.id.assessT);
        homeworkBT =findViewById(R.id.homeworkT);

        meBT.setOnClickListener(l);
        attendBT.setOnClickListener(l);
        assessBT.setOnClickListener(l);
        homeworkBT.setOnClickListener(l);
    }


    final View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment f = null;
            switch (v.getId()) {
                case R.id.meT:
                    f = new teaInforFragment();
                    break;
                case R.id.attendT:
                    Intent intent = new Intent(TeacherActivity.this, stu_attendActivity.class);
                    startActivity(intent);
                    break;
                case R.id.assessT:
                   intent = new Intent(TeacherActivity.this, stu_assessActivity.class);
                    startActivity(intent);
                    break;
                case R.id.homeworkT:
                    intent = new Intent(TeacherActivity.this, homeworkActivity.class);
                    startActivity(intent);
                    break;

                default:
                    break;
            }
            ft.replace(R.id.teaFragment, f);
            ft.commit();
        }

    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}