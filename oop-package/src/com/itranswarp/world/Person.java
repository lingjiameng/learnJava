package com.itranswarp.world;


public class Person{
    public String name;
    public Person(String n){
        this.name = n;
    }

    public void hello(){
        System.out.println(this.name + " hello!");
    }
}