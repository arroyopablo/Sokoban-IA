/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

public class NodoDFS{
    
    
    Controlador c;
    
    NodoDFS padre;
    NodoDFS nodoarriba;
    NodoDFS nodoabajo;
    NodoDFS nodoizq;
    NodoDFS nododer;
    
    String Tablero[][];
    //pueder  x and y
    int[][] posJugador;
    int[][] posCaja;
    int[][] metas;
    boolean juegoTerminado;
    String recorrido="";
    
    NodoDFS(Controlador cp,NodoDFS p){
        c=cp;
        padre=p;
        Tablero=c.Tablero;
        
    }
    
    public void moverArriba(){
        nodoarriba =new NodoDFS(c,this);
        //hacer el moviemiento
        recorrido=recorrido+"U";
        //actualizar el juego
        //verificar si termina
        //si queda bloqueado -> retorna null si no se bloquea recursivo lamar a jugar
    }

    public void moverAbajo(){
        nodoabajo =new NodoDFS(c,this);
        
        
        //hacer el moviemiento
        //actualizar el juego
        //verificar si termina
        //si queda bloqueado -> retorna null si no se bloquea recursivo lamar a jugar
    }
    
    public void moverIzquierda(){
        nodoizq =new NodoDFS(c,this);
        //hacer el moviemiento
        //actualizar el juego
        //verificar si termina
        //si queda bloqueado -> retorna null si no se bloquea recursivo lamar a jugar
    }
        public void moverDerecha(){
        nododer =new NodoDFS(c,this);
        
        
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
        //this.moverAbajo
        //MoverIzq
        //moverDer
    }
    
    
    
    
    
    
    

}
