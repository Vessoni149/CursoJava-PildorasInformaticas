package poo.ClasesAbstractas;

import java.util.Date;
import java.util.GregorianCalendar;

//Clases y metodos abstractos:
//Necesitamos un metodo abstracto cuando varias clases heredan de una clase padre un metodo pero lo aplican distinto segun la clase que lo herede.
//se crea:
// public abstract TipoDato Nombre ();
//se crean sin llaves {}, solo se definen.
//Que una clase padre tenga un metodo abstracto supone que la clase tmb se abstracta por regla de sintaxis de java.
//Puede que solo tenga 1 o 1000 metodos abstractos, pero debera ser declarada como abstracta:
//abstract class Nombre{...}
//Todas as clases que hereden el metodo abstracto lo tendran que sobreesribir.

//La funcionalidad en sí es crear un patron de diseño en la jerarquia de herencia. Ya que tranquilamente podriasmo crear metodos con un mismo nombre y distintas funciones en distintas clases hijas y que no apliquen herencia.


public class Uso_persona10 {
    public static void main(String[] args) {
//A continuacion probamos las clases abstractas:
        Persona[] lasPersonas = new Persona[2];
        //Recordemos que en un array de una clase podemos meter instancias de esa clase como de sus clases hijas.
        lasPersonas[0] = new Empleado2("Luis", 50000, 2009,02,25);
        lasPersonas[1] = new Alumno("Ana", "biologia");

        //para imprimir las info en consola usamos forEach:
        for(Persona p: lasPersonas){
            System.out.println(p.dameNombre() + ", " + p.dameDescripcion());
        }
    }
}

//Persona va a sser la clase padre de todas las clases, (Empleado2 en este caso), y va a tener un metodo abstracto por lo que será una clase abstracta.
abstract class Persona{
    private String nombre;

    //Constructor:
    public Persona(String nom){
        nombre = nom;
    }
    //Metodos getters:
    public String dameNombre(){
        return nombre;
    }
    //metodo getter abstracto:
    public abstract String dameDescripcion();

}

class Empleado2 extends Persona{
    public Empleado2(String nom, double sue, int anio, int mes, int dia) {
        //Como Empleado2 hereda de Persona, en el construtor de Empleado2 vamos a tener que usar super() para referirnos al cosntructor de la clase padre
        super(nom);
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);
        altaContrato = calendario.getTime();
    }

    //aca sobreescribimos el metodo abstracto heredado.
public String dameDescripcion(){
        return "Este empleado tiene un id = " + Id + " con sueldo: " + sueldo;
}








    //El codigo de abajo es solo copia de Empleadox y no tiene nada de info nueva.
    //getters:
    public double dameSueldo() {
        return sueldo;
    }
    public Date dameFechaContrato() {
        return altaContrato;
    }
    //Setters:
    public void subeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }
    private double sueldo;
    private Date altaContrato;
    private int Id = 1;

}


//Otro ejemplo:
class Alumno extends Persona{
    public Alumno(String nom, String car){
        super(nom);
        carrera = car;
    }
    private String carrera;

    public String dameDescripcion(){
        return "Este alumno esta estudiando " + carrera;
    }
}

