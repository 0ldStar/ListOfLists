package com.mycompany.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mycompany.app.Structs.ListOfLists;

public class Serializer<T extends Comparable<T>> {
    Serializer() {
        
    }

    public void write(ListOfLists<T> listOfLists) throws IOException {
        if (listOfLists != null) {
            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listOfLists);
            oos.flush();
            oos.close();
            fos.close();
        }
    }

    public ListOfLists<T> read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        ListOfLists<T> listOfLists = (ListOfLists<T>) oin.readObject();
        oin.close();
        fis.close();
        return listOfLists;
    }

}
