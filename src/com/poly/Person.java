package com.poly;

public class Person {
    private long id;
    private String nom;
    private int age;

    // Constructors
    public Person() {}

    public Person(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}