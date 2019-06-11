package edu.fjut.se1603.lwd34.Entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class allDAO {
    private MyDatabaseHelper helper;
    public allDAO(Context context){
        helper= new MyDatabaseHelper(context);

    }

   public List<Student> queryStu(){
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor c =db.query("student",null,null,null,null,null,null);
        List<Student > list = new ArrayList<Student>();
        while(c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("SNo"));
            String name = c.getString(c.getColumnIndex("SName"));
            list.add(new Student(id, name));
        }
        c.close();
        db.close();
        return list;
    }

    public int deletestu(int sno){
        Log.d("删除数据中。。。",sno+"");
        SQLiteDatabase db = helper.getWritableDatabase();
        int count= db.delete("student","SNo=?",new String[]{sno+""});
        db.close();
        return count;

    }
    public List<Attend> queryAttend(){
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor c =db.query("stu_attend",null,null,null,null,null,null);
        List<Attend > list = new ArrayList<Attend>();
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndex("SNo"));
                String date = c.getString(c.getColumnIndex("AttendDate"));
                int week = c.getInt(c.getColumnIndex("Week"));
                String classname = c.getString(c.getColumnIndex("ClassName"));
                int attendStatus = c.getInt(c.getColumnIndex("AttendStatus"));
                list.add(new Attend(id,date,week,classname,attendStatus));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return list;
    }

public void insertStu(Student s){
    SQLiteDatabase db = helper.getWritableDatabase();
    ContentValues values = new ContentValues();

    values.put("SName", s.getSname());
    values.put("Pwd", s.getPwd());
    long id= db.insert("student", null, values);

    db.close();

}

    public List<Assess> queryassess(){
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor c =db.query("stu_assess",null,null,null,null,null,null);
        List<Assess > list = new ArrayList<Assess>();
        if (c.moveToFirst()) {
            do {
                int sno = c.getInt(c.getColumnIndex("SNo"));
                String classname = c.getString(c.getColumnIndex("ClassName"));
                double ass_score =c.getDouble(c.getColumnIndex("AssessScore"));
                list.add(new Assess(sno,classname,ass_score));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return list;
    }
    public void insertAssess(Assess s){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("SNo", s.getSno());
        values.put("TNo", "12");
        values.put("ClassName", s.getClassname());
        values.put("AssessScore", s.getScore());
        long id= db.insert("stu_assess", null, values);

        db.close();

    }

    public void insertTea(Teacher s){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("TNo", s.getTno());
        values.put("Pwd", s.getPwd());

        long id= db.insert("teacher", null, values);

        db.close();

    }
    public void insertHome(Homework s){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("SNo", s.getSno());
        values.put("ClassName", s.getCname());
        values.put("HomeworkTitle",s.getTitle());
        values.put("SGrade", s.getGrade());
        long id= db.insert("homework_score", null, values);

        db.close();

    }
    public List<Teacher> queryTeacher(){
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor c =db.query("teacher",null,null,null,null,null,null);
        List<Teacher > list = new ArrayList<Teacher>();
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndex("TNo"));
               String tname = c.getString(c.getColumnIndex("TName"));
                list.add(new Teacher(id,tname));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return list;
    }

    public List<Homework> queryHome(){
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor c =db.query("homework_score",null,null,null,null,null,null);
        List<Homework > list = new ArrayList<Homework>();
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndex("SNo"));
                String cname = c.getString(c.getColumnIndex("ClassName"));
                String homeworkTitle = c.getString(c.getColumnIndex("HomeworkTitle"));
                double grade = c.getDouble(c.getColumnIndex("SGrade"));
                list.add(new Homework(id,cname,homeworkTitle,grade));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return list;
    }

    public int updateAttend (Attend at){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("AttendStatus",at.getStatus());
        int count =db.update("stu_attend",values,"AttendStatus=?",new String[]{at.getStatus()+""});
        db.close();
        return count;
    }
}
