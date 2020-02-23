package com.fei.sstudy.entity;


public class Student {
    public static Student student;

    private String name;
    private String college;

    private Student(){}

    public static Student getInstance(){
        if (student==null){
            synchronized (Student.class){
                if (student==null){
                    student = new Student();
                }
            }
        }
        return student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
