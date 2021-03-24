package com.yangjiwon.example.city0523;

/**
 * Created by Yangjiwon on 2016-05-29.
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
        this.name = name;
    }

    @Override
    public String toString(){
        return "name = "+name;
    }
}