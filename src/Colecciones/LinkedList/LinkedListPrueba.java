package Colecciones.LinkedList;
import java.util.*;
public class LinkedListPrueba {
    //LinkedList es hermana de ArrayList, ambas implementan la interfaz List, que implementa a su vez a Collection
    //Estan ordenadas. podemos añadir y eliminar sin restriccion, existe un listIterator que puede modificar la lista en cualquier direccion.

    //La dif con ArrayList es la eficiencia.
    //El arrayList guarda los datos en posiciones adyacentes de la memoria. Estan pegados entre si. Si queremos eliminar elementos, estamos obligados a cubrir el espacio en memoria que dejamos libre, moviendo los otros elementos. Esto implica mucho recurso, por lo que es poco eficiente.
    //un linkedList almacena la info en un nodo, que consta de 3 partes, la data, y las 2 referencias que apuntan al elemento anterior y al siguiente. Gracias a estas referencias no tienen que estar los datos guardados de manera adyacente en la memoria. Lo que quiere decir que si eliminamos algun elemento no vamos a tener que mover los elementos restantes.Lo unico que hay que hacer al eliminar es actualizar los enlaces de los nodos, que es menos costoso que lo que hace el arrayList. Lo mismo sucede con mover los elementos, no importa el lugar o posicion, sino su referencia.
    //En sintesis es mejor usar LinkeList para eliminar y move elementos.

    // Metodos:
    //add: agrega al final de la lista.
    //add con 2 argumentos: permite agregar en posicion especificada
    //remove, removeFirst, removeLast, size (p ver tamaño).
    public static void main(String[] args) {

        LinkedList<String> personas = new LinkedList<String>();
        personas.add("Pepe");
        personas.add("Sandra");
        personas.add("Ana");
        personas.add("Laura");
        personas.add(2, "Juan");
        System.out.println(personas.size());



        for (String persona: personas) {
            System.out.println(persona);
        }
        //otra foram de recorrer una linkedList es con la interface ListIterator, que tiene metodos para movernos al siguiente, anterior, eliminar elemneto, etc.

    }

}
