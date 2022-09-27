package org.se1.anttest.model;

public class Student extends Person {
    
    private String matrnr;
    private String stdkz;
    private byte semester;
    
    public String getMatrnr() {
        return matrnr;
    }
    public void setMatrnr(String matrnr) {
        this.matrnr = matrnr;
    }
    public byte getSemester() {
        return semester;
    }
    public void setSemester(byte semester) {
        this.semester = semester;
    }
    public String getStdkz() {
        return stdkz;
    }
    public void setStdkz(String stdkz) {
        this.stdkz = stdkz;
    }

}
