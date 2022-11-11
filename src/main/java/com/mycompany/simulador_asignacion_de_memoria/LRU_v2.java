/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.simulador_asignacion_de_memoria;

import static com.mycompany.simulador_asignacion_de_memoria.LRU_QUEUE.map;
import static com.mycompany.simulador_asignacion_de_memoria.LRU_QUEUE.q;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javax.swing.JTextArea;

//:)


/**
 *
 * @author cruz_
 */
public class LRU_v2 extends javax.swing.JFrame {
     private String  lruOutput = "",  lruFinalFrames = "";
    private String[] pages;
    
//    String[] fallos= new String[pages.length];
    private int frames;
    private int  lruFaults = 0;
    
    public LRU_v2(String[] pages, int frames) {
        this.pages = pages;
        this.frames = frames;
    }
    public void lru(JTable jTable2) {
        
        float ren=0,fallos,total;
        String [] fa=new String[pages.length];
        Deque<Integer> q = new LinkedList<>();
        HashSet<String> s = new HashSet<>(frames);
        // To store least recently used indexes of pages.
        HashMap<String, Integer> indexes = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            
            // Check if the set can hold more pages
            if (s.size() < frames) {
                // Insert it into set if not present
                // already which represents page fault
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);                    
                    // increment page fault
                    lruFaults++;
                    lruOutput += "F";
                    fa[i]="F";
                } else {
                   // jTable2.setValueAt(s,i,2);
                    lruOutput += "-";
                    fa[i]="-";
                }
                // Store the recently used index of
                // each page
                indexes.put(pages[i], i);
            }

            // If the set is full then need to perform lru
            // i.e. remove the least recently used page
            // and insert the current page
            else {
                // Check if current page is not already
                // present in the set
                if (!s.contains(pages[i])) {
                    // Find the least recently used pages
                    // that is present in the set
                    String val="";
                    int lru = Integer.MAX_VALUE;
                    //int val = Integer.MIN_VALUE;

                    Iterator<String> itr = s.iterator();

                    while (itr.hasNext()) {
                        String temp = itr.next();
                        
                        if (indexes.get(temp) < lru) {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }
                     
                    // Remove the indexes page
                    s.remove(val);
                    indexes.remove(val);
                    // insert the current page
                    s.add(pages[i]);

                    // Increment page faults
                    
                    lruFaults++;
                    lruOutput += "F";
                    fa[i]="F";
               
                } else {
                    lruOutput += "-";
                    fa[i]="-";
                }
                
                
                // Update the current page index
                indexes.put(pages[i], i);
                
            }
           
            // Object[] Res=s.toArray();
            //this.valores[i]=s.toArray();
            //System.out.println(s);
            /*
            Iterator<String> iter = s.iterator();
            
            String[] el = new String[1];
            while(iter.hasNext()){
                el[0] = iter.next().toString();
            }
            */
           jTable2.setValueAt(s.toString(),i,2);
           jTable2.setValueAt(fa[i],i,1);
            
        }
        System.out.println(s);
        
       // for(int i=0;i<this.valores.length;i++){
           // System.out.println(this.valores[i]);
        //}
        //ren=lruFaults/pages.length;
       
        //jTable2.setValueAt(lruOutput,0,1);
        jTable2.setValueAt(lruFaults,0,0);
        fallos=lruFaults;
        total=pages.length;
        ren=fallos/total;
        jTable2.setValueAt(1-ren,0,3);
       // System.out.println(Res[0]);
        s.forEach(frame -> lruFinalFrames+=frame+",");
        
        lruFinalFrames = lruFinalFrames.substring(0,lruFinalFrames.length()-1);
    }
public void insertarTabla(String texto, JTable tabla2){
         double rendi=0.0;
         char[] caracteres=texto.toCharArray();
         String[]valores=new String[caracteres.length];
         for(int i=0;i<caracteres.length;i++){
              valores[i]=String.valueOf(caracteres[i]);
         }
        LRU_v2 lr = new LRU_v2(valores, ValCache());
        lr.lru(tabla2);
        //float len=caracteres.length;
        //float fau=lr.getLruFaults();
        //rendi=fau/len;
        //System.out.println(caracteres.length);
        //System.out.println(lr.getLruFaults());
        //jTable2.setValueAt(1-rendi,0,4);
        
    
}
public void print() {
        System.out.println("Y means there was a page fault (miss), and N means there was not (hit).");
        final Object[][] table = new String[2][pages.length + 1];
        table[0][0] = "";
        table[1][0] = "LRU";
        String format = "";
        for (int i = 0; i < pages.length; i++) {
            table[0][i + 1] = pages[i] + "";
            table[1][i + 1] = lruOutput.charAt(i) + "";
            format += "%5s";
        }
        format += "%5s\n";

        for (final Object[] row : table) {
            System.out.format(format, row);
            System.out.println("------------------------------------------------------------------------------------");
        }

        System.out.println("\n***********************************************************************************************************\n");
        System.out.printf("%10s %22s %19s %40s\n", "Replacement Algorithm", "No. of Page Faults", "Compact Output", "Final Frames Content (NOT ORDERED)");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.format("%10s %22s %30s %25s\n", "LRU", lruFaults, lruOutput, lruFinalFrames);
        System.out.println("---------------------------------------------------------------------------------------------------------");
       
}
    

    //String[] Valores = new String[100];
    
    public int ValCache() {
        return Integer.parseInt(String.valueOf(jSpinner1.getValue()));
    }
    public String text(){
        return jTextField1.getText();
    }
    /**
     * Creates new form LRU_FIFO
     */
    public LRU_v2() {
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
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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

        jLabel2.setText("LRU");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fallos", "Ubicaciones", "Referencias", "Rendimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jLabel3.setText("Ingrese la cadena de referencias.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ValCache() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresar Procesos y Particiones", "Alerta", 1);
            return;
        }
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            jTable2.setValueAt(null, i, 0);
            jTable2.setValueAt(null, i, 1);
        }
         
        jButton1.setEnabled(true);

    }//GEN-LAST:event_jButton1ActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        //jTable1.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        insertarTabla(text(),jTable2);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //String pages[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n", "m"};
        //int frames = 3;
        //LRU_v2 pager = new LRU_v2(pages, frames);

       // pager.lru();
        //pager.print();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LRU_v2().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables


    private Object getEnt() {
     return q.getLast();
    }

    public int getLruFaults() {
        return lruFaults;
    }
}
