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
    int[][] posJugador;
    int[][] posCaja;
    
    
    public Controlador(String[][] t, int[][] p, int tamaño){
        Tablero = new String[t.length][t[0].length];
        posJugador = new int[1][2];
        posCaja = new int[tamaño-1][2];
        
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
    
     //Retorna falso o verdadero si en la posición (fil,col) hay un espacio
     public boolean esEspacio(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        if (tablero[fil][col].equals("0")){
            respuesta = true;}
        return respuesta;
    }
     //Retorna falso o verdadero si en la posición (fil,col) es meta 
    public boolean esMeta(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        if (tablero[fil][col].equals("X")){
            respuesta = true;}
        return respuesta;
    }
    //Retorna falso o verdadero si en la posición (fil,col) hay un muro
    public boolean esMuro(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        if (tablero[fil][col].equals("W")){
            respuesta = true;}
        return respuesta;
    }
    //Retorna falso o verdadero si en la posición (fil,col) hay una caja
    public boolean esCaja(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        if (tablero[fil][col].equals("C")){
            respuesta = true;}
        return respuesta;
    }
    
    /*public String[][] moverCaja(int fil, int col, String direccion, int[][] posicionCaja){
        
        if (!esCaja(Tablero, fil, col)){
            return posicionCaja;
        }else{
            for (int i = 0; i<posicionCaja.length; i++){
                if (esCaja(Tablero, fil, col) && (esEspacio(Tablero, fil-1, col) || esMeta(Tablero, fil-1, col)) && direccion.equals("U")) {
                            Tablero[fil+1][col] = "0";
                            posicionCaja[i][0] = posicionCaja[i][0] - 1;
                            Tablero[posX][posY] = "P";
                            Tablero[posX - 1][posY] = "C";
                            actualizarTablero(corregirTablero(Tablero));
                            gano(corregirTablero(Tablero));
                }

                if (box[0] == row && box[1] == column && direction == 'D'){
                    posicionCaja.remove(box)
                    posicionCaja.append([row + 1,column])
                    return posicionCaja;
                }

                if (box[0] == row && box[1] == column && direction == 'L'){
                    posicionCaja.remove(box)
                    posicionCaja.append([row,column - 1])
                    return posicionCaja;
                }

                if (box[0] == row && box[1] == column && direction == 'R'){
                    posicionCaja.remove(box)
                    posicionCaja.append([row, column + 1])
                    return posicionCaja;
                }
            }
        }
    }*/
}
