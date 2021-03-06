package com.hr.ydkotlin.test;


class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

class Student extends Person {

    public Student(String name, String age) {
        super(name, age);
    }
}

class Test {
    public static void main(String[] args) {
        Student student = new Student("zhang", "33");
        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}