package edu.fjut.se1603.lwd34.Entity;

public class Attend {

    int sno;
    int week;
    int status;



    int classid;
    String attenddate,classname;
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAttenddate() {
        return attenddate;
    }

    public void setAttenddate(String attenddate) {
        this.attenddate = attenddate;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

  public Attend(int id, String date, int week, String classname, int status){
        super();
        this.sno=id;
        this.attenddate=date;
        this.week = week;
        this.classname = classname;
        this.status =status;

  }

  public Attend(){
        super();
  }
    @Override
    public String toString() {
        return "出勤信息" +
                "学号=" + sno +
                ", 星期=" + week +
                ", 状态=" + status +
                ", 课程序号=" + classid +
                ", 出勤日期=" + attenddate +
                ", 课程名=" + classname ;
    }
}
