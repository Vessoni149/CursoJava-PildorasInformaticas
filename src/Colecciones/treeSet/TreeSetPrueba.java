package Colecciones.treeSet;
//implementa la interfaz Set.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetPrueba {
    //no permite elementos duplicados
    //No permiten el acceso aleatorio a los elementos.
    //Poca eficiencia a la hora de ordenar elementos. Y no siempre se puede. En el caso de TreeSet si se pueden ordenar.

    public static void main(String[] args) {
        TreeSet<String> ordenaPersonas = new TreeSet<String>();
        ordenaPersonas.add("Sandra");
        ordenaPersonas.add("Amanda");
        ordenaPersonas.add("Diana");

        for (String s: ordenaPersonas) {
            System.out.println(s);      //veremos que no los devuelve ordenados como los creamos, sino que alfabeticamente por ser sus elementos de tipo String. La clase String implementa Comparable que tiene el metodo compareTo().
            //TreeSet usa la interfaz del tipo de objeto que almacena en su interior para comparar esos objetos e si y a partir de ahi ordenarlos.


        }


        //Si creamos un treeset de objetos creados por mi, lo que tendriamos que hacer es, que la clase que cosntruye mis objetos implemente la interfaz Comparable y usar el metodo compareTo para que tambien las ordene de esa forma.
        Articulo primero = new Articulo(1, "preimer artiulo");
        Articulo segundo = new Articulo(20, "segundo artiulo");
        Articulo tercero = new Articulo(3, "tercer artiulo");

        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(segundo);
        for (Articulo art: ordenaArticulos){
            System.out.println(art.getDescripcion());
        }

        //Si queremos otro criterio de ordenacion que no sea numerico, sino ordenarlos por su descripcion
        //TreeSet tieen un constructor que permite pasar por parametro un objeto de tipo Comparator, que construye un nuevo y vacio arbol ordenado de acuerdo con el comparador especificado
        //Comparator es una interfaz que permite un generico como argumento, y tiene un metodo compare(), que compara 2 argumentos en orden. Funciona igual que compareTo() pero permite 2 parametros.
        //Entonces hay que implementar en la clase de la que vamos a crear objetos, la interface Comparator y sobreescribir el metodo compare()

        Articulo comparadorArticulos = new Articulo();
        TreeSet <Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos);
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);
        ordenaArticulos2.add(tercero);
        for (Articulo art: ordenaArticulos2){
            System.out.println(art.getDescripcion());
        }
    }
}


class Articulo implements Comparable<Articulo>, Comparator<Articulo> {
    public Articulo(){

    }
    private int numero_articulo;
    private String descripcion;
    public Articulo(int num, String desc){
        numero_articulo = num;
        descripcion = desc;
    }

    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public int compareTo(Articulo o) {      //Permite un solo parametro
        return numero_articulo - o.numero_articulo;     //compara el n de articulo de un objeto con el numero del articulo parado por parametro.

    }

    @Override
    public int compare(Articulo o1, Articulo o2) {      //Permite 2 parametros
        String descripcionA = o1.getDescripcion();
        String  descripcionB = o2.getDescripcion();
        return descripcionA.compareTo(descripcionB);
    }
}