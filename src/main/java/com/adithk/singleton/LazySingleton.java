package com.adithk.singleton;

import java.io.Serializable;

public class LazySingleton implements Serializable {

    private static LazySingleton instance = null;

    private LazySingleton(){

    }


    // multithreading scenario is not handled here
    // if two threads access the  getInstance()
    // both will get a new object which
    // breaks the singleton design pattern
    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }



}
