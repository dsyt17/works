/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Artem
 */
public class Users {
private int id; 

    private String fio, staff, tel, login, pass, sex; 

    public Users (int id, String fio, String staff, String tel, String login, String pass, String sex) { 

        this.id = id; 

        this.fio = fio; 

        this.staff = staff; 

        this.tel = tel; 

        this.login = login; 

        this.pass = pass; 

        this.sex = sex; 

    } 

    public int getid() { 

        return id; } 

    public String getfio() { 

        return fio; } 

    public String getstaff() { 

        return staff; } 

    public String gettel() { 

        return tel; } 

    public String getlogin() { 

        return login; } 

    public String getpass() { 

        return pass; } 

    public String getsex() { 

        return sex; } 

    
} 
   
    
