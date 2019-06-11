package edu.fjut.se1603.lwd34.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.fjut.se1603.lwd34.Entity.MyDatabaseHelper;
import edu.fjut.se1603.lwd34.Entity.Student;

import android.database.sqlite.SQLiteDatabase;

import com.example.myhandclass.R;


public class AdminActivity extends AppCompatActivity {
    public Button stuB;
    public Button teaB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        stuB = findViewById(R.id.stuB);
        teaB = findViewById(R.id.teaB);

        stuB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, adminStuActivity.class);
                startActivity(intent);
            }
        });
        teaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, admin_teaActivity.class);
                startActivity(intent);
            }
        });
    }
}

