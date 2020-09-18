/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author Admin
 */
public class Nodo {    
    
    private int elem;
    private Nodo enlace;
    
    public Nodo(int nElem, Nodo nEnlace){
        elem = nElem;
        enlace = nEnlace;
    }
    
    public Nodo(int elemN){
        elem = elemN;
        enlace = null;
    }
    
    public int getElem(){
        return elem;
    }
    
    public void setElem(int nElem){
        elem = nElem;
    }
    
    public Nodo getEnlace(){
        return enlace;
    }
    
    public void setEnlace(Nodo nEnlace){
        enlace = nEnlace;
    }
}
