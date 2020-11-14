/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Andres A
 */
public class Tableros extends javax.swing.JFrame {

    /**
     * Creates new form Tableros
     */
    public Tableros() {
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

        nivel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jButtonNivel1 = new javax.swing.JButton();
        jButtonNivel2 = new javax.swing.JButton();
        jButtonNivel3 = new javax.swing.JButton();
        jButtonNivel4 = new javax.swing.JButton();
        cerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        nivel1.setBackground(new java.awt.Color(0, 0, 0));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(51, 255, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("SOKOBAN");

        jButtonNivel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonNivel1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNivel1.setText("NIVEL 1");
        jButtonNivel1.setBorderPainted(false);
        jButtonNivel1.setContentAreaFilled(false);
        jButtonNivel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNivel1.setFocusable(false);
        jButtonNivel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNivel1MouseClicked(evt);
            }
        });

        jButtonNivel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonNivel2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNivel2.setText("NIVEL 2");
        jButtonNivel2.setBorderPainted(false);
        jButtonNivel2.setContentAreaFilled(false);
        jButtonNivel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNivel2.setFocusable(false);
        jButtonNivel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNivel2MouseClicked(evt);
            }
        });

        jButtonNivel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonNivel3.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNivel3.setText("NIVEL 3");
        jButtonNivel3.setBorderPainted(false);
        jButtonNivel3.setContentAreaFilled(false);
        jButtonNivel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNivel3.setFocusable(false);
        jButtonNivel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNivel3MouseClicked(evt);
            }
        });

        jButtonNivel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonNivel4.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNivel4.setText("NIVEL 4");
        jButtonNivel4.setBorderPainted(false);
        jButtonNivel4.setContentAreaFilled(false);
        jButtonNivel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNivel4.setFocusable(false);
        jButtonNivel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNivel4MouseClicked(evt);
            }
        });

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit icon.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout nivel1Layout = new javax.swing.GroupLayout(nivel1);
        nivel1.setLayout(nivel1Layout);
        nivel1Layout.setHorizontalGroup(
            nivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nivel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nivel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButtonNivel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(nivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNivel4)
                    .addComponent(jButtonNivel2))
                .addGap(115, 115, 115))
            .addGroup(nivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(nivel1Layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(jButtonNivel1)
                    .addContainerGap(391, Short.MAX_VALUE)))
            .addGroup(nivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nivel1Layout.createSequentialGroup()
                    .addGap(0, 629, Short.MAX_VALUE)
                    .addComponent(cerrar)))
        );
        nivel1Layout.setVerticalGroup(
            nivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nivel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titulo)
                .addGap(82, 82, 82)
                .addComponent(jButtonNivel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(nivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNivel3)
                    .addComponent(jButtonNivel4))
                .addGap(71, 71, 71))
            .addGroup(nivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(nivel1Layout.createSequentialGroup()
                    .addGap(153, 153, 153)
                    .addComponent(jButtonNivel1)
                    .addContainerGap(165, Short.MAX_VALUE)))
            .addGroup(nivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(nivel1Layout.createSequentialGroup()
                    .addComponent(cerrar)
                    .addGap(0, 337, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(nivel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(nivel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNivel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNivel1MouseClicked
        try {
            String rutaNivel1 = "E:\\NetBeans\\Sokoban-IA\\src\\niveles\\nivel1.txt";
            Niveles nivel1 = new Niveles(rutaNivel1, 6, 6, 3);
            nivel1.leerArchivo();
            nivel1.llenarTablero();
            nivel1.llenarPosiciones();
            Controlador c1= new Controlador(nivel1.tablero(), nivel1.posiciones(), 3);
            c1.verTablero();
            c1.verPosJugador();
            c1.verPosCajas();
            
            Nivel1 nivel1UI = new Nivel1(nivel1.tablero(), nivel1.posiciones(), 3);        
            nivel1UI.setVisible(true);
            nivel1UI.setLocationRelativeTo(null);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Tableros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNivel1MouseClicked

    private void jButtonNivel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNivel2MouseClicked
        try {
            String rutaNivel2 = "D:/Descargas/11 SEMESTRE/INTELIGENCIA ARTIFICIAL/Sokoban-IA/src/niveles/nivel2.txt";
            Niveles nivel2 = new Niveles(rutaNivel2, 6, 7, 3);
            nivel2.leerArchivo();
            nivel2.llenarTablero();
            nivel2.llenarPosiciones();
            Controlador c2= new Controlador(nivel2.tablero(), nivel2.posiciones(), 3);
            c2.verTablero();
            c2.verPosJugador();
            c2.verPosCajas();
            
            Nivel2 nivel2UI = new Nivel2(nivel2.tablero(), nivel2.posiciones(), 3);  
            nivel2UI.setVisible(true);
            nivel2UI.setLocationRelativeTo(null);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Tableros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNivel2MouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    private void jButtonNivel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNivel3MouseClicked
        try {
            String rutaNivel3 = "D:/Descargas/11 SEMESTRE/INTELIGENCIA ARTIFICIAL/Sokoban-IA/src/niveles/nivel3.txt";
            Niveles nivel3 = new Niveles(rutaNivel3, 7, 7, 3);
            nivel3.leerArchivo();
            nivel3.llenarTablero();
            nivel3.llenarPosiciones();
            Controlador c3= new Controlador(nivel3.tablero(), nivel3.posiciones(), 3);
            c3.verTablero();
            c3.verPosJugador();
            c3.verPosCajas();
            
            Nivel3 nivel3UI = new Nivel3(nivel3.tablero(), nivel3.posiciones(), 3);  
            nivel3UI.setVisible(true);
            nivel3UI.setLocationRelativeTo(null);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Tableros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNivel3MouseClicked

    private void jButtonNivel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNivel4MouseClicked
        try {
            String rutaNivel4 = "D:/Descargas/11 SEMESTRE/INTELIGENCIA ARTIFICIAL/Sokoban-IA/src/niveles/nivel4.txt";
            Niveles nivel4 = new Niveles(rutaNivel4, 7, 7, 4);
            nivel4.leerArchivo();
            nivel4.llenarTablero();
            nivel4.llenarPosiciones();
            Controlador c4 = new Controlador(nivel4.tablero(), nivel4.posiciones(), 4);
            c4.verTablero();
            c4.verPosJugador();
            c4.verPosCajas();
            
            Nivel4 nivel4UI = new Nivel4(nivel4.tablero(), nivel4.posiciones(), 4);  
            nivel4UI.setVisible(true);
            nivel4UI.setLocationRelativeTo(null);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Tableros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNivel4MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cerrar;
    private javax.swing.JButton jButtonNivel1;
    private javax.swing.JButton jButtonNivel2;
    private javax.swing.JButton jButtonNivel3;
    private javax.swing.JButton jButtonNivel4;
    private javax.swing.JPanel nivel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
