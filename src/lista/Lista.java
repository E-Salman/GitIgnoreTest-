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
public class Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaTDA list = new ListaTDA(), listClonada;        
        list.insertar(11, 1);
        list.insertar(22, 2);
        list.insertar(33, 3);
        list.insertar(44, 4);
        listClonada = list.clone();
        list.eliminar(3);
        int x = list.longitud();
        x = list.localizar(44);
        x = list.recuperar(4);
        list.vaciar();
        boolean ugu = list.esVacia();
        x = list.longitud();
        System.out.println(listClonada.toString());
    }    
}
