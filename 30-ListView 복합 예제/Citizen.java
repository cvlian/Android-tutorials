package com.example.yangjiwon.city0910;

/**
 * Created by Yangjiwon on 2016-09-12.
 */
public class Citizen {
    private String name;

    public Citizen(){

    }
    public Citizen(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return "name = "+name;
    }
}