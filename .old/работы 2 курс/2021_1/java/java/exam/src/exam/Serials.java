/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Serials;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.LinkedList;

/**
 *
 * @author Игорь
 */

public class Serials {
    String title, director, genre, type;
    int year;
 
    public Serials() {};
 
 
Serials ser1 = new Serials();
{
ser1.title = "Название";
ser1.director = "Реж";
ser1.genre = "жанр";
ser1.type = "тип";
ser1.year = 1;
ser1.show();
}
    
public void show(){
System.out.print(title + "; " + director + "; " + genre + "; " + type + "; " + year);
} 


 private List Serials = new ArrayList<>();
 {
 Serials.add("1");
 
 
 
 }
  /*
 
 private static Serials myDB = new Serials();
 
 
 
 /*
 public static void Serials(String[] args) {

        myDB.addSerial(new Serial());

        
    }
 
 
 
 
 void addSerial(Serials Serials) {
        db.add(Serials);
    }
 /*
  Serials newSerial() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название: ");
        String title = scan.next();
        System.out.print("Введите режиссера: ");
        String director = scan.next();
        System.out.print("Введите жанр: ");
        String genre = scan.next();
        System.out.print("Введите тип: ");
        String type = scan.next();
        System.out.print("Введите год: ");
        int year = scan.nextInt();
        Serials h = new Serials(title, director, genre, type, year);
        System.out.println(h);
        return h;
 }
 

 */
 
 void showSerials() {
        Serials.forEach(System.out::println);
    }
 
 int getYear() {
        return year;
    }
  void showOldest() {
    int year1 = 2021; 
    
    for (Serials yDb : db) {
        if (yDb.getYear() > year1) continue;
        year1 = yDb.getYear(); 
        }
        System.out.println("Самый старый сериал: " + year1);
    }
 
 
 private static void menu() {
        Scanner scan = new Scanner(System.in);
        mark:
        while (true) {
            System.out.println("1. Показать все сериалы");
            System.out.println("2. Самый старый сериал");
            int result = scan.nextInt();
 
            switch (result) {
                case 1:
                    Serials.show();
                    break;
                case 2:
                    Serials.showOldest();
                    break;
                default:
                    break mark;
            }
        }
    }
 
 
   
}





    
