package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    private List<Human> children = new ArrayList<>();
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta)
    {
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setCourse(int course){
        this.course = course;
    }

    public void setAverageGrade(double averageGrade){
        this.averageGrade = averageGrade;
    }

    public int getCourse() {
     return course;
     }
    
    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getPosition()
    {
        return "Студент";
    }
}