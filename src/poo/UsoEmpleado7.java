package poo;

import java.util.*;
//Ahora vamos a usar un unico archivo para construir las clases que necesitemos. (ESTO APLICA PARA LOS ARCHIVOS TERMINADOS ES 7, 8 Y 9)
//no es la forma recomendada, lo correcto sería una clase por archivo (como Coche), pero como se puede hacer mostramos cómo.
//Programando de esta forma, osea con varias clases en un archivo, solo una clase puede ser public, y solo una puede tener el metodo main (si es que lo tiene).
public class UsoEmpleado7 {
    public static void main(String[] args) {

        /*Empleado empleado1 = new Empleado("Juan",85000, 1900, 12, 17);
        Empleado empleado2 = new Empleado("Ana",95000, 1905, 6, 2);
        Empleado empleado3 = new Empleado("Paco",105000, 1903, 3, 7);

        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);
        empleado3.subeSueldo(5);
        System.out.println(" Nombre: " + empleado1.dameNombre() +" Sueldo: " +empleado1.dameSueldo() + " Fecha de alta: " + empleado1.dameFechaContrato());
        System.out.println(" Nombre: " + empleado2.dameNombre() +" Sueldo: " +empleado2.dameSueldo() + " Fecha de alta: " + empleado2.dameFechaContrato());
        System.out.println(" Nombre: " + empleado3.dameNombre() +" Sueldo: " +empleado3.dameSueldo() + " Fecha de alta: " + empleado3.dameFechaContrato());
   */
        //Vamos a hacer lo de aca arria mero en menos lineas:
        Empleado[] misEmpleados = new Empleado[3];
        //En java no se puede crear arrays con distintos tipos de dato, la alternativa a esto es crear una clase con distintos tipos de dato y luego
        // instanciarla, los datos en vez de almacenarse en un array se almacenarán en un objeto.
        //Basicamente la alternativa es crear un array de objetos que tengan ellos los distintos tipos de dato.
        misEmpleados[0] =new Empleado("Juan",85000, 1900, 12, 17);
        misEmpleados[1] =new Empleado("Ana",95000, 1905, 6, 2);
        misEmpleados[2] =new Empleado("Paco",105000, 1903, 3, 7);

        //con bucle for:
       /* for (int i = 0; i<misEmpleados.length;i++){
            misEmpleados[i].subeSueldo(5);
        }
        for (int i = 0; i < 3; i++){
            System.out.println("Nombre: " + misEmpleados[i].dameNombre() + " Sueldo: "
            + misEmpleados[i].dameSueldo() + " Fecha de alta: " + misEmpleados[i].dameFechaContrato());
        }*/

        //con bucle for each:
        for(Empleado e: misEmpleados){
            e.subeSueldo(5);
        }
        for(Empleado e: misEmpleados){
            System.out.println("Nombre: " + e.dameNombre() + " Sueldo: "
                    + e.dameSueldo() + " Fecha de alta: " + e.dameFechaContrato());
        }

    }
}

class Empleado{
    //el metodo constructor siempre debe ser public para que pueda ser accedido desde otras clases.
    public Empleado(String nom, double sue, int anio, int mes, int dia){
        nombre = nom;
        sueldo = sue;
        //La clase GregoriaCalendar construye una fecha. Le vamos a pasar anio, mes y dia.
        //Esta clase tiene varios constructores, el que no tiene parametros retorna la fecha y hora actuales en el momento de construir el objeto.
        //vamos a usar la que tome 3 parametros int.
        //aclaracion: para el metodo constructor enero es 0, que es donde se inicializan los valores
        GregorianCalendar calendario = new GregorianCalendar(anio,mes -1, dia);
        altaContrato = calendario.getTime();
        //El metodo gettime de la clase GregorianCalendar develve una fecha. Retorna dato de tipo Date.
        //En la api no aparece este metodo, ya que en realidad lo hereda de Calendar.
    }

    //getters:
    public String dameNombre(){
        return nombre;
    }
    public double dameSueldo(){
        return sueldo;
    }
    public Date dameFechaContrato(){
        return altaContrato;
    }

    //Setters:
    public void subeSueldo(double porcentaje){
        double aumento = sueldo  * porcentaje/100;
        sueldo+=aumento;
    }



    //da igual donde estén creadas las variables de la clase, pueden estár después del constructor.
    private String nombre;
    private double sueldo;
    //Aquí crearemos una variable de tipo Date, que no es un tipo primitivo de dato, sino que es una clase al igual que String. Date es una clase predefinida
    // del paquete java.util
    //en la documentacion veremos que hay 2 clases DATE, esto porque si están en paquetes diferentes, pueden existir clases con el mismo nombre. La otra clase
    // Date es del paquete sql que se usa para incluir instrucciones sql en el codigo java.
    private Date altaContrato;

}
