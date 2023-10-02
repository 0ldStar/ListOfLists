package com.mycompany.app;

import com.mycompany.app.Structs.ListOfLists;


public class Main 
{
    public static void main( String[] args )
    {
        ListOfLists<Integer> listOfLists = new ListOfLists<>(2);

        listOfLists.push(1);
        listOfLists.push(2);
        listOfLists.push(3);
        listOfLists.push(4);

        listOfLists.print();
    }
}
