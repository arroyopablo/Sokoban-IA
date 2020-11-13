/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author Pablo Andres A
 */
public class Controlador {
    String[][] Tablero;
    String[][] pos;
    
    
    public Controlador(String[][] t, String[][] p, int tamaño){
        Tablero = new String[t.length][t[0].length];
        pos = new String[tamaño][2];
        
        Tablero = t;
        pos = p;
    }
    
    public void verTablero(){
        for(int i=0; i<Tablero.length;i++){
            for(int j=0; j<Tablero[0].length;j++){
                System.out.print(Tablero[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void verPos(){
        for(int i=0; i<pos.length;i++){
            for(int j=0; j<pos[0].length;j++){
                System.out.print(pos[i][j]);
            }
            System.out.println("");
        }
    }
}
