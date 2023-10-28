package com.mycompany.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mycompany.app.Structs.ListOfLists;

public abstract class Serializer {

    public static <T extends Comparable<T>> void write(ListOfLists<T> listOfLists, String fileName) throws IOException {
        if (listOfLists != null) {
            try (FileOutputStream fos = new FileOutputStream(fileName);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(listOfLists);
            }
        }
    }

    public static <T extends Comparable<T>> ListOfLists<T> read(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            return (ListOfLists<T>) oin.readObject();
        }
    }
}
