/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lr11;


public class specialists {
    
    
     private int id; 

    private String fio; 

    private String department; 

    private String power; 

    private String tech; 

    private String ide; 

    private String lang; 

     

    public int getId() { return id; } 


    public void setId(int id) { this.id = id; } 


    public String getFIO() { return fio; } 

     

    public void setFIO(String fio) { this.fio = fio; }
     

    public String getDepartment() { return department; } 

     

    public void setDepartment(String department) { this.department = department; } 

     

    public String getPower() { return power; } 

     

    public void setPower(String power) { this.power = power; } 

     

    public String getTech() { return tech; } 

     

    public void setTech(String tech) { this.tech = tech; } 

     

    public String getIDE() { return ide; } 

     

    public void setIDE(String ide) { this.ide = ide; } 

     

    public String getLang() { return lang; } 

     

    public void setLang(String lang) { this.lang = lang; } 

     

    @Override 

    public String toString(){ 

        return "ID=" + getId() + "\nФИО специалиста: " + getFIO() + "\nКафедра - " + getDepartment() +  

                "\nСтепень: " + getPower() + "\nТехнологии: " + getTech() + "\nIDE: " + getIDE() + "\nЯП: " + getLang() + "\n\n"; 

    } 
    
    
    
}
