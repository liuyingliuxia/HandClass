package edu.fjut.se1603.lwd34.Activity;
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

//直接选择身份实现不同activity之间的跳转

public class LoginActivity extends AppCompatActivity {
    private RadioButton StuButton;
    private RadioButton TeaButton;
    private RadioButton AdminButton;
    private Button loginButton;
    private EditText username;
    private EditText pwd;
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
               findAccount();
            }
        });
    }

    public void Login1(){
       String input_User= username.getText().toString();
       String input_Pwd = pwd.getText().toString();


    }
    public void logining() {
        if(StuButton.isChecked()) {
            Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
            //传递数据 账号 intent.putExtra()
            Toast.makeText(getApplicationContext(),"学生已登录成功",Toast.LENGTH_SHORT).show();
            startActivity(intent);
            LoginActivity.this.finish();
        }
        else if(TeaButton.isChecked()){
            Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
            //传递数据 账号 intent.putExtra()
            Toast.makeText(getApplicationContext(),"教师已登录成功",Toast.LENGTH_SHORT).show();
            startActivity(intent);
            LoginActivity.this.finish();
        }
        else if(AdminButton.isChecked()){
            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
            Toast.makeText(getApplicationContext(),"管理员已登录成功",Toast.LENGTH_SHORT).show();
            //传递数据 账号 intent.putExtra()
            startActivity(intent);
            LoginActivity.this.finish();
        }
    }
//DAO:
    public List<Student> findAccount(){

        MyDatabaseHelper myDBHelper= new MyDatabaseHelper(getBaseContext());
        List<Student> stuList = new ArrayList<Student>();
        Student stu = new Student();
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        Cursor cursor = db.query("student", null, null, null, null, null, null);
            while(cursor.moveToNext()) {
                int username = cursor.getInt(cursor.getColumnIndex(("SNO")));
                String pwd = cursor.getString(cursor.getColumnIndex("Pwd"));
                stu.setPwd(pwd);
                Log.d("学生登录账号：", String.valueOf(username));
                Log.d("学生登录密码：", pwd);
                stuList.add(stu);
            }
            cursor.close();
        db.close();
        return stuList;
    }

}
