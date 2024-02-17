package com.adithk.singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    private static SerializableSingleton instance = null;

    private SerializableSingleton(){

    }


    // multithreading scenario is not handled here
    // if two threads access the  getInstance()
    // both will get a new object which
    // breaks the singleton design pattern
    public static SerializableSingleton getInstance(){
        if(instance == null){
            instance = new SerializableSingleton();
        }
        return instance;
    }


    protected Object readResolve(){
        return  instance;
    }



}
