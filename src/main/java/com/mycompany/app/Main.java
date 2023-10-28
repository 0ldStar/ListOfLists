package com.mycompany.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.mycompany.app.Structs.ListOfLists;

public class Main {
    public static void main(String[] args) {
        ListOfLists<Integer> listOfLists = new ListOfLists<>(2);
        String value;
        String fileName;

        listOfLists.push(4);
        listOfLists.push(2);
        listOfLists.push(3);
        listOfLists.push(-3);
        listOfLists.push(1);
        listOfLists.print();
        while (true) {
            System.out.println("\nList of lists Menu:");
            System.out.println("1. Get content");
            System.out.println("2. Save to file");
            System.out.println("3. Import from file");
            System.out.println("4. Push");
            System.out.println("5. Pop");
            System.out.println("6. Insert");
            System.out.println("7. Sort");
            System.out.println("8. Get by id");
            System.out.println("9. Balancing");
            System.out.println("10. Exit");
            String input = System.console().readLine();
            switch (input) {
                case "1":
                    listOfLists.print();
                    break;
                case "2":
                    System.out.println("Input file name:");
                    fileName = System.console().readLine();
                    try {
                        Serializer.write(listOfLists, fileName);
                        System.out.println("Stored");
                    } catch (IOException e) {
                        System.out.println("Can't open file");
                    }
                    break;

                case "3":
                    System.out.println("Input file name:");
                    fileName = System.console().readLine();
                    try {
                        listOfLists = Serializer.read(fileName);
                        System.out.println("Read");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Can't open file or can't cast data to ListOfLists");
                    }
                    break;

                case "4":
                    System.out.println("Input value for push:");
                    value = System.console().readLine();
                    try {
                        Integer number = Integer.valueOf(value);
                        listOfLists.push(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid integer input");
                    }
                    break;

                case "5":
                    System.out.println("Input index for pop:");
                    value = System.console().readLine();
                    try {
                        Integer number = Integer.valueOf(value);
                        Integer result = listOfLists.pop(number);
                        System.out.println("Pop " + result.toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid integer input");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index out of bounds: " + value);
                    } catch (NullPointerException e) {
                        System.out.println("List is empty");
                    }
                    break;

                case "6":
                    System.out.println("Input index for insert:");
                    String indexString = System.console().readLine();
                    System.out.println("Input value for insert:");
                    value = System.console().readLine();
                    try {
                        Integer index = Integer.valueOf(indexString);
                        Integer number = Integer.valueOf(value);
                        listOfLists.insert(index, number);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid integer input");
                    }
                    break;

                case "7":
                    listOfLists.sort();
                    System.out.println("Sorted");
                    break;

                case "8":
                    System.out.println("Input index for get:");
                    value = System.console().readLine();
                    try {
                        Integer number = Integer.valueOf(value);
                        System.out.println("Value: " + listOfLists.getElement(number));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid integer input");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index out of bounds: " + value);
                    } catch (NullPointerException e) {
                        System.out.println("List is empty");
                    }
                    break;

                case "9":
                    listOfLists.balancing();
                    System.out.println("Balanced");
                    break;
                case "10":
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
