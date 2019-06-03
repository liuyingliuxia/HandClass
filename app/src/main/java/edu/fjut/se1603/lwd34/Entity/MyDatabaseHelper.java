package edu.fjut.se1603.lwd34.Entity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_Student="CREATE TABLE student ("
            + "SNo           INTEGER PRIMARY KEY AUTOINCREMENT ,"
            +" SName         STRING,"
            +" SProfess      STRING,"
            +" SClass        INTEGER,"
            +"BirthDate     STRING,"
            +"SSex          INTEGER,"
            +"Photo            TEXT,"
            +"Pwd          STRING)";

    public static final String CREATE_Teacher="CREATE TABLE teacher ("
            +" TNo          INTEGER PRIMARY KEY AUTOINCREMENT,"
            +" TName       STRING,"
            +" TProfess    STRING,"
            +" TClass      INTEGER,"
            +" BirthDate   STRING,"
            +" TSex        INTEGER,"
            +" Photo      TEXT,"
            +" Pwd         STRING)";

    public static final String CREATE_Attend="CREATE TABLE stu_attend ("
            + "SNo          INTEGER REFERENCES student (SNo),"
            + "AttendDate    DATE,"
            + "Week          INTEGER,"
            + "ClassId      INTEGER,"
            + "AttendStatus INTEGER,"
            + " ClassName    STRING)";

    public static final String CREATE_HomeworkScore= "CREATE TABLE homework_score ("
            +"  SNo                INTEGER REFERENCES student (SNo) ,"
            + " TNo                INTEGER REFERENCES teacher (TNo) ,"
            +"  ClassName          STRING,"
            +"  HomeworkTitle      STRING,"
            +"  SGrade             DOUBLE,"
            +" HomeworkStatus      INTEGER)";

    public static final String CREATE_StuAssess="CREATE TABLE stu_assess ("
            +"SNo STRING REFERENCES Student (StuNo) ,"
            +"TNo STRING REFERENCES Teacher (TeaNo) ,"
            +"ClassName    STRING,"
            +"AssessScore DOUBLE)";
    public static final String CREATEE_COURSE="CREATE TABLE course("
            +"SProfess  STRING ,"
            +"SClass    INTEGER,"
            +"Week      INTEGER,"
            +"ClassId   INTEGER,"
            +"ClassName STRING,"
            +"ClassPlace STRING)";

    public Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }
    public MyDatabaseHelper(Context context) {
        super(context, "MyHandClass.db", null, 2);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Student);
        db.execSQL(CREATE_Teacher);
        db.execSQL(CREATE_Attend);
        db.execSQL(CREATE_HomeworkScore);
        db.execSQL(CREATE_StuAssess);
        db.execSQL(CREATEE_COURSE);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      /*  db.execSQL("drop table if exists studenet");
        db.execSQL("drop table if exists teacher");
        db.execSQL("drop table if exists stu_assess");
        db.execSQL("drop table if exists stu_attend");
        db.execSQL("drop table if exists homework_score");
        db.execSQL("drop table if exists course");
        onCreate(db);*/
    }

}
