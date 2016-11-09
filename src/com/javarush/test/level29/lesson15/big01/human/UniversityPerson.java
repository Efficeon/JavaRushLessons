package com.javarush.test.level29.lesson15.big01.human;

public class UniversityPerson extends Human
{
    private University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }
    public University getUniversity() {
        return university;
    }

    public void live() {
        learn();
    }
    public void learn() {
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
