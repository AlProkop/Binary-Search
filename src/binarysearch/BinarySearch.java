/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Arrays;


/**
 *
 * @author alexeyprokopenko
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creating objects
        Person p1 = new Person("A", "D", 25);
        Person p2 = new Person("A", "A", 29);
        Person p3 = new Person("B", "X", 21);
        Person p4 = new Person("A", "F", 26);
        Person p5 = new Person("C", "C", 32);
        Person p6 = new Person("A", "D", 20);
        Person p7 = new Person("F", "F", 21);
        Person p8 = new Person("D1", "W", 19);
        Person p11 = new Person("A", "D1", 25);
        Person p21 = new Person("A", "A", 29);
        Person p31 = new Person("B", "X", 1);
        Person p41 = new Person("A2", "F", 26);
        Person p51 = new Person("C", "C2", 32);
        Person p61 = new Person("A", "D", 40);
        Person p71 = new Person("F", "F4", 21);
        Person p81 = new Person("D4", "W", 19);
        
        // creating two differts unsorted arrays to be used in binary and linear sorts
        Person[] persons1 = {p1, p2, p3, p4, p5, p6, p7, p8, p11, p21, p31, p41, p51, p61, p71, p81};
        Person[] persons2 = {p1, p2, p3, p4, p5, p6, p7, p8, p11, p21, p31, p41, p51, p61, p71, p81};
            
    // object p is used for tests
        Person p;
        p = p7;
    //    p = new Person("n", "n", 0);  //100% is unexisted element in array
        
        //----- staring colculations
        long start = System.nanoTime(); //fixing time before the sorting and the searching
        Arrays.sort(persons1);  //sorting array
        int result = binarySearch(persons1, p); //trying to find oject p in array
        long exeTime = System.nanoTime() - start; //calculating exetucion time

        
        //----- Displaying sorted array
        System.out.println("Objects in the array: ");
        Arrays.sort(persons1);
        for(int i = 0; i < persons1.length; i++)
            System.out.println(i + ": " + persons1[i]);      
        //-----
               
        //----- Displaying BinarySearch results
        System.out.println("\nBinarySearch");
        System.out.println("Execution time: " + exeTime);
        
        if(result != -1) // if there is no matches binarySearch returns -1 
                         // else it returns index of element in an array
            System.out.println("Person " + p + " has an index " + result);
        else
            System.out.println("Requested person doesn't exist in an array");
       
        //the same operations with LinearSearch
        start = System.nanoTime();
        Arrays.sort(persons2);
        int result1 = linearSearch(persons2, p);
        exeTime = System.nanoTime() - start;
        System.out.println("\nLinearSearch");
        System.out.println("Execution time: " + exeTime);
        if(result != -1)
            System.out.println("Person " + p + " has an index " + result1);
        else
            System.out.println("Requested person doesn't exist in an array");
    
    
    };
    
    public static int binarySearch(Person[] persons, Person p){
        int left = 0;                   //first element of the array
        int right = persons.length - 1; //last element
        while (left <= right){
            int med = left + (right-left) / 2; //finding middle element        
            int res = persons[med].compareTo(p); //compering it with object p 
            if(res == 0) //0 means that middle element and search element (p) have the same value
                return med;
            if(res < 0) // middle element less than search element
                left = med + 1; //cutting the left part of array (subarray starts from med+1 index
            if(res > 0)  //in other case 
                right = med - 1;//cutting the right  part
        }
        return -1; // element p doesn't exist in the array
    };
    
    public static int linearSearch(Person[] persons, Person p){
        for(int i = 0; i < persons.length; i++){ //comparing each element of array 
            if (persons[i].compareTo(p) == 0)    //until search element will be find
                return i;            
        }
        return -1; //in other case function returns -1
    } 
}
