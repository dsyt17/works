package lr5;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UsersTable extends javax.swing.JFrame {

    public UsersTable() {
        initComponents();
        show_users();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Номер", "ФИО", "Должность", "Телефон", "Логин", "Пароль", "Пол"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<Users> usersList() {
        ArrayList<Users> usersList = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test","igor","225506");
            String sql = "select * from users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Users users;
            while (rs.next()) {
                users = new Users(rs.getInt("id"), rs.getString("fio"), rs.getString("staff"), rs.getString("tel"), rs.getString("login"), rs.getString("pass"), rs.getString("sex"));
                usersList.add(users);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return usersList;
    }

    public void show_users() {
        ArrayList<Users> list = usersList();
        DefaultTableModel mod = (DefaultTableModel)jTable1.getModel();
        Object[] col = new Object[7];
        for (int i=0; i<list.size(); i++) {
            col[0] = list.get(i).getid();
            col[1] = list.get(i).getfio();
            col[2] = list.get(i).getstaff();
            col[3] = list.get(i).gettel();
            col[4] = list.get(i).getlogin();
            col[5] = list.get(i).getpass();
            col[6] = list.get(i).getsex();
            mod.addRow(col);
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new UsersTable().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
