package org.se1.anttest.model;


public class Course {
    
    private String lvrnr;
    private String title;
    private Teacher teacher;
    
    public String getLvrnr() {
        return lvrnr;
    }
    public void setLvrnr(String lvrnr) {
        this.lvrnr = lvrnr;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
