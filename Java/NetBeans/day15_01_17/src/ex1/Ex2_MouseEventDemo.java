/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.locale.StringTokenIterator;


/**
 *
 * @author younghoonkim
 */
public class Ex2_MouseEventDemo extends javax.swing.JFrame {

     private int arcNum=360;
    private int x=100,y=100;
    private int r=50;
    private Color col=Color.CYAN;
    private int token;
    
    private Socket s;
    private Socket s2;
    private PrintWriter pw;
    /**
     * Creates new form Ex2_MouseEventDemo
     */
    public Ex2_MouseEventDemo() {
         try {
            initComponents();
            //connect to server!
            s=new Socket("localhost",9999);
            pw=new PrintWriter(s.getOutputStream(),true);
        } catch (IOException ex) {
            Logger.getLogger(Ex1_ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    BufferedReader br=new BufferedReader
                (new InputStreamReader(s.getInputStream()));
                    while(true){
                        //target.append(br.readLine()+"\n");
                        StringTokenizer st=new StringTokenizer(br.readLine(),":");
                        
                        x=Integer.parseInt(st.nextToken());
                        y=Integer.parseInt(st.nextToken());
                        col = new Color(Integer.parseInt(st.nextToken()), true);
                        canvas2.repaint();
                        
                    }
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } catch (IOException ex) {
                    Logger.getLogger(Ex1_ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }).start();
        
//        new Thread(new Runnable(){
//
//            @Override
//            public void run() {
//                try {
//                    BufferedReader br=new BufferedReader
//                (new InputStreamReader(s2.getInputStream()));
//                    while(true){
//                        //target.append(br.readLine()+"\n");
//                        StringTokenizer st=new StringTokenizer(br.readLine(),":");
//                        
//                        x=Integer.parseInt(st.nextToken());
//                        y=Integer.parseInt(st.nextToken());
//                        col = new Color(Integer.parseInt(st.nextToken()), true);
//                        canvas2.repaint();
//                        
//                    }
//                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                } catch (IOException ex) {
//                    Logger.getLogger(Ex1_ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            
//        }).start();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chColor = new javax.swing.JComboBox();
        canvas2 = new java.awt.Canvas(){
            @Override
            public void update(Graphics g) {
                paint(g);
            }

            @Override
            public void paint(Graphics g) {
                g.setColor(col);
                g.fillOval(x, y, r, r);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        chColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-select-", "RED", "BLUE", "BLACK", "YELLOW", "ORANGE", " " }));
        chColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chColorActionPerformed(evt);
            }
        });

        canvas2.setBackground(new java.awt.Color(255, 255, 255));
        canvas2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvas2MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canvas2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas2MouseDragged
        // TODO add your handling code here:
        x=evt.getX();
        y=evt.getY();
        canvas2.repaint();
        
        pw.println(x+":"+y+":"+Integer.toString(col.getRGB()));
        pw.flush();
    }//GEN-LAST:event_canvas2MouseDragged

    private void chColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chColorActionPerformed
        // TODO add your handling code here:
        try{
        String items=(String) chColor.getSelectedItem();
        col = (Color)Color.class.getField(items).get(null);
        }catch(Exception e){
            col=null;
        }
    }//GEN-LAST:event_chColorActionPerformed

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
            java.util.logging.Logger.getLogger(Ex2_MouseEventDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex2_MouseEventDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex2_MouseEventDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex2_MouseEventDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex2_MouseEventDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas2;
    private javax.swing.JComboBox chColor;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
