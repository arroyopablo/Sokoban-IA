/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

public class Nodo{
    
    
    Controlador c;
    
    Nodo padre;
    Nodo nodoarriba;
    Nodo nodoabajo;
    Nodo nodoizq;
    Nodo nododer;
    
    String Tablero[][];
    //pueder  x and y
    int[][] posJugador;
    int[][] posCaja;
    int[][] metas;
    boolean juegoTerminado;
    
    Nodo(Controlador cp,Nodo p){
        c=cp;
        padre=p;
        Tablero=c.Tablero;
        
    }
    
    public void moverArriba(){
        nodoarriba =new Nodo(c,this);
        
        
        //hacer el moviemiento
        //actualizar el juego
        //verificar si termina
        //si queda bloqueado -> retorna null si no se bloquea recursivo lamar a jugar
    }
    
    //"u d i r"
    
    public void jugar(){  
        //pregunto moverArriba?
        //this.moverArriba;
        //moverAbajo?
        //MoverIzq
        //moverDer
    }
    
    
    
    
    
    
    

}
