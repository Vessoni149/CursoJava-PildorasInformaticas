package Colecciones.LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListPrueba2 {

    public static void main(String[] args) {

        LinkedList<String> paises = new LinkedList<String>();

        paises.add("España");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Peru");

        LinkedList<String> capitales = new LinkedList<String>();

        capitales.add("Madrid");
        capitales.add("Bogota");
        capitales.add("Mexico");
        capitales.add("Lima");

        System.out.println(paises);
        System.out.println(capitales);

        //Crearemos un ListIterator para trabajar con la lista
        ListIterator<String> iterA = paises.listIterator();
        ListIterator<String> iterB = capitales.listIterator();

        while(iterB.hasNext()){
            if(iterA.hasNext()){
                iterA.next(); //Salta al siguiente elemento para poder operar sobre el anterior.
            }
            iterA.add(iterB.next());        //agrega un elemento luego del elemento salteado.
        }
        System.out.println(paises);

        iterB = capitales.listIterator();   //con esto vuelve el iterador a su posicion inicial


        while(iterB.hasNext()){             //si hay un elemento siguiente
            iterB.next();                   //saltamos un elemento
            if (iterB.hasNext()){           //si hay otra posicion,
                iterB.next();               //saltamos nuevamente.
                iterB.remove();             //Y eliminamos esa posicion salteada.
            }
        }

        System.out.println(capitales);

        paises.removeAll(capitales);
        System.out.println(paises);
    }
}
