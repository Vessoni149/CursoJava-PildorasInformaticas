package ProgramaionGenerica.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado1 {
    public static void main(String[] args) {
        //Array normal:
      /*  Empleado listaEmpleados[] = new Empleado[3];
        listaEmpleados[0] = new Empleado("Pedro", 25, 57000);
        listaEmpleados[1] = new Empleado("Ana",25,60000);
        listaEmpleados[2] = new Empleado("Luis",46,70000);
        for(Empleado e: listaEmpleados){
            System.out.println(e.dameDatos());
        }*/

        //ArrayList:
        //Los arrays tienen el problema de que tienen un numero de elementos definidos.
        //Para solucionar esto existen los ArrayList, que tienen un tamaño dinamico.
        //Entre <> especificamos el tipo de dato que guardata ese arrayList. A dif de un array normal, no pueden guardar tipos de datos primitivos (salvo que usemos una clase envoltorio, que se vera despues), solo pueden guardar objetos.
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        //Para agregar elementos se usa el metodo add
        listaEmpleados.add(new Empleado("Pedro", 25, 57000));
        listaEmpleados.add(new Empleado("Ana",25,60000));
        listaEmpleados.add(new Empleado("Luis",46,70000));
        listaEmpleados.add(new Empleado("Ana",25,60000));
        listaEmpleados.add(new Empleado("Luis",46,70000));
        listaEmpleados.add(new Empleado("Ana",25,60000));
        listaEmpleados.add(new Empleado("Luis",46,70000));
        //Si bien en la api de java dice que el arrayList tiene un limite de 10 objetos, no es asi.
        //Lo que ocurre es un proceso interno en el que al usar el constructor x defecto de la clase ArrayList, se reserva un espacio en memoria donde se almacenaran 10 elementos, si se mete un elemento mas al array, se crea otra copia diferente de otro array list donde almacena esso 11 elementos.
        //Esto consumira recursos, ay que tiene que eliminar el array anterior y crear uno nuevo.
        //Si queremos establecer un numero especifico de elementos podemos usar un metodo:
        //listaEmpleados.ensureCapacity(12); //Así se reservara inicialmente en memoria, espacios adicionales.

        //Si no especificamos el tamño del arraylist, podemos limitar el arrayList para que no se puedan meter mas elementos:
        // listaEmpleados.trimToSize();  //Esto corta el exceso de memoria que pudiese haber, ya que x ej si tenemos un arrayList de 8 elementos, en memoria estan guardados los 10 espacios, con esto eliminamos de memoria esos 2 lugares sobrantes.
        // Igualmente podemos añadir un elemento mas, pero nos crearia otro array nuevo mas extenso y consumiria mas recurso.

        //Para insertar un elemento en otro lugar que no sea el ultimo (q es por defecto) hay q usar 2 metodos:
        //set para incluir o reemplazar un objeto en una posicion en concreto
        //get para saber que elemento esta en una determinaca posicion del array.
        //listaEmpleados.set(1, new Empleado("Sara", 22, 50000));
        //Recibe 2 aprametros, el 1ro es la posicion donde se a a agregar, y el segundo el objeto.
        //En este caso reemplazo al objeto que tenia a "ana".

        //System.out.println(listaEmpleados.get(1).dameDatos());

        /*for(Empleado e: listaEmpleados){
            System.out.println(e.dameDatos());
        }*/
        //si quisieramos recorre un arrayList con un bucle for comun, para saber el largo del mismo no usariamos .length, sino .size()



        //Iterator:
        //usar un iteraor es una forma de acceder secuenialmente a un arraylist, osea recorrerlo.
        //Se hace usando el metodo iterator() de ArrayList. Este metodo devuelve un objeto de tipo Iterator valga la reduncancia.
        //este objeto Iterator hereda de una interfaz Iterator tmb.
        //La interfaz tiene 3 metodos:
        //hasNext() que devuelve si hay o no (T o F) un elemento siguiente en el arrayL
        //next() devuelve el proximo elemento e la iteracion
        // remove() borra un elemento.

       Iterator <Empleado> miIterador = listaEmpleados.iterator();
        while(miIterador.hasNext()){
            System.out.println(miIterador.next().dameDatos());
        }


    }


}

class Empleado {
    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos() {
        return "El empleado se llama " + nombre + ". Tiene " + edad + " años. Y tiene un salario de " + salario;
    }
}




