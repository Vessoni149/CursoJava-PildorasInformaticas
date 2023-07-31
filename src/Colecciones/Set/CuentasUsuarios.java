package Colecciones.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuarios {


    public static void main(String[] args) {
        Cliente cl1 = new Cliente("Antonio", "00001", 200000);
        Cliente cl2 = new Cliente("Rafael", "00002", 250000);
        Cliente cl3 = new Cliente("Penelope", "00003", 300000);
        Cliente cl4 = new Cliente("Julio", "00004", 500000);
        //Supuestamente set no permite elementos duplicados pero como emos en ppio no marca error si intanciamos un objeto igual a otro
        Cliente cl5 = new Cliente("Julio", "00004", 500000);

        //Creando la coleccion:
        //Para elegirla tendremos en cuenta:
        //No se van a repetir clientes? NO
        //Haremos operaciones de agregar o borrar?
        //seran operaciones de solo lectura?
        //Necesitaremos ordenar los Clientes? Por ahora no

        //Usaremos la interfaz Set, especificamente la clase HashSet
        //Set admite un tipo de dato genetico
        Set<Cliente> clientesBanco = new HashSet<Cliente>();

        //Ahora para agregar clientes hay que ver que metodos tiene Set
        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        clientesBanco.add(cl5); //Supuestamente el metodo add deberia filtrar a los elementos repetidos. Pero para que eso suceda hay que usar el metodo hashCode()
        //hashCode:
        //Primero hay que recordar como funciona la memoria interna Stack, osea la memoria de acceso rapido y la memoria  Heap de acceso lento.
        //Cuando almacenamos en una variable un tipo de dato primitivo se almacena en Stack
        //Cuando instanciamos un objeto ( Cliente cl4 = new Cliente ) lo primero que se lee es new Cliente(),  se reservara un espacio para almacenar los objetos en la memoria Heap.
        //Una vez hecho eso, continua la lectura y lee Cliente cl4, el nombre de la instnacia, si se almacenara en la memoria stack. Y se crea una referencia al objeto que esta en la memoria steak.
        //si creamos una segunda instancia vuelve a suceder el mismo proceso, incluyendo el de la memoria heap.
        //El hashCode es un numero que hace referencia a la localizacion del objeto que tenemos almacenado en la memoria heap.
        //Entonces usando por ej decimos instancia1 = intancia2 estamos cambiando las referencias a la memoria heap, ahora ambas instancias van apuntar desde 2 isntancias diferentes al mismo lugar de la memoria heap.

        //El metodo equals no sirve para discernir si una instancia de un objeto creado por nosotros el igual a otra instancia de un objeto tmb creado x nosotros. Porque la clave para saber si se trata del mismo objeto es si éste tiene el mismo codigo.
        //Pero eso el metodo equals no lo sabe, porque éste puede discernir si 2 objetos de la clase String  o de la clase Date son iguales, porque String y Date son lcases predefinidas de Java. Pero no puede discernir entre 2 objetos de clases que cree yo, porque no sabe como estan constridas por dentro esas clases.
        //Para que el metodo equals nos sea util tenemos que sobreescribirlo.

        //El metodo hashCode nos da la posicion de un objeto en la memoria heap de una clase predefinida por java, pero no de un objeto instanciado a partir de una clase creada por mi.
        //Entonces tmb habra que sobreescribir el metodo para que sea util en las colecciones con objetos de clases creadas x mi
        //Como es muy comun sobreescriir estos metodos, los editores de codigo nos dan la opcion de sobreescribirlo por nosotros.
        //Si sobreescribimos 1 hay que sobreescribir el otro.
        //cuando se sobreescribe haschode suele retornar un nuemro de 2 sifras para simplificar el codigo hash que suele tener muchas cifras.
        //Al sobreescribir equals vamos a tener que tener en cuenta que parametro será el que diferencie a los objetos.
        //Los metodos son sobreescritos en la clase Cliente
//Ahora si detecta que hay 2 instancias iguales. Para comprovar esto podemos comentar las lineas en las que sobreescribimso los 2 metodos en la clase Clientes y ver que no las va a considerar iguales.
        //Ahora recorreremos la coleccion:

        for (Cliente cliente: clientesBanco) {
            System.out.println(cliente.getNombre() + " " + cliente.getN_cuenta() + " " + cliente.getSaldo());
        }

        //Para recorrer una coleccion ademas del bucle for each (q es mas nuevo) hay que usar la interfaz "Iterable"  que recibe un parametro generico <T>. Lo que ahce es construir un objeto iterador que recorra elementos, sin importar el tipo de objeto que tenga la coleccion
        //La i collection hereda de la i Iterable, que tiene un unico metodo iterator() que devuelve un objeto iterador. Ese objeto es de la interfaz iterator, que tiene los sgts metodos:
        //Metodos:
        // next: salta al siguiente elemento de la coleccion y examina el objeto que se acao de pasar Lanza una excepcion cuando ya no hay mas elementtos para saltar
        //hasNext: devuelve T o F si hay o no un eleemnto siguiente ne la coleccion,
        //Usando estos 2 metodos se recorre sin problemas para que no salte excepcion.
        //remove: elimina objetos de la coleccion.

        // referenciamos la interfaz Iterator, q sera de tipo Cliente, se le da el nombre de it, y es igual al objeto que retorna el metodo iterator() aplicado a la coleccion clientesBanco
        Iterator<Cliente> it = clientesBanco.iterator();

        while(it.hasNext()){    //mientras haya elementos que recorrer:
            String nombre_cliente = it.next().getNombre(); //next es el metodo para examinar elementos ya iterados.
            System.out.println(nombre_cliente);
            String n_cuenta = it.next().getN_cuenta();      //Como next pasa a otra posicion, con el primer next pasamos a la segunda posicion para analizar la 1. Si lo usamos de nuevo saltamos a la 3 para analizar la 2.
            System.out.println(n_cuenta);
            //Entonces para este tipo de operaciones es mejor usar for each, xq seria mas complejo usar iterator.
            //Pero x ej si quisieramos eliminar un elemento en un bucle for each no podriamso porque se lanza la excepcion ConcurrentModificationException, que nos dice que no podemos eliminar un objeto de una coleccion a la vez que lo recorremos.
            //Con iterator si se podria.
            if(nombre_cliente.equals("Penelope")){
                it.remove();
                System.out.println("Peneloepe eliminada");
            }

            for (Cliente cliente: clientesBanco) {
                System.out.println(cliente.getNombre() + " " + cliente.getN_cuenta() + " " + cliente.getSaldo());
            }
        }
    }



}
