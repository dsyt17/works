package pkg1lr;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
class DataBase {
    private List<Serial> db = new ArrayList<>();
 
    void addSerial(Serial Serial) {
        db.add(Serial);
    }
 
    void showOldest() {
    int year1 = 2021; 
    for (Serial yDb : db) {
        if (yDb.getYear() > year1) continue;
        year1 = yDb.getYear(); 
        }

        System.out.println("Самый старый сериал: " + year1);
    }
 
    
    int findSerial() {
        Scanner scan = new Scanner(System.in);
        String find;
        while (true) {
            System.out.print("Введите название: ");
            find = scan.next();
            for (int i = 0; i < db.size(); i++) {
                if (find.equals(db.get(i).getTitle())) {
                    System.out.println("Найден номер записи: " + i);
                    return i;
                }
            }
            System.out.println("Совпадений не найдено!");
        }
    }
 
Serial newSerial() {
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
        Serial h = new Serial(title, director, genre, type, year);
        System.out.println(h);
        return h;
    }
 
   
 
    void showSerials() {
        db.forEach(System.out::println);
    }
    
    
    int findSerial(int findSerial) {
        
       Scanner scan = new Scanner(System.in);
        String find;
        while (true) {
            System.out.print("Введите название: ");
            find = scan.next();
            for (int i = 0; i < db.size(); i++) {
                if (find.equals(db.get(i).getTitle())) {
                    System.out.println("Найден номер записи: " + i);
                    return i;
                }
            }
            System.out.println("Совпадений не найдено!");
        }
    }
}