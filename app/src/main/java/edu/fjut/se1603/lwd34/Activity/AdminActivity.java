package edu.fjut.se1603.lwd34.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.fjut.se1603.lwd34.DAO.MyDatabaseHelper;
import edu.fjut.se1603.lwd34.DAO.MyDbHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myhandclass.R;


public class AdminActivity extends AppCompatActivity {
    public Button stuB;
    public Button teaB;
    public Button cDB;
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "MyHandClass.db", null, 1);
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        stuB = findViewById(R.id.StuAdminButton);
        teaB = findViewById(R.id.TeaAdminButton);
        cDB = findViewById(R.id.createDB);
        cDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

     /*  stuB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent intent = new Intent(AdminActivity.this, adminStuActivity.class);
                    Toast.makeText(getApplicationContext(),"进入学生管理界面",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    AdminActivity.this.finish();

                }
            });
        teaB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminActivity.this, adminTea.class);
                    Toast.makeText(getApplicationContext(),"进入教师管理界面",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    AdminActivity.this.finish();
                }
            });*/
        }


}
