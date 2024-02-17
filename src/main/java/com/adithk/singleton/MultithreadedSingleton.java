package com.adithk.singleton;

public class MultithreadedSingleton {


    private static  MultithreadedSingleton instance = null;

    private MultithreadedSingleton(){

    }

    public static MultithreadedSingleton getInstance(){

        if(instance==null){

            synchronized (MultithreadedSingleton.class){

                if(instance==null)
                    instance=new MultithreadedSingleton();
            }
        }

        return instance;
    }


}
