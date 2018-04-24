
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lakshmi
 */
public class InventoryStats extends javax.swing.JFrame {
int index=-1;
int mouseflag=0;
Connection con;
Statement stmt;
String query;
ResultSet rs;
void categorysearch(){
DefaultTableModel model = (DefaultTableModel)jTable1.getModel();    
model.setRowCount(0);
        try{
        Class.forName("java.sql.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","root");
stmt = con.createStatement();
query="select * from inventory where category='"+jComboBox1.getSelectedItem()+"';";
rs=stmt.executeQuery(query);
while(rs.next()){
    int id=rs.getInt("itemid");
    String iname=rs.getString("itemname");
    String cname=rs.getString("category");
    int presentvalues=rs.getInt("value");
    int presentcost=rs.getInt("price");
    model.addRow(new Object[]{id,iname,cname,presentvalues,presentcost});
    }
rs.close();
stmt.close();
con.close();
}
catch(Exception e1){
            e1.printStackTrace();
        }finally{
            }
}
void itemidsearch(){
    int temp=Integer.parseInt(jTextField2.getText());
    System.out.println(temp);
DefaultTableModel model = (DefaultTableModel)jTable1.getModel();    
model.setRowCount(0);
        try{
        Class.forName("java.sql.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","root");
stmt = con.createStatement();
query="select * from inventory where itemid like '%"+temp+"%';";
rs=stmt.executeQuery(query);
while(rs.next()){
    int id=rs.getInt("itemid");
    String iname=rs.getString("itemname");
    String cname=rs.getString("category");
    int presentvalues=rs.getInt("value");
    int presentcost=rs.getInt("price");
    model.addRow(new Object[]{id,iname,cname,presentvalues,presentcost});
    }
rs.close();
stmt.close();
con.close();
}
catch(Exception e1){
            e1.printStackTrace();
        }finally{
            }
}
void itemnamesearch(){
DefaultTableModel model = (DefaultTableModel)jTable1.getModel();    
model.setRowCount(0);
        try{
        Class.forName("java.sql.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","root");
stmt = con.createStatement();
query="select * from inventory where itemname like '%"+jTextField1.getText()+"%';";
rs=stmt.executeQuery(query);
while(rs.next()){
    int id=rs.getInt("itemid");
    String iname=rs.getString("itemname");
    String cname=rs.getString("category");
    int presentvalues=rs.getInt("value");
    int presentcost=rs.getInt("price");
    model.addRow(new Object[]{id,iname,cname,presentvalues,presentcost});
    }
rs.close();
stmt.close();
con.close();
}
catch(Exception e1){
            e1.printStackTrace();
        }
}
    /**
     * Creates new form InventoryStats
     */
    public InventoryStats() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Allocated", "Present", "Left"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Id", "Item name", "Category", "no of Units", "Price of each Unit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jTable1.setFocusable(false);
        jScrollPane2.setViewportView(jTable1);

        jTextField1.setText("Search Using Product Name");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("Search Using ID");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        jButton1.setText("CHECK STATS FOR ONLY PRODUCT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Main Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("INVENTORY STATS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(33, 33, 33)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        jTextField1.setText("");
        jTextField2.setText("Search Using ID");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        jTextField2.setText("");
        jTextField1.setText("Search Using Product Name");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        mouseflag=1;
        System.out.println("Combo Status Changed");// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(mouseflag==1){
            categorysearch();
            mouseflag=0;
        } else
        if(jTextField2.getText().equals("Search Using ID")&&jTextField1.getText().equals("Search Using Product Name"))
        JOptionPane.showMessageDialog(this, ("No Search Input Given"),("ERROR"), 2);
        else
        if(jTextField2.getText().equals("Search Using ID")){
            itemnamesearch();
        }else if(jTextField1.getText().equals("Search Using Product Name")){
            System.out.println(Integer.parseInt(jTextField2.getText()));
            itemidsearch();
            System.out.println(Integer.parseInt(jTextField2.getText()));
        }else {
            JOptionPane.showMessageDialog(this, ("No Search Input Given"),("ERROR"), 2);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
model.setRowCount(0);
        try{
        Class.forName("java.sql.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","root");
stmt = con.createStatement();
query="select * from inventory;";
rs=stmt.executeQuery(query);
while(rs.next()){
    int id=rs.getInt("itemid");
    String iname=rs.getString("itemname");
    String cname=rs.getString("category");
    int presentcost=rs.getInt("price");
    model.addRow(new Object[]{id,iname,cname,presentcost});
    }
rs.close();
stmt.close();
con.close();
}
catch(Exception e1){
            e1.printStackTrace();
        }finally{
            } 
      //above to fill table below is to update the categories in combox
        String temp;
        index=0;
        //int i=0;
        jComboBox1.removeAllItems(); 
        try{
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","root");
            Statement stmt = con.createStatement();
            String query="select type from inventorymain;";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                temp=rs.getString("type");
                //i++;
                System.out.println(temp);
                //jComboBox2.addItem(labels[i]);
                jComboBox1.addItem(temp);
                //dlm.addElement(rs.getString("category"));
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e1){
            e1.printStackTrace();
        }finally{
        }
        index=1;//it means the jcombobox is cleared and enterd again
        System.out.println(index);
       System.out.println(jComboBox1.getSelectedItem()); 

   model = (DefaultTableModel)jTable3.getModel();
        model.setRowCount(0);
        try{
            Class.forName("java.sql.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","root");
            stmt = con.createStatement();
            query="select inventorymain.type,inventorymain.most,sum(inventory.value) as present,inventorymain.most-sum(inventory.value)as after from inventorymain,inventory where inventorymain.type=inventory.category group by inventory.category;";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                String id=rs.getString("type");
                int iname=rs.getInt("most");
                int cname=rs.getInt("present");
                int presentvalues=rs.getInt("after");
                model.addRow(new Object[]{id,iname,cname,presentvalues});
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e1){
            e1.printStackTrace();
        }finally{
        }         // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new mainmenu().setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryStats().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
