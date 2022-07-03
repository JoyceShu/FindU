package com.example.findu;

public class Post {
    private String name;
    private int age;

    private String notes;

    public Post(String name, int age, String notes) {
        this.name = name;
        this.age = age;
        this.notes = notes;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



}
