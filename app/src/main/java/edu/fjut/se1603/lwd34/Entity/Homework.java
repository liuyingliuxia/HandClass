package edu.fjut.se1603.lwd34.Entity;

public class Homework {
    int Sno;
    String cname,title;
    double grade;
    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Homework(int sno, String cname, String title, double grade) {
        Sno = sno;
        this.cname = cname;
        this.title = title;
        this.grade = grade;
    }
}
