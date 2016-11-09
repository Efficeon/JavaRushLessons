package com.javarush.test.level29.lesson15.big01.human;
import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private int age;
    private String name;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student student = null;
        for(Student list : students)
        {
            if(list.getAverageGrade() == averageGrade)
            {
                student = list;
                break;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student = students.get(0);
        double maxAverageGrade = students.get(0).getAverageGrade();
        for(Student list : students)
        {
            if(list.getAverageGrade() >  maxAverageGrade)
            {
                maxAverageGrade = list.getAverageGrade();
                student = list;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade()
    {
        Student student = students.get(0);
        double minAverageGrade = students.get(0).getAverageGrade();
        for(Student list : students)
        {
            if(list.getAverageGrade() <  minAverageGrade)
            {
                minAverageGrade = list.getAverageGrade();
                student = list;
            }
        }
        return student;
    }

    public void expel(Student student)
    {
        students.remove(student);
    }
}
