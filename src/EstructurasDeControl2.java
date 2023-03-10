import java.util.Scanner;

public class EstructurasDeControl2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); //Instanciamos el objeto entrada de la Clase Scanner. El parametro es el origen de donde tomará los datos de entrada, en este caso System.in es la consola, in es para introducir info, out para mostrarla o sacarla.
        System.out.println("Introduce tu edad: ");
        int edad = entrada.nextInt();               //acá, conseguimos que la consola se quede a la espera de que introduzcamos un valor de tipo Int, y cuando lo hagamos lo guarda en la variable creada. nextLine o nextInt son metodos para captar el siguiente string o int que se introduzca por consola.

        if(edad >= 18){
            System.out.println("Eres mayor de edad");
        }else{
            System.out.println("Eres menor");
        }



    }
}
