package com.adithk;

import com.adithk.singleton.EagerSingleton;
import com.adithk.singleton.EnumSingleton;
import com.adithk.singleton.LazySingleton;
import com.adithk.singleton.SerializableSingleton;

import java.awt.font.LineMetrics;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

//        serialization();
        reflection();
        EnumSingleton.INSTANCE.printHello();
    }



    private static void serialization() throws IOException, ClassNotFoundException {

        LazySingleton instance=LazySingleton.getInstance();

        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("object.obj"));
        outputStream.writeObject(instance);
        outputStream.close();

        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("object.obj"));
        LazySingleton deserializedSingleton=(LazySingleton) inputStream.readObject();
        inputStream.close();

        //serializing and deserializing the object creates violating the singleton design pattern that one object should be created
        System.out.println("Hashcode Object 1 :"+instance.hashCode());
        System.out.println("Hashcode Object 2 :"+deserializedSingleton.hashCode());


        //to solve this we should override the readResolve method in the Object class
        // and return the instance already created
        // everytime deserialization happens this method is called

        SerializableSingleton serializableSingleton=SerializableSingleton.getInstance();

        ObjectOutputStream outputStream1=new ObjectOutputStream(new FileOutputStream("object1.obj"));
        outputStream1.writeObject(serializableSingleton);
        outputStream1.close();

        ObjectInputStream inputStream1=new ObjectInputStream(new FileInputStream("object1.obj"));
        SerializableSingleton deserializedSerializableSingleton=(SerializableSingleton) inputStream1.readObject();
        inputStream1.close();

        System.out.println("Object 1 :"+serializableSingleton.hashCode());
        System.out.println("Object 2 :"+deserializedSerializableSingleton.hashCode());


    }

    private static void reflection() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Constructor[] constructors=LazySingleton.class.getDeclaredConstructors();


        Constructor constructor=constructors[0];

        constructor.setAccessible(true);

        LazySingleton instance1=(LazySingleton) constructor.newInstance();
        LazySingleton instance2=LazySingleton.getInstance();

        System.out.println("instance 1 :"+instance1.hashCode());
        System.out.println("instance 2 :"+instance2.hashCode());


    }
}