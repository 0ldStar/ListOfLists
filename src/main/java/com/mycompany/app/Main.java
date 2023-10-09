package com.mycompany.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.mycompany.app.Structs.ListOfLists;

public class Main {
    public static void main(String[] args) {
        ListOfLists<Integer> listOfLists = new ListOfLists<>(2);

        listOfLists.push(1);
        listOfLists.push(2);
        listOfLists.push(3);
        listOfLists.push(4);
        listOfLists.print();
        // listOfLists.pop(3);
        // listOfLists.print();
        // listOfLists.pop(2);
        // listOfLists.print();
        // listOfLists.pop(1);
        // listOfLists.print();
        // listOfLists.pop(0);
        // listOfLists.print();
        // listOfLists.insert(0, 1);
        // listOfLists.print();
        // listOfLists.insert(0, 2);
        // listOfLists.print();
        // listOfLists.insert(0, 3);÷
        // listOfLists.print();
        // listOfLists.insert(2, 4);
        // listOfLists.print();
        // listOfLists.insert(2, 4);
        // listOfLists.print();
        Serializer<Integer> serializer = new Serializer<>();
        try {
            serializer.write(listOfLists);

        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println();
        }
        try {
            ListOfLists listOfLists2 = serializer.read();

            listOfLists2.print();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
