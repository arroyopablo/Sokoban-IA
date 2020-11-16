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
public class algoritmoBFS {
    String[][] Tablero;
    int[][] TableroNumVisitas;
    int[][] posJugador;
    int[][] posCaja;
    int[][] metas;
    int[][] caja_a_mover;
    boolean juegoTerminado;
    String respuesta = "";
    Controlador control;
    
    public algoritmoBFS(String[][] tablero, int[][] posiciones, int cantidadCajas){
        Tablero = new String[tablero.length][tablero[0].length];
        TableroNumVisitas = new int[tablero.length][tablero[0].length];
        caja_a_mover = new int[1][2];
        
        for(int i=0; i<tablero.length;i++){
            for(int j=0; j<tablero[0].length; j++){
                TableroNumVisitas[i][j] = 0;
            }
        }        
        
        posJugador = new int[1][2];
        posCaja = new int[cantidadCajas-1][2];
        metas = new int[cantidadCajas-1][2];        
        Tablero = tablero;
        
        for(int i=0; i<posiciones.length;i++){
            for(int j=0; j<posiciones[0].length; j++){
                if(i==0){
                    posJugador[i][j] = posiciones[i][j];
                }else{
                    posCaja[i-1][j] = posiciones[i][j];
                }
            }
        }
        control = new Controlador(Tablero, posiciones, cantidadCajas);
    }
        
    public String algoritmoBFS(){
        while(!control.recorrioTodoTablero() && !control.finalJuego()){
            int idCaja = 0;
            if (control.esValido(posJugador[0][0]-1, posJugador[0][1], "U") && control.visitado(posJugador[0][0]-1, posJugador[0][1])<2){
                posJugador[0][0]-=1;
                for(int i=0;i<posCaja.length; i++){
                    if(posJugador[0][0]-1 == posCaja[i][0] && posJugador[0][1] == posCaja[i][1]){
                        caja_a_mover[0][0] =  posCaja[i][0];
                        caja_a_mover[0][1] =  posCaja[i][1];
                        idCaja = i;                        
                        break;
                    }
                }
                posCaja[idCaja][0] = control.moverCaja(posJugador[0][0]-1, posJugador[0][1], "U", caja_a_mover)[0][0];
                posCaja[idCaja][1] = control.moverCaja(posJugador[0][0]-1, posJugador[0][1], "U", caja_a_mover)[0][1];
                Tablero [posCaja[idCaja][0]][posCaja[idCaja][1]] = "C"; 
                control.corregirTablero();
                respuesta += "U";
            }else if (control.esValido(posJugador[0][0]+1, posJugador[0][1], "D") && control.visitado(posJugador[0][0]+1, posJugador[0][1])<2){
                for(int i=0;i<posCaja.length; i++){
                    if(posJugador[0][0]+1 == posCaja[i][0] && posJugador[0][1] == posCaja[i][1]){
                        caja_a_mover[0][0] =  posCaja[i][0];
                        caja_a_mover[0][1] =  posCaja[i][1];
                        idCaja = i;
                        break;
                    }
                }
                posJugador[0][0]+=1;
                posCaja[idCaja][0] = control.moverCaja(posJugador[0][0]+1, posJugador[0][1], "D", caja_a_mover)[0][0];
                posCaja[idCaja][1] = control.moverCaja(posJugador[0][0]+1, posJugador[0][1], "D", caja_a_mover)[0][1];
                Tablero [posCaja[idCaja][0]][posCaja[idCaja][1]] = "C";
                control.corregirTablero();
                respuesta += "D";
            }else if (control.esValido(posJugador[0][0], posJugador[0][1]-1, "L") && control.visitado(posJugador[0][0], posJugador[0][1]-1)<2){
                System.out.print(posJugador[0][0] + "  -  ");
                System.out.print(posJugador[0][0]-1);
                posJugador[0][1]-=1;
                for(int i=0;i<posCaja.length; i++){
                    if(posJugador[0][0] == posCaja[i][0] && posJugador[0][1]-1 == posCaja[i][1]){
                        caja_a_mover[0][0] =  posCaja[i][0];
                        caja_a_mover[0][1] =  posCaja[i][1];
                        idCaja = i;                        
                        break;
                    }
                }
                posCaja[idCaja][0] = control.moverCaja(posJugador[0][0], posJugador[0][1]-1, "L", caja_a_mover)[0][0];
                posCaja[idCaja][1] = control.moverCaja(posJugador[0][0], posJugador[0][1]-1, "L", caja_a_mover)[0][1];
                Tablero [posCaja[idCaja][0]][posCaja[idCaja][1]] = "C";
                control.corregirTablero();
                respuesta += "L";
            }else if (control.esValido(posJugador[0][0], posJugador[0][1]+1, "R") && control.visitado(posJugador[0][0], posJugador[0][1]+1)<2){
                System.out.print(posJugador[0][0] + "  -  ");
                System.out.print(posJugador[0][0]+1);
                posJugador[0][1]+=1;
                for(int i=0;i<posCaja.length; i++){
                    if(posJugador[0][0] == posCaja[i][0] && posJugador[0][1]+1 == posCaja[i][1]){
                        caja_a_mover[0][0] =  posCaja[i][0];
                        caja_a_mover[0][1] =  posCaja[i][1];
                        idCaja = i;                        
                        break;
                    }
                }
                posCaja[idCaja][0] = control.moverCaja(posJugador[0][0], posJugador[0][1]+1, "R", caja_a_mover)[0][0];
                posCaja[idCaja][1] = control.moverCaja(posJugador[0][0], posJugador[0][1]+1, "R", caja_a_mover)[0][1];
                Tablero [posCaja[idCaja][0]][posCaja[idCaja][1]] = "C";
                control.corregirTablero();
                respuesta += "R";
            } else {
                respuesta = "algo";
                break;
            }       
        }
        return respuesta;
    }
            
    
    
}
