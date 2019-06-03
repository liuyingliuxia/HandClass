package edu.fjut.se1603.lwd34.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myhandclass.R;

public class TeacherActivity extends AppCompatActivity {
    Intent intent=getIntent();
    String teaNo=intent.getStringExtra("teaNo");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
    }
}
