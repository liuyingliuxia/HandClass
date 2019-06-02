package com.example.handclassapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
//创建数据库表结构专用类
public class MyDbHelper extends SQLiteOpenHelper {
          //建表
    public static final String CREATE_Account= "create table Account ("
            + "ID integer  ,"
            + "UserName INT PRIMARY KEY,"
            + "Pwd text)";

    public static final String CREATE_Schedule ="create TABLE Schedule ("
            + "ProfessionClass TEXT,"
            +" Week       INT,"
            +"ClassId         INT,"
            +"ClassName       STRING,"
            +"TeaNo           STRING REFERENCES Teacher (TeaNo),"
            +"ClassLocation   STRING)";

    public static final String CREATE_Student="CREATE TABLE Student ("
           + "StuNo           INT PRIMARY KEY,"
           +" StuName         STRING,"
           +" College         STRING,"
           +" ProfessionClass STRING,"
           +" StuAge          INTEGER,"
            +"Photo            TEXT,"
            +"StuSex          INTEGER)";
    public static final String CREATE_Assessment="CREATE TABLE Assessment ("
           +"StuNo STRING REFERENCES Student (StuNo) ,"
          +"TeaNo STRING REFERENCES Teacher (TeaNo) ,"
        +"ClassName   STRING,"
        +"AssessDate  DATE,"
        +"AssessScore DOUBLE)";
    public static final String CREATE_Attendance="CREATE TABLE Attendance ("
           +"StuNo        INT REFERENCES Student (StuNo),"
            + "ClassDate    DATE,"
         + "Week         INT,"
         +" ClassId      INT,"
   +" AttendStatus INT,"
   +" ClassName    STRING)";

    public static final String CREATE_TaskPerformance= "CREATE TABLE TaskPerformance ("
            +" StuNo      INT REFERENCES Student (StuNo) ,"
          + " TeaNo       INT REFERENCES Teacher (TeaNo) ,"
          +"  ClassName   STRING,"
          +"  TaskId      STRING,"
          +"  Grade       DOUBLE,"
          +"  CommitDate  DATE,"
          +"  CorrectDate DATE,"
           +" TaskStatus  INT)";
    public static final String CREATE_Teacher="CREATE TABLE Teacher ("
           +" TeaName    STRING,"
            +"TeaNo      INT PRIMARY KEY,"
          +"  TeaCollege STRING,"
           +" TeachClass STRING,"
           +" TeaAge     INT,"
            +"Photo      TEXT,"
           +" TeaSex     INT)";

    //////////////分割线2019.5.20/阴///还在宿舍写代码///////////////
    private Context mContext;

    public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }
    public MyDbHelper(Context context){
        super(context,"HandClass.db",null,2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Student);
        db.execSQL(CREATE_Teacher);
        db.execSQL(CREATE_Account);
        db.execSQL(CREATE_Assessment);
        db.execSQL(CREATE_Attendance);
        db.execSQL(CREATE_Schedule);
        db.execSQL(CREATE_TaskPerformance);
        Toast.makeText(mContext, "Create succeeded!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Studenet");
        db.execSQL("drop table if exists Teacher");
        db.execSQL("drop table if exists Account");
        db.execSQL("drop table if exists Assessment");
        db.execSQL("drop table if exists Attendance");
        db.execSQL("drop table if exists Schedule");
        db.execSQL("drop table if exists TaskPerformance");
        onCreate(db);
    }

}