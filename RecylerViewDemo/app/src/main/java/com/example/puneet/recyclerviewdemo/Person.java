package com.example.puneet.recyclerviewdemo;

/**
 * Created by puneet on 2/7/16.
 */
class Person {
    private String name;
    private String age;
    private int photoId;

    Person(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    public String getName(){
        return name;
    }

    public String getAge(){
        return age;
    }

    public int getPhotoId(){
        return photoId;
    }



}