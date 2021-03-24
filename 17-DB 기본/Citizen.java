package com.example.yangjiwon.city0813;

/**
 * Created by Yangjiwon on 2016-08-30.
 */
public class Citizen {
    private int id;
    private String name;

    public Citizen(){

    }

    public Citizen(int id, String name){
        super();
        this.id = id;
        this.name = name;
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

    @Override
    public String toString(){
        return name;
    }
}