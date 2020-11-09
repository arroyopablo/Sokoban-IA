package sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sokoban {

    static int tamano = 7;
    static String tablero[][];
    static String cadenaTablero[] = new String[42];
    static String cadenaPosiciones = "";

    public static boolean contieneComa(String linea) {
        boolean resultado = false;
        int valor = 0;
        valor = linea.indexOf(",");
        if (valor > -1) {
            resultado = true;
        }
        return resultado;
    }

    public static void leerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        FileReader f = new FileReader(rutaArchivo);
        BufferedReader b = new BufferedReader(f);
        String linea=null;
        int caracter = f.read();
        int i = 0;
        while (caracter != -1 && i < 42) {
            if (caracter != 13 && caracter != 10) {
                cadenaTablero[i] = Character.toString((char) caracter);
                caracter = f.read();
                i++;
            } else {
                caracter = f.read();
            }
        }
        while ((linea=b.readLine())!= null){
           if(contieneComa(linea)){
               cadenaPosiciones=cadenaPosiciones+" "+linea;
           }
        }
        b.close();
    }

    public static void llenarTablero(int tam, String[] cade) {
        tablero = new String[tam-1][tam];
        int n = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = cade[n];
                n++;
            }

        }

    }

    public static void verTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        leerArchivo("D:/Descargas/nivel2.txt");
        llenarTablero(tamano, cadenaTablero);
        verTablero();
        System.out.println(cadenaPosiciones);
    }

}
