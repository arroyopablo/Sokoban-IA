/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Pablo Andres A
 */
public class Niveles {
    String rutaArchivo = "";
    int fila;
    int columna;
    String tablero[][] = null;
    String posiciones[][] = null;
    String cadenaTablero[] = null;
    String cadenaPosiciones[] = null;    
    
    public Niveles(String rutaIn, int filaIn, int columnaIn){
        rutaArchivo = rutaIn;
        fila = filaIn;
        columna = columnaIn;  
        cadenaTablero = new String[fila*columna];
        cadenaPosiciones = new String[6];
    }
    
    public boolean contieneComa(String linea) {
        boolean resultado = false;
        int valor = 0;
        valor = linea.indexOf(",");
        if (valor > -1) {
            resultado = true;
        }
        return resultado;
    }

    public void leerArchivo() throws FileNotFoundException, IOException {
        FileReader f = new FileReader(rutaArchivo);
        BufferedReader b = new BufferedReader(f);
        int caracter = f.read();
        int i = 0;
        while (caracter != -1 && i < cadenaTablero.length) {
            if (caracter != 13 && caracter != 10) {
                cadenaTablero[i] = Character.toString((char) caracter);
                caracter = f.read();
                i++;
            } else {
                caracter = f.read();
            }
        }
        
        int caracter2 = f.read();
        int j = 0;
        while (caracter2 != -1 && j < cadenaPosiciones.length) {
            if (caracter2 != 13 && caracter2 != 10 &&caracter2 != 44) {
                cadenaPosiciones[j] = Character.toString((char) caracter2);
                caracter2 = f.read();
                j++;
            } else {
                caracter2 = f.read();
            }
        }
        b.close();
    }

    public void llenarTablero() {
        tablero = new String[fila][columna];
        int n = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = cadenaTablero[n];
                n++;
            }
        }
    }
    
     public void llenarPosiciones() {
        posiciones = new String[3][2];
        int n = 0;
        for (int i = 0; i < posiciones.length; i++) {
            for (int j = 0; j < posiciones[0].length; j++) {
                posiciones[i][j] = cadenaPosiciones[n];
                n++;
            }
        }
    }
    
    public String[][] verTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
        
        return tablero;
    }
    
    public String[][] verCadenaPosiciones(){
        for (int i = 0; i < posiciones.length; i++) {
            for (int j = 0; j < posiciones[0].length; j++) {
                System.out.print(posiciones[i][j]);
            }
            System.out.println("");
        }        
        return posiciones;
    }
    
    public String[][] tableroFinal(){        
        tablero[Integer.parseInt(posiciones[0][0])][Integer.parseInt(posiciones[0][1])]= "P";
        tablero[Integer.parseInt(posiciones[1][0])][Integer.parseInt(posiciones[1][1])]= "C";
        tablero[Integer.parseInt(posiciones[2][0])][Integer.parseInt(posiciones[2][1])]= "C";
        
        return tablero;
    }
}
