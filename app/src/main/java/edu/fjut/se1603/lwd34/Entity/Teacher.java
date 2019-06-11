package edu.fjut.se1603.lwd34.Entity;

public class Teacher {
    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public int getTsex() {
        return tsex;
    }

    public void setTsex(int tsex) {
        this.tsex = tsex;
    }

    public int getTclass() {
        return tclass;
    }

    public void setTclass(int tclass) {
        this.tclass = tclass;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTprofess() {
        return tprofess;
    }

    public void setTprofess(String tprofess) {
        this.tprofess = tprofess;
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

    public Teacher(int tno, String tname) {
        super();
        this.tno = tno;
        this.tname = tname;
    }

    private int tno,tsex,tclass;
    private String tname,tprofess,birthDate,photo,pwd;

}
