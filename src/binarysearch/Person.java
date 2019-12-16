/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 *
 * @author alexeyprokopenko
 */


//this class will be used in a program
public class Person implements Comparable{
    
    private String lastname; 
    private String firstname;
    private int age ;
    
    public Person(String lName, String fName, int age){
        this.lastname = lName;
        this.firstname = fName;
        this.age = age;
    }
    

    @Override   // this function compares two objects by their fields 
    public int compareTo(Object o) {
        Person tmp = (Person)o;
        
        int res1 = this.lastname.compareTo(tmp.lastname);
        if(res1 == 0){      //if persons have the same last names
            int res2 = this.firstname.compareTo(tmp.firstname);//comparing first names
            if(res2 == 0){ //if persons have the same first names
                if(this.age<tmp.age)  //compareing their ages
                    return -1;
                else if(this.age>tmp.age)
                    return 1;
                return 0;
            }else return res2;           
        } else return res1;
    }

    @Override
    public String toString() {
        return "last name: " + this.lastname 
                + ", first name: " + this.firstname
                + ", age: " + this.age; 
    }
    
  
    
}
