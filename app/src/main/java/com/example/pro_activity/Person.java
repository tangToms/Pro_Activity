package com.example.pro_activity;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    private String name;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
