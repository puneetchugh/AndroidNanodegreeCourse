package com.example.puneet.fragmentsandloaders;

/**
 * Created by puneet on 2/15/16.
 */
public class Person {

    private String name;
    private String email;
    private String phone;

    public Person(String name, String email, String phone){

        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName(){

        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }
}
