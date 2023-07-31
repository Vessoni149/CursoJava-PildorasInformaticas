package Colecciones.Map;
import java.util.*;
//se lamacena la info como clave-valor.
//es poco eficiente comparado con las demas colecciones
//Hay muchas clases que implementan la interfaz Map. Veremos HashMap.
//hashMap no permite ordenar sus elementos pero es muy eficiente para almacenar y objener la info.
//La interfaz map recibe 2 tipos genericos como parametro, que se identifican con k (key) y v (value). Podemos usar caulquier tipo de dato o de objeto para identificar la key. Nosotros usaremos String numericos.
//Para poder introducir elementos se usa el metodo put(clave,valor)
//Map tiene una interfaz interna llamada map.Entry, que tiene el metodo entrySet() que devuelve una coleccion de tipo Set que admite como tipo Map.Entry
public class mapPrueba {
    public static void main(String[] args) {

        HashMap<String,Empleado> personal = new HashMap<String, Empleado>();
        personal.put("clave1", new Empleado("Juan"));
        personal.put("clave2", new Empleado("Pedro"));
        personal.put("clave3", new Empleado("Ana"));
        personal.put("clave4", new Empleado("Elias"));

        System.out.println(personal);

        personal.remove("clave3");
        System.out.println(personal);

        //Si introducimos un elemento con una clave ya existente, lo reemplaza:
        personal.put("clave1", new Empleado("asdasdas"));
        System.out.println(personal);

        //System.out.println(personal.entrySet());    //entrySet devuelve una coleccion de tipo Set a partir de una coleccion Map.
        //lo que haremos es convertir cada elemento del Map en Set
        for (Map.Entry<String, Empleado> entrada: personal.entrySet()){
            String clave = entrada.getKey();
            Empleado valor = entrada.getValue();
            System.out.println("Clave: " + clave + " Valor: " + valor);
        }
    }

}


class Empleado{
    private String nombre;
    private double sueldo;

    public Empleado(String n){
        nombre = n;
        sueldo = 2000;
    }
    public String toString(){
        return "[nombre = " + nombre + ", sueldo = "+ sueldo + "]";
    }

}