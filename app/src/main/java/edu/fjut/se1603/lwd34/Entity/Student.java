package edu.fjut.se1603.lwd34.Entity;

public class Student {
    private int sno,sclass,stuSex;
    private String sname;
    private String sprofess;
    private String birthDate;
    private String photo;
    private String pwd;

    @Override
    public String toString() {
        return "学号=" + sno +
                ",初始密码="+pwd;}


    public Student(int sno,String pwd) {
        super();
        this.sno = sno;
        this.pwd = pwd;
    }

    public Student(int sno, int sclass, int stuSex, String sname, String sprofess, String birthDate, String photo, String pwd) {
       super();
        this.sno = sno;
        this.sclass = sclass;
        this.stuSex = stuSex;
        this.sname = sname;
        this.sprofess = sprofess;
        this.birthDate = birthDate;
        this.photo = photo;
        this.pwd = pwd;
    }

    public Student() {
        super();
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getSclass() {
        return sclass;
    }

    public void setSclass(int sclass) {
        this.sclass = sclass;
    }

    public int getStuSex() {
        return stuSex;
    }

    public void setStuSex(int stuSex) {
        this.stuSex = stuSex;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSprofess() {
        return sprofess;
    }

    public void setSprofess(String sprofess) {
        this.sprofess = sprofess;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
