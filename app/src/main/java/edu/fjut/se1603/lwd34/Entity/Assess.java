package edu.fjut.se1603.lwd34.Entity;

public class Assess {
    int sno,tno;
    String classname ;
    double score;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    Assess(){
        super();
}

    public Assess(int sno, String classname, double score){
        super();
        this.sno=sno;
        this.classname=classname;
        this.score=score;
    }
    @Override
    public String toString() {
        return "课程评价{" +
                "学生学号=" + sno +
                ", 教师职工号=" + tno +
                ", 课程名='" + classname + '\'' +
                ", 课堂得分=" + score +
                '}';
    }
}
