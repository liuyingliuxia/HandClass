package com.example.handclassapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {/*
    private MyDb helper;
    public StudentDao(Context context){
        helper=new MyDb(context);
    }
    public void insert(Student stu)
    {
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("StuName",stu.getsName());
        values.put("StuNo",stu.getsNo());
        values.put("StuAge",stu.getsSex());
        values.put("ProfessionClass",stu.getsProfess());
        values.put("College",stu.getScollege());
        values.put("StuSex",stu.getsSex());
         long sNo = db.insert("Student",null,values);
        db.close();
    }

    public List<Student> queryAll(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = (Cursor) db.query("Student",null,null,null,null,null,"balance DESC");
        List<Student> list =new ArrayList<Student>();
        while(c.moveToNext()){
            int sNo = c.getInt(0);
            String name =c.getString(1);
            String college = c.getString(2);
            String pro = c.getString(3);
            int age= c.getInt(4);
            int sex = c.getInt(6);
            list.add(new Student(sNo,name,pro,sex,college,age));
        }
        c.close();
        db.close();
        return list;
    }*/
}
