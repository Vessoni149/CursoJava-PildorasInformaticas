package Excepciones;

import javax.swing.*;
import java.sql.SQLOutput;
//Para capturar varias excepciones hay que usar un bloque try catch con varios catch
public class variasExcepciones {
    public static void main(String[] args) {
      //No es una buena practia capturar con try catch excepciones no controladas (como las que produce nuestro codigo de aca abajo), se supone que son errores de programacion y deben solventarse de otra forma
        //Pero como a esta altura del curso no estamos en disposicion de crear un codigo que pueda generar excepciones controladas (como acceso a ficheros o a bases de datos), vamos a practiar con ex no controladas:
    try {
        division();
    }catch(ArithmeticException e){
        System.out.println("Ha ourrido un error aritmetico por dividir por 0");
    }catch(NumberFormatException e){
        System.out.println("Introdujiste algo que no es un numero");
        //Tambien podemos usar  mensajes del error que vienen de los metodos del objeto error:
        System.out.println(e.getMessage()); //esto devuelve en consola: For input string: "asfasfas"
        System.out.println(e.getClass());   //devuelve la clase a la que pertenece el metodo
    }finally{
        System.out.println("esto se ejecutara haya error o no");    //Finnally es para que determinado codigo se ejecute haya error o no.
    }

    }

    static void division(){
        int num1 = Integer.parseInt((JOptionPane.showInputDialog("Introduce el dividendo")));
        int num2 = Integer.parseInt((JOptionPane.showInputDialog("Introduce el dividendo")));
        System.out.println("El resultado es: " + num1/num2);
        //Si usamos letras en el input saldra una excepcion "NumberFormatException".
        //Si dividimos por 0 sera una "Arithmetic exception".
        //ambas heredan de RuntimeException, osea que son excepciones NO CONTROLADAS.

    }
}
