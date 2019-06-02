package com.example.handclassapp.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.handclassapp.DAO.MyDb;
import com.example.handclassapp.R;

public class AddStuInforActivity extends AppCompatActivity {
    private MyDb dbHelper;
    private ImageButton photo;
    private Button save;

    private EditText name;
    private EditText stuNo;
    private Spinner sex;
    private EditText age;
    private Spinner college;
    private Spinner classStu;

    private int TAKE_PHOTO=1;   //拍照
    private int GET_PHOTO=2;    //取照片


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stu_infor);

        photo = findViewById(R.id.imageButton);
        save = findViewById(R.id.addInfbutton);
        name=findViewById(R.id.editName);
        sex=findViewById(R.id.sexSpinner);
        stuNo=findViewById(R.id.editNo);
        age=findViewById(R.id.editAge);
        college=findViewById(R.id.collegeSpinner);
        classStu=findViewById(R.id.ClassSpinner);
        dbHelper = new MyDb(this, "HandClass.db", null, 1);
        dbHelper.getWritableDatabase();

         photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();

            }

    });
         save.setOnClickListener(new View.OnClickListener(){
             public void onClick(View v){
                 saveInfor();

             }

         });

    }
    private  void saveInfor(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ContentValues infor = new ContentValues();
if(name.getText().toString().isEmpty()||age.getText().toString().isEmpty()||stuNo.getText().toString().isEmpty())
    Toast.makeText(getApplicationContext(),"请输入完整数据",Toast.LENGTH_SHORT).show();
else {
    infor.put("StuName", name.getText().toString());
    infor.put("StuSex", (String) sex.getSelectedItem());
    infor.put("StuAge", age.getText().toString());
    infor.put("StuNo", stuNo.getText().toString());
    infor.put("College", (String) college.getSelectedItem());
    infor.put("ProfessionClass", (String) classStu.getSelectedItem());
    db.insert("Student", null, infor);
    Toast.makeText(getApplicationContext(), "学生信息录入成功", Toast.LENGTH_SHORT).show();
}
    }
    private  void choosePhoto(){
        Intent intentPick = new Intent(Intent.ACTION_PICK,null);
        intentPick.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        startActivityForResult(intentPick, TAKE_PHOTO);
    }
/*
   //接受回传值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {  //回传值接受成功

            if (requestCode == TAKE_PHOTO) {    //拍照取图

                Bundle bundle = data.getExtras();   //获取data数据集合
                Bitmap bitmap = (Bitmap) bundle.get("data");   //获得data数据
                Log.i("TAG", "拍照回传bitmap："+bitmap);
                photo.setImageBitmap(bitmap);

            }

            if (requestCode == GET_PHOTO) {     //相册取图

                ContentResolver contentResolver = getContentResolver();
                try {

                    Bitmap bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(data.getData()));
                    Log.i("TAG", "从相册回传bitmap："+bitmap);
                    photo.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

        }*/

    }


