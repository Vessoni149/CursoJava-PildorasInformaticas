package ConceptosBasicos;

import java.util.Scanner;

public class EstructurasDeControl2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); //Instanciamos el objeto entrada de la Clase Scanner. El parametro es
        // el origen de donde tomará los datos de entrada, en este caso System.in es la consola, in es para introducir
        // info, out para mostrarla o sacarla.
       /* System.out.println("Introduce tu edad: ");
        int edad = entrada.nextInt(); */              //acá, conseguimos que la consola se quede a la espera de que
        // introduzcamos un valor de tipo Int, y cuando lo hagamos lo guarda en la variable creada. nextLine o nextInt
        // son metodos para captar el siguiente string o int que se introduzca por consola.

        /*if(edad >= 18){
            System.out.println("Eres mayor de edad");
        }else{
            System.out.println("Eres menor");

        }


        String cargo = null;

        Scanner entrada2 = new Scanner(System.in);
        System.out.println("introduce cargo");
        cargo = entrada2.nextLine();
        switch(cargo){
            case "repositor":
                System.out.println("El cargo es repositor y tiene un sueldo de: " + (15890 + 15890*10 / 100));
                break;
            case "cajero":
                System.out.println("El cajero gana: " + 25630.20);
                break;
            case "supervisor":
                System.out.println("El sueprvisor gana: " + (35560.20 - 35560.20*11 / 100));
                break;
        }*/
        /*System.out.println("Escribe un numero");
        Scanner entrada3 = new Scanner(System.in);

        int vector[] = new int [14];
        for(int i = 0; i < 14; i++){
            System.out.println("Ingrese un numero para el vector:");
            vector[i] = entrada3.nextInt();
        }
        int cuenta3 = 0;
        for(int i = 0; i < vector.length; i++){
            if(vector[i] == 3){
                cuenta3++;
            }
        }
        System.out.println("el numero 3 aprerecio: " + cuenta3 + " vez/veces.");
*/

     /*   Scanner entrada4 = new Scanner(System.in);
        int notasSumadas = 0;
        double matriz[][] = new double [4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++){
                System.out.println("Ingrese la nota " + (j+1) + " del alumno " + (i+1));
                matriz[i][j] = entrada4.nextInt();
            }
        }
        matriz[0][3]= (matriz[0][0] + matriz[0][1] + matriz[0][2]) / 3;
        matriz[1][3]= (matriz[1][0] + matriz[1][1] + matriz[1][2]) / 3;
        matriz[2][3]= (matriz[2][0] + matriz[2][1] + matriz[2][2]) / 3;
        matriz[3][3]= (matriz[3][0] + matriz[3][1] + matriz[3][2]) / 3;
        System.out.println("El anumno 1 tiene las siguientes notas: " + matriz[0][0] + " " + matriz[0][1] + " " + matriz[0][2] + ". Y el promedio es: " + matriz[0][3]);
        System.out.println("El anumno 2 tiene las siguientes notas: " + matriz[1][0] + " " + matriz[1][1] + " " + matriz[1][2] + ". Y el promedio es: " + matriz[1][3]);
        System.out.println("El anumno 3 tiene las siguientes notas: " + matriz[2][0] + " " + matriz[2][1] + " " + matriz[2][2] + ". Y el promedio es: " + matriz[2][3]);
        System.out.println("El anumno 4 tiene las siguientes notas: " + matriz[3][0] + " " + matriz[3][1] + " " + matriz[3][2] + ". Y el promedio es: " + matriz[3][3]);
*/


        Scanner entrada4 = new Scanner(System.in);
        int notasSumadas = 0;
        double matriz[][] = new double [4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++){
                System.out.println("Ingrese la nota " + (j+1) + " del alumno " + (i+1));
                matriz[i][j] = entrada4.nextInt();
                if(j == 3){
                    matriz[i][3]= (matriz[i][0] + matriz[i][1] + matriz[i][2]) / 3;
                }
            }
        }

        System.out.println("El anumno 1 tiene las siguientes notas: " + matriz[0][0] + " " + matriz[0][1] + " " + matriz[0][2] + ". Y el promedio es: " + matriz[0][3]);
        System.out.println("El anumno 2 tiene las siguientes notas: " + matriz[1][0] + " " + matriz[1][1] + " " + matriz[1][2] + ". Y el promedio es: " + matriz[1][3]);
        System.out.println("El anumno 3 tiene las siguientes notas: " + matriz[2][0] + " " + matriz[2][1] + " " + matriz[2][2] + ". Y el promedio es: " + matriz[2][3]);
        System.out.println("El anumno 4 tiene las siguientes notas: " + matriz[3][0] + " " + matriz[3][1] + " " + matriz[3][2] + ". Y el promedio es: " + matriz[3][3]);



    }
}
