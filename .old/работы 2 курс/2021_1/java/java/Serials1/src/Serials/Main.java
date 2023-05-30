
package pkg1lr;

import java.util.Scanner;
 
public class Main {
 
    private static DataBase myDB = new DataBase();
 
    public static void main(String[] args) {
        //example
        myDB.addSerial(new Serial("Назв","Реж","Жанр","Тип", 2021));
        myDB.addSerial(new Serial("1","2","3","4", 2010));
        myDB.addSerial(new Serial("2сериал","34","123","43", 2001));
        myDB.addSerial(new Serial("3сериал","35","345","65", 2000));
        myDB.addSerial(new Serial("4сериал","35","345","65", 1917));
        myDB.addSerial(new Serial("5сериал","35","345","65", 1997));
        myDB.addSerial(new Serial("6сериал","35","345","65", 1997));
     
        menu();
    }
 
    private static void menu() {
        Scanner scan = new Scanner(System.in);
        mark:
        while (true) {
            System.out.println("1. Добавить сериал");
            System.out.println("2. Найти сериал по названию");
            System.out.println("3. Показать всех");
            System.out.println("4. Самый старый сериал");
            System.out.println("0. Выход");
            int result = scan.nextInt();
 
            switch (result) {
                case 1:
                    myDB.addSerial(myDB.newSerial());
                    break;
                case 2:
                    myDB.findSerial(myDB.findSerial());
                    break;
                case 3:
                    myDB.showSerials();
                    break;
                case 4:
                    myDB.showOldest();
                    break;
               
                default:
                    break mark;
            }
        }
    }
}