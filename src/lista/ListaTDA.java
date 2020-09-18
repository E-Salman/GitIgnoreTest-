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
public class ListaTDA {
    private Nodo cabecera;
    
    public ListaTDA(){
        cabecera = null;
    }
    
    public boolean insertar(int elemIn, int pos){
        boolean exito = true;                
        
        if(pos < 1 || pos > longitud() + 1) exito = false;
        else{
            if(pos == 1) cabecera = new Nodo(elemIn, cabecera); //Crea una nueva cabecera con el elemento y la enlaza con la vieja
            else{
                Nodo aux = cabecera;
                int i = 1;
                while(i < pos - 1){//Cambiar a 0 y probar
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo newNodo = new Nodo(elemIn, aux.getEnlace());
                aux.setEnlace(newNodo);
            }
        }              
        return exito;
    }
    
    public boolean eliminar(int pos){        
        boolean exito = true;
        
        if(pos < 1 || pos > longitud()) exito = false;
        else{
            if(pos == 1) cabecera = cabecera.getEnlace();
            else{
                Nodo aux = cabecera; //Apuntan al mismo espacio de memoria
                int i = 1;
                while(i < pos - 1){
                    aux = aux.getEnlace(); //El nodo original, cabecera, no se modifica.
                    i++;                    
                }                
                aux.setEnlace(aux.getEnlace().getEnlace()); //Cambia el nodo original, cabecera, en la posicion de aux.
            }
        }
        return exito;
    }         
    
    public int recuperar(int pos){
        Nodo aux = cabecera;
        
        if(!(pos < 1 || pos > longitud())){
            for(int i = 1; i < pos; i++){            
                aux = aux.getEnlace();
            }
        }        
        return aux.getElem();                    
    }
    
    public int localizar(int elemABuscar){
        Nodo aux = cabecera;
        int i = 1;
        boolean encontrado = false;                
        
        do{
            encontrado = (elemABuscar == aux.getElem());
            aux = aux.getEnlace();            
            if(!encontrado) i++;
        }while(!encontrado && i < longitud());
        if (!encontrado) i = -1;
        return i;        
    }
    
    public int longitud() {
        int i = 0;     
        
        if(cabecera != null){
            Nodo aux = cabecera;
            while(aux != null){                
                aux = aux.getEnlace();
                i++;                
            }
        }        
        return i;
    }
    
    public boolean esVacia(){
        return cabecera == null;
    }
    
    public void vaciar(){
        cabecera = null;
    }
    
    public ListaTDA clone(){
        ListaTDA listaClon = new ListaTDA();        
        listaClon.cabecera = recAux(cabecera);
        return listaClon; 
    }

    private Nodo recAux(Nodo cabecera) {
        Nodo aux, rNodo;
        if(cabecera.getEnlace() == null){            
            rNodo = new Nodo(cabecera.getElem());
        }        
        else{
            aux = recAux(cabecera.getEnlace());   
            rNodo = new Nodo(cabecera.getElem(), aux);
        }
        return rNodo;        
    }    
    
    public String toString(){
        String retString = "";
        Nodo aux = cabecera;
        
        while(aux != null){
            retString = retString + aux.getElem() + "\n";            
            aux = aux.getEnlace();
        }
        return retString;
    }
    
    //////////////////////////////////////////////////////////////////////////////// Simulacro Parcial
     
    public void insertarPromedio(){        
        Nodo aux = cabecera;
        int promedio = 0;
        boolean whileCheck = true;
         
        if(!(esVacia())){
            do{
                promedio = aux.getElem() + promedio;
                if(aux.getEnlace() != null) aux = aux.getEnlace();
                else whileCheck = false;
            }while(whileCheck);
  
            promedio = promedio / longitud();
            Nodo newNodo = new Nodo(promedio, null);
            aux.setEnlace(newNodo);
        }
    } //O(n)
     
    public void eliminarApariciones(int x){
        Nodo aux = cabecera;
        boolean primero = true;
         
        if(!(esVacia())){
            do{
                if(primero){                                 
                    if(cabecera.getElem() == x) cabecera = cabecera.getEnlace();
                    else primero = false;
                }                
                 
                else{
                    if(aux.getEnlace().getElem() == x) aux.setEnlace(aux.getEnlace().getEnlace());                        
                    else aux = aux.getEnlace();
                }
            }while(aux.getEnlace() != null);
        }        
    } //O(n)
}
