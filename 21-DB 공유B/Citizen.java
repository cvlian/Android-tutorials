package com.example.yangjiwon.city0901;

/**
 * Created by Yangjiwon on 2016-09-01.
 */
public class Citizen {
    private int id;
    private String name;
    private String email;

    public Citizen(){}

    public Citizen(String name, String email){
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return "Name : "+name+"\nE-mail : "+email;
    }
}