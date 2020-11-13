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
    String[][] posJugador;
    String[][] posCaja;
    
    
    public Controlador(String[][] t, String[][] p, int tamaño){
        Tablero = new String[t.length][t[0].length];
        posJugador = new String[1][2];
        posCaja = new String[tamaño-1][2];
        
        Tablero = t;
        for(int i=0; i<p.length;i++){
            for(int j=0; j<p[0].length; j++){
                if(i==0){
                    posJugador[i][j] = p[i][j];
                }else{
                    posCaja[i-1][j] = p[i][j];
                }
            }
        }            
    }
    
    public void verTablero(){
        for(int i=0; i<Tablero.length;i++){
            for(int j=0; j<Tablero[0].length;j++){
                System.out.print(Tablero[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void verPosJugador(){
        for(int i=0; i<posJugador.length;i++){
            for(int j=0; j<posJugador[0].length;j++){
                System.out.print(posJugador[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void verPosCajas(){
        for(int i=0; i<posCaja.length; i++){
            for(int j=0; j<posCaja[0].length; j++){
                System.out.print(posCaja[i][j]);
            }
            System.out.println("");
        }
    }
    
    public boolean caja(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j].equals("C")) {
                    respuesta = true;
                }
            }
        }
        return respuesta;
    }
    
    public String[][] moverCaja(int fil, int col, String direccion, String[][] posicionCaja){
        //for
        //comprobar arriba, abajo, izquierda, derecha
        
        return posicionCaja;
    }
}
