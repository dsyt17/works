
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Artem
 */
public class Orders {
       
    private int id, department, acceptor;
    private String order, status;
    private Date datee;
    private String date = String.format("%f", datee);
    
    public Orders (int id, String order, int department, String date, int acceptor, String status) {
        this.id = id;
        this.department = department;
        this.acceptor = acceptor;
        this.order = order;
        this.date = date;
        this.status = status;    
    }
    
    public int getid() {
        return id;
     }
    
    public String getOrder() {
        return order; 
    }
    
    public int getDepartment(){
        return department;
    }
    
    public String getDate(){
        return date;
    }
    
    public int getAcceptor(){
        return acceptor;
    }
    
    public String getStatus(){
        return status;
    }
    
   }

