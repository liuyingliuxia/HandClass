package edu.fjut.se1603.lwd34.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myhandclass.R;

//直接选择身份实现不同activity之间的跳转

public class LoginActivity extends AppCompatActivity {
    private RadioButton StuButton;
    private RadioButton TeaButton;
    private RadioButton AdminButton;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.loginButton);
        StuButton = findViewById(R.id.radioStu);
        TeaButton = findViewById(R.id.radioTea);
        AdminButton = findViewById(R.id.radioAdmin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logining();
            }
        });
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

}
