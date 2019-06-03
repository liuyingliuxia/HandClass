package edu.fjut.se1603.lwd34.Activity;

import android.content.ContentValues;
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
    public Button cDB;
    Student xiaoming = new Student();
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "MyHandClass.db", null, 1);
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        stuB = findViewById(R.id.StuAdmin);
        teaB = findViewById(R.id.TeaAdmin);
        cDB = findViewById(R.id.createDB);
        cDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

       stuB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //add();

                }
            });
        teaB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        private long add( ){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            // 开始组装第一条数据
            values.put("SName", "小明");
            values.put("SProfess", "软件工程");
            values.put("SClass", 3);
            values.put("BirthDate", "1997-6-2");
            values.put("SSex", "1");
            values.put("Photo", "0101");
            values.put("Pwd", "xiaoming");
            long id= db.insert("student", null, values); // 插入第一条数据
            values.clear();
            db.close();
            return id;
        }

}
