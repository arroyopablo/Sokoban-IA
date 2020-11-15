/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

public class Controlador {
    String[][] Tablero;
    int[][] TableroNumVisitas;
    int[][] posJugador;
    int[][] posCaja;
    int[][] metas;
    boolean juegoTerminado;
    
    
    
    
    public Controlador(String[][] t, int[][] p, int tamaño){
        Tablero = new String[t.length][t[0].length];
        TableroNumVisitas = new int[t.length][t[0].length];
        
        for(int i=0; i<t.length;i++){
            for(int j=0; j<t[0].length; j++){
                TableroNumVisitas[i][j] = 0;
            }
        }        
        
        posJugador = new int[1][2];
        posCaja = new int[tamaño-1][2];
        metas = new int[tamaño-1][2];        
        Tablero = t;
        encontraMetas(Tablero);
        juegoTerminado = false;
        
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
    
    public int[][] encontraMetas(String[][] tablero){
        int posMetaX = 0;
        int posMetaY = 0;
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length-1; j++) {
                if(tablero[i][j].equals("X")){
                    metas[posMetaX][posMetaY] = i;
                    metas[posMetaX][posMetaY + 1] = j;
                    posMetaX++;
                }
            }
        }
        return metas;
    }
    
    public void verTablero(){
        for(int i=0; i<Tablero.length;i++){
            for(int j=0; j<Tablero[0].length;j++){
                System.out.print(Tablero[i][j]);
            }
            System.out.println("");
        }
    }

    public void verPosJugador() {
        for (int i = 0; i < posJugador.length; i++) {
            for (int j = 0; j < posJugador[0].length; j++) {
                System.out.print(posJugador[i][j]);
            }
            System.out.println("");
        }
    }

    public void verPosCajas() {
        for (int i = 0; i < posCaja.length; i++) {
            for (int j = 0; j < posCaja[0].length; j++) {
                System.out.print(posCaja[i][j]);
            }
            System.out.println("");
        }
    }

    //Retorna falso o verdadero si en la posición (fil,col) hay un espacio
    public boolean esEspacio(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        if (tablero[fil][col].equals("0")) {
            respuesta = true;
        }
        return respuesta;
    }
    //Retorna falso o verdadero si en la posición (fil,col) es meta 

    public boolean esMeta(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        if (tablero[fil][col].equals("X")) {
            respuesta = true;
        }
        return respuesta;
    }

    //Retorna falso o verdadero si en la posición (fil,col) hay un muro
    public boolean esMuro(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        if (tablero[fil][col].equals("W")) {
            respuesta = true;
        }
        return respuesta;
    }

    //Retorna falso o verdadero si en la posición (fil,col) hay una caja
    public boolean esCaja(String[][] tablero, int fil, int col) {
        boolean respuesta = false;
        if (tablero[fil][col].equals("C")) {
            respuesta = true;
        }
        return respuesta;
    }

    public int[][] moverCaja(int fil, int col, String direccion, int[][] posicionCaja) {
        if (!esCaja(Tablero, fil, col)) {
            return posicionCaja;
        } else {
            if (esCaja(Tablero, fil, col) && (esEspacio(Tablero, fil - 1, col) || esMeta(Tablero, fil - 1, col)) && direccion.equals("U")) {
                posicionCaja[0][0] = fil;
            } else if (esCaja(Tablero, fil, col) && (esEspacio(Tablero, fil + 1, col) || esMeta(Tablero, fil + 1, col)) && direccion.equals("D")) {
                posicionCaja[0][0] = fil;
            } else if (esCaja(Tablero, fil, col) && (esEspacio(Tablero, fil, col - 1) || esMeta(Tablero, fil, col - 1)) && direccion.equals("L")) {
                posicionCaja[0][1] = col;
            } else if (esCaja(Tablero, fil, col) && (esEspacio(Tablero, fil, col + 1) || esMeta(Tablero, fil, col + 1)) && direccion.equals("R")) {
                posicionCaja[0][1] = col;
            }
            return posicionCaja;
        }
    }
    
    //funcion que verifica a partir de la matriz "TableroNumVisitas" si uns posicion ha sido visitada
    public boolean visitado(int fila, int cola){
        boolean comprobacion= false;
        
        //codigo aqui...
        //if(TableroNumVisitas[fila][cola] == 0){
        //  boolean false;    
        //}else{
        //  boolean true;
        //}
        
        return comprobacion;
    }
    

    //comprueba si el moviemito desde la fila y col es valido para la dirección
    public boolean esValido(int fil, int col, String direccion){
        boolean respuesta = true;      
        switch(direccion){
            case "U":
                //Ariba hay muro
                if(Tablero[fil - 1][col].equals("W")){return false;}
                //Ariiba hay dos cajas seguidas
                if(Tablero[fil - 1][col].equals("C")&&Tablero[fil - 2][col].equals("C")){return false;}
                //Arriba hay una caja seguida de un muro
                if(Tablero[fil - 1][col].equals("C")&&Tablero[fil - 2][col].equals("W")){return false;}
                break;
            case "D":
                //Abajo hay muro
                if(Tablero[fil + 1][col].equals("W")){return false;}
                //Ariiba hay dos cajas seguidas
                if(Tablero[fil + 1][col].equals("C")&&Tablero[fil + 2][col].equals("C")){return false;}
                //Arriba hay una caja seguida de un muro
                if(Tablero[fil + 1][col].equals("C")&&Tablero[fil + 2][col].equals("W")){return false;}
                break;
            case "L":
                //Izquierda hay muro
                if(Tablero[fil][col-1].equals("W")){return false;}
                //Izquierda hay dos cajas seguidas
                if(Tablero[fil][col-1].equals("C")&&Tablero[fil - 2][col].equals("C")){return false;}
                //Izquierda hay una caja seguida de un muro
                if(Tablero[fil][col-1].equals("C")&&Tablero[fil - 2][col].equals("W")){return false;}
                break;
            case "R":
                //Derecha hay muro
                if(Tablero[fil][col+1].equals("W")){return false;}
                //Derecha hay dos cajas seguidas
                if(Tablero[fil][col+1].equals("C")&&Tablero[fil + 2][col].equals("C")){return false;}
                //Derecha hay una caja seguida de un muro
                if(Tablero[fil][col+1].equals("C")&&Tablero[fil + 2][col].equals("W")){return false;}
                //cuando es rincon 
                //if(Tablero[fil][col+2].equals("W")&&Tablero[fil - ][col].equals("W")){return false;}
                break;
        }
        return respuesta;
    }
        
 
    //Esta la estoy haciendo yo___________________________________________________
    /*public boolean validarMovimiento(int fil, int col, String direccion){
        boolean respuesta = false;
        if (Tablero[fil][col].equals("W")) {
            return false;
        }

        if (direccion.equals("U")){
            if (esCaja(nodeBoxPos, fil, col)){
                if (esCaja(nodeBoxPos, fil - 1, col)){
                    return false;
                }

                if (Tablero[fil - 1][col].equals("W")){
                    return false;
                }

                if (Tablero[fil - 2][col].equals("W") && Tablero[fil - 1][col - 1].equals("W") && Tablero[]){
                    if (goals.__contains__([fil - 1, col])):
                        return false;
                }

                if (Tablero[fil - 2][col] == 'W' and Tablero[fil - 1][col + 1] == 'W'):
                    if not (goals.__contains__([fil - 1, col])):
                        return false;

            return true;
            }

        if direccion == 'D':
            if esCaja(nodeBoxPos, fil, col):
                if esCaja(nodeBoxPos, fil + 1, col):
                    return false;

                if Tablero[fil + 1][col] == 'W':
                    return false;

                if (Tablero[fil + 2][col] == 'W' and Tablero[fil + 1][col - 1] == 'W'):
                    if not (goals.__contains__([fil+1,col])):
                        return false;

                if (Tablero[fil + 2][col] == 'W' and Tablero[fil + 1][col + 1] == 'W'):
                    if not (goals.__contains__([fil + 1, col])):
                        return false;

            return true;

        if direccion == 'R':
            if esCaja(nodeBoxPos, fil, col): 
                if esCaja(nodeBoxPos, fil, col + 1):
                    return false;

                if Tablero[fil][col + 1] == 'W':
                    return false;

                if (Tablero[fil][col + 2] == 'W' and Tablero[fil + 1][col + 1] == 'W'):
                    if not (goals.__contains__([fil, col + 1])):
                        return false;

                if (Tablero[fil][col + 2] == 'W' and Tablero[fil - 1][col + 1] == 'W'):
                    if not (goals.__contains__([fil, col + 1])):
                        return false;

            return true;

        if direccion == 'L':
            if esCaja(nodeBoxPos, fil, col):
                if esCaja(nodeBoxPos, fil, col - 1):
                    return false;

                if Tablero[fil][col - 1] == 'W':
                    return false;

                if (Tablero[fil][col - 2] == 'W' and Tablero[fil + 1][col - 1] == 'W'):
                    if not (goals.__contains__([fil,col - 1])):
                        return false;

                if (Tablero[fil][col - 2] == 'W' and Tablero[fil - 1][col - 1] == 'W'):
                    if not (goals.__contains__([fil, col - 1])):
                        return false;

            return true;
    }*/
    
    public boolean finalJuego(String[][] tablero) {
        int logrado = 0;
        for (int i = 0; i <= metas.length; i++) {
            if (logrado == metas.length) {
                juegoTerminado = true;
            } else if (tablero[metas[i][0]][metas[i][1]].equals("C") && i < metas.length) {
                logrado++;
            } else {
                juegoTerminado = false;
            }
        }
        return juegoTerminado;
    }
}
