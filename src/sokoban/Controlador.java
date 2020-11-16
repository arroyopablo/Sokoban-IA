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
        tableroInicial();
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
                TableroNumVisitas[fil][col]++;
            } else if (esCaja(Tablero, fil, col) && (esEspacio(Tablero, fil + 1, col) || esMeta(Tablero, fil + 1, col)) && direccion.equals("D")) {
                posicionCaja[0][0] = fil;
                TableroNumVisitas[fil][col]++;
            } else if (esCaja(Tablero, fil, col) && (esEspacio(Tablero, fil, col - 1) || esMeta(Tablero, fil, col - 1)) && direccion.equals("L")) {
                posicionCaja[0][1] = col;
                TableroNumVisitas[fil][col]++;
            } else if (esCaja(Tablero, fil, col) && (esEspacio(Tablero, fil, col + 1) || esMeta(Tablero, fil, col + 1)) && direccion.equals("R")) {
                posicionCaja[0][1] = col;
                TableroNumVisitas[fil][col]++;
            }
            return posicionCaja;
        }
    }
    
    //funcion que verifica a partir de la matriz "TableroNumVisitas" si uns posicion ha sido visitada
    public int visitado(int fila, int col) {
        int numVisitas = TableroNumVisitas[fila][col];
        return numVisitas;
    }
    
    public void tableroInicial() {
        Tablero[posJugador[0][0]][posJugador[0][1]] = "P";
        for(int i=0; i<posCaja.length; i++){            
            Tablero[posCaja[i][0]][posCaja[i][1]] = "C";
        }
        corregirTablero();
    }
    
    public boolean metaEnFila(String[][] tablero, int fila){
        boolean res = false;
        for(int i=0; i<tablero[0].length; i++){
            if(tablero[fila][i].equals("X")){
                res = true;
                break;
            }
        }
        return res;
    }
    
    public boolean metaEnColumna(String[][] tablero, int columna){
        boolean res = false;
        for(int i=0; i<tablero.length; i++){
            if(tablero[i][columna].equals("X")){
                res = true;
                break;
            }
        }
        return res;
    }

    //comprueba si el moviemito desde la fila y col es valido para la dirección
    public boolean esValido(int fil, int col, String direccion){
        boolean respuesta = true;
        if (Tablero[fil][col].equals("W") || fil <= 0 || fil>=Tablero.length || col <= 0 || col >= Tablero[0].length){
            return false;
        }
        
        switch(direccion){
            case "U":
                if(esCaja(Tablero, fil, col)){
                    //Ariba hay muro
                    if(esMuro(Tablero, fil - 1, col)){respuesta = false; break;}
                    //Arriba hay una caja
                    if(esCaja(Tablero, fil - 1,col)){respuesta = false; break;}
                    //verificar diagonales y rincones
                    if(fil-2>=0 && col-1>=0 && col+1<Tablero[0].length){
                        //Diagonal superior izquieda hay un muro, 2 posiciones arriba es muro y no contiene la meta la fila superior
                        if(esMuro(Tablero, fil - 1, col - 1) && esMuro(Tablero,fil - 2,col) && !metaEnFila(Tablero, fil-1)){respuesta = false; break;}
                        //Diagonal superior derecha hay un muro, 2 posiciones arriba es muro y no es meta la meta la fila superior
                        if(esMuro(Tablero, fil - 1, col + 1) && esMuro(Tablero, fil - 2, col) && !metaEnFila(Tablero, fil-1)){respuesta = false; break;}
                        
                    }
                }else{
                    respuesta = true;
                }
                break;
            case "D":
                if(esCaja(Tablero, fil, col)){
                    //Abajo hay muro
                    if(esMuro(Tablero, fil + 1, col)){respuesta = false; break;}
                    //Abajo hay una caja
                    if(esCaja(Tablero, fil + 1, col)){respuesta = false; break;}
                    //verificar diagonales y rincones
                    if(fil+2<Tablero.length && col-1>=0 && col+1<Tablero[0].length){
                        //Diagonal inferior izquierda hay un muro, 2 posiciones abajo es muro y no contiene la meta la fila inferior
                        if(esMuro(Tablero, fil + 1, col - 1) && esMuro(Tablero, fil + 2, col) && !metaEnFila(Tablero, fil+1)){respuesta = false; break;}
                        //Diagonal inferior derecha hay un muro, 2 posiciones abajo es muro y no es meta la meta la fila inferior
                        if(esMuro(Tablero, fil + 1, col + 1) && esMuro(Tablero, fil + 2, col) && !metaEnFila(Tablero, fil+1)){respuesta = false; break;}                        
                    }
                }else{
                    respuesta = true;
                }
                break;
            case "L":
                if(esCaja(Tablero, fil, col)){
                    //Izquierda hay muro
                    if(esMuro(Tablero, fil, col-1)){respuesta = false; break;}
                    //Izquierda hay una caja
                    if(esCaja(Tablero, fil, col-1)){respuesta = false; break;}
                    //verificar diagonales y rincones
                    if(col-2>=0 && fil-1>=0 && fil+1<Tablero.length){
                        //Diagonal inferior izquierda hay un muro, 2 posiciones a la izquierda es muro y no contiene la meta la columna de la izquieda
                        if(esMuro(Tablero, fil + 1, col - 1) && esMuro(Tablero, fil, col-2) && !metaEnColumna(Tablero, col-1)){respuesta = false; break;}
                        //Diagonal superior izquierda hay un muro, 2 posiciones a la izquierda es muro y no meta la columna izquierda
                        if(esMuro(Tablero, fil - 1, col - 1) && esMuro(Tablero, fil, col-2) && !metaEnColumna(Tablero, col-1)){respuesta = false; break;}                        
                    }
                }else{
                    respuesta = true;
                }
                break;
            case "R":
                if(esCaja(Tablero, fil, col)){
                    //Derecha hay muro
                    if(esMuro(Tablero, fil, col+1)){respuesta = false; break;}
                    //Derecha hay una caja
                    if(esCaja(Tablero, fil, col+1)){respuesta = false; break;}
                    //verificar diagonales y rincones
                    if(col+2<Tablero[0].length && fil-1>=0 && fil+1<Tablero.length){
                        //Diagonal inferior derecha hay un muro, 2 posiciones a la derecha es muro y no contiene la meta la columna de la derecha
                        if(esMuro(Tablero, fil + 1, col + 1) && esMuro(Tablero, fil, col+2) && !metaEnColumna(Tablero, col+1)){respuesta = false; break;}
                        //Diagonal superior derecga hay un muro, 2 posiciones a la derecha es muro y no meta la columna derecha
                        if(esMuro(Tablero, fil - 1, col + 1) && esMuro(Tablero, fil, col+2) && !metaEnColumna(Tablero, col+1)){respuesta = false; break;}                        
                    }
                }else{
                    respuesta = true;
                }
                break;
        }
        return respuesta;
    }      
    
    public int cantidaLograda() {
        int logrado = 0;
        for (int i = 0; i < metas.length; i++) {
            if (Tablero[metas[i][0]][metas[i][1]].equals("C")) {
                logrado++;
            }
        }

        return logrado;
    }

    public boolean finalJuego() {
        if (cantidaLograda() == metas.length) {
            return true;
        } else {
            return false;
        }
    }
    
    public void corregirTablero(){
        for (int i = 0; i < metas.length; i++) {
            for (int j = 0; j < metas[0].length-1; j++) {
                if(Tablero[metas[i][j]][metas[i][j+1]].equals("0")){
                    Tablero[metas[i][j]][metas[i][j+1]] = "X";
                }
            }
        }
    }
    
    public int cantidadCasillasRecorridas(){
        int total = 0;
        for(int i=0; i<TableroNumVisitas.length; i++){
            for(int j=0; j<TableroNumVisitas[0].length; j++){
                if(TableroNumVisitas[i][j]!=0){
                    total += 1;
                }
            }
        }
        return total;
    }
    
    public boolean recorrioTodoTablero(){
        if(cantidadCasillasRecorridas() == TableroNumVisitas.length*TableroNumVisitas[0].length){
            return true;
        }else{
            return false;
        }
    }
}
