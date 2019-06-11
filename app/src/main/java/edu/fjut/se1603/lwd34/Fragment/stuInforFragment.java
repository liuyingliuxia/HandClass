package edu.fjut.se1603.lwd34.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myhandclass.R;

import edu.fjut.se1603.lwd34.Activity.LoginActivity;
import edu.fjut.se1603.lwd34.Activity.StudentActivity;
import edu.fjut.se1603.lwd34.Entity.MyDatabaseHelper;

public class stuInforFragment extends Fragment {
    private EditText stuSname;
    private EditText stuSno;
    private EditText stuSex;
    private EditText stuDate;
    private EditText stuProfess;
    private EditText stuClass;
    private String[] textString={"小明","34","男","1998-07-09","水产养殖","6"};
    private String sSex=null;
    private String sDate=null;
    private String sProfess=null;
    private String sClass=null;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stu_infor, null);

        stuSname =view.findViewById(R.id.et_stu_name);
        stuSno = view.findViewById(R.id.et_stu_no);
        stuDate =view.findViewById(R.id.et_stu_date);
        stuProfess = view.findViewById(R.id.et_stu_profess);
        stuSex =view.findViewById(R.id.et_stu_sex);
        stuClass = view.findViewById(R.id.et_stu_class);
//        StudentActivity stuActivity = (StudentActivity) getActivity();
//        String stuid = stuActivity.getStu_id();
//        String stuname = stuActivity.getStu_name();
//        Log.d("传入Fragment的id",stuid);
//        Log.d("传入的学生姓名",stuname);

        stuSname.setText(textString[0]);
        stuSno.setText(textString[1]);
       // querStuById(stuid);
        stuSex.setText(textString[2]);
        stuDate.setText(textString[3]);
        stuProfess.setText(textString[4]);
        stuClass.setText(textString[5]);
        return view;
    }
/*
    public void querStuById(String sno) {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(view.getContext()); SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from student where SNo=?", new String[]{stuid});
        if (cursor.moveToFirst()) {
            do {
                // 遍历Cursor对象，取出数据并打印
                sProfess  = cursor.getString(cursor.getColumnIndex("SProfess"));
                sClass  = cursor.getString(cursor.getColumnIndex("SClass"));
                sDate  = cursor.getString(cursor.getColumnIndex("BirthDate"));
                sSex  = cursor.getString(cursor.getColumnIndex("SSex"));
            } while (cursor.moveToNext());
        }
        cursor.close();

    }*/
    public String sexBy(){
        if(sSex.equals("1"))
            return "男";
        else
            return "女";

    }

}
