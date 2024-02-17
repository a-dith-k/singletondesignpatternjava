package com.adithk.singleton;

public class EagerSingleton {

    //here the multithreading scenario is handled because the
    // jvm creates the object after the class is loaded
    // at the time of jvm initialization hence jvm
    // ensures the object is created before any other thread access it

    //Todo:here the object is created everytime even if dont need it so
    // it wastes the memory and hence we have to handle it


    private static final EagerSingleton instance=new EagerSingleton();

    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}
