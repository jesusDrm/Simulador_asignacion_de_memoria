/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.simulador_asignacion_de_memoria;

import java.util.Collection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

//:)

class Cache {

    int key;
    String value;
    
    Cache(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

/**
 *
 * @author cruz_
 */
public class LRU_QUEUE extends javax.swing.JFrame {
    int fallos=0;
    int conteo=0;
    String[] Valores = new String[100];
    
    public int ValCache() {
        return Integer.parseInt(String.valueOf(jSpinner1.getValue()));
    }
    static Deque<Integer> q = new LinkedList<>();
    
    static Map<Integer, Cache> map = new HashMap<>();
    static Map<Integer,String> lru = new HashMap<>(); 
    
    public boolean fails(String Values, HashMap k){
        return k.containsValue(Values);
    }
    public String obtenerElementodeCache(int key) {
        if (map.containsKey(key)) {
            Cache actual = map.get(key);
           
            //q.remove(actual.key);
            //q.addFirst(actual.key);
            return actual.value;
        }
        return "No exite";
    }
    public void colocarElementoCache(int key, String valor,int CA) {
  
        if (map.containsKey(key)) {
            Cache actu = map.get(key);
            q.remove(actu.key);    
            
        }
        
        else {
            
            if (q.size() == CA) {
            
                int temp = q.removeLast();
                map.remove(temp);
               // fallos++;
                
            }

            Cache nuevoOb = new Cache(key, valor);
            q.addFirst(nuevoOb.key); 
            map.put(key, nuevoOb);
            lru.put(key,valor);
           //fallos++;
        }
    }

    /**
     * Creates new form LRU_FIFO
     */
    public LRU_QUEUE() {
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Cache");

        jButton1.setText("Ingresar datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Clave", "Valor"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("LRU");

        jLabel3.setText("Fallos");

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Rendimiento");

        jTextField2.setText("jTextField2");

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("Calcular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3)
                                .addGap(12, 12, 12)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ValCache() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresar Procesos y Particiones", "Alerta", 1);
            return;
        }
        jTable1.setEnabled(true);
        
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            jTable1.setValueAt(null, i, 0);
            jTable1.setValueAt(null, i, 1);
        }
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            jTable2.setValueAt(null, i, 0);
            jTable2.setValueAt(null, i, 1);
        }
         
          Deque<Integer> q = new LinkedList<>();
          Map<Integer, Cache> map = new HashMap<>();
        jButton1.setEnabled(true);

    }//GEN-LAST:event_jButton1ActionPerformed
    private void insertartabla(JTable tabla1, JTable tabla2) {
        
        LRU_QUEUE cache = new LRU_QUEUE();
        //LinkedList<String> Valores = new LinkedList<>();
        //String [] Valores;
        int key;
        String Values;
        Values =(String)tabla1.getValueAt(0, 1);
        //Valores[0]=Values;
        key=Integer.parseInt((String)tabla1.getValueAt(0, 0));
        cache.colocarElementoCache(key, Values ,ValCache());
        //q.toArray();
        Object[]keys2 =q.toArray();
        //Object[]Valores =q.toArray();
         for (int i = 0; i < jTable2.getRowCount(); i++) { 
             jTable2.setValueAt(null, i, 0);
            jTable2.setValueAt(null, i, 1);
        }
                   
        for(int i=0;i<q.size();i++){
            //Valores[i]=cache.obtenerElementodeCache((int)keys2[i]);
            tabla2.setValueAt(keys2[i],i,0); 
            tabla2.setValueAt(cache.obtenerElementodeCache((int)keys2[i]),i,1);
           System.out.println(lru.containsValue(cache.obtenerElementodeCache((int)keys2[i])));
            }
      System.out.println(lru);
       
        //System.out.println(cache.fails(cache.obtenerElementodeCache((int)keys2[i]), (HashMap) lru));
        
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //jButton1.setEnabled(false);
        //jButton3.setEnabled(false);
        //jSpinner1.setValue(1);
        jTable1.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        System.out.println("ValCacheBr: "+ValCache());
        
        insertartabla(jTable1, jTable2);
                 for (int i = 0; i < jTable1.getRowCount(); i++) {
            jTable1.setValueAt(null, i, 0);
            jTable1.setValueAt(null, i, 1);
        }   
      // q.forEach(System.out::println);
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            
        //int valorSpinner = Integer.parseInt(jSpinner1.getValue().toString());
        // System.out.println(valorSpinner);
        LRU_QUEUE cache = new LRU_QUEUE();
        System.out.println(cache.jSpinner1.getValue());
        System.out.println("fallos: "+cache.fallos);
        //cache.colocarElementoCache(1, "Valor_1");
        //System.out.println(q);

        /*
        LRU_FIFO cache = new LRU_FIFO();  
    cache.putElementInCache(1, "Value_1");
    cache.putElementInCache(1, "Value_1"); System.out.println(q); 
    cache.putElementInCache(2, "Value_2");  
    cache.putElementInCache(3, "Value_3");  
    System.out.println(q); 
    cache.putElementInCache(4, "Value_4");  
    System.out.println(cache.getElementFromCache(2));  
    System.out.println();    
    System.out.println(q); 
    System.out.println();
    System.out.println();
    System.out.println(cache.getElementFromCache(5));  
    cache.putElementInCache(5,"Value_5");  
    System.out.println();  
    System.out.println(q);  
    System.out.println();  
         */
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
            java.util.logging.Logger.getLogger(LRU_QUEUE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LRU_QUEUE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LRU_QUEUE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LRU_QUEUE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LRU_QUEUE().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables


    private Object getEnt() {
     return q.getLast();
    }

    
}
