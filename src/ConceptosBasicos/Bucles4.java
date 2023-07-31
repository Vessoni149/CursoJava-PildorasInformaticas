package ConceptosBasicos;

import javax.swing.*;
import java.util.Scanner;

public class Bucles4 {
    public static void main(String[] args) {
        //Bucles indeterminados son while y do-while
        //bucles determinados son For y For-each.
        //los indeterminados no sabemos cuantas veces se va a repetir el bucle.
        //los determinados sí.
        //String clave = "Agustin";
        //String pass = "";
        //equals compara 2 cadenas de texto, dando T o F. Es CaseSentitive.
        /*while (clave.equals(pass)==false){
            pass = JOptionPane.showInputDialog("Introduce la contraseña:");
            if(clave.equals(pass)==false){
                System.out.println("Contraseña incorrecta.");
            }
        }
       System.out.println("Contraseña correcta. Acceso permitido.");
*/
        // --------------------------------------------------------------------

        //Math.random devuele numeros entre 0  y 1 de tipo double.
        /*System.out.println(Math.random());  // se multiplica para que el numero sea de 0 a 100 en vez de entre o y 1.
        //como Math.random devuelve un decimal (doulbe), hay que convertirlo a entero.
        int aleatorio = (int)(Math.random()*100);
        System.out.println(aleatorio);
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        int intentos = 0;
        while (numero != aleatorio){
            intentos++;
            System.out.println("Introduce un número:");
            numero = entrada.nextInt();
            if (aleatorio < numero){
                System.out.println("El número es más bajo");
            }else if (aleatorio > numero){
                System.out.println("El número es mayor");
            }
        }
        //una vez que se deja de cumplir la condicion del while, recién ahí deja de ejecutarse y pasa a ejecutarse la línea siguiente.
        System.out.println("Correcto. Lo has conseguido en " + intentos + " intentos");*/
        // --------------------------------------------------------------------


        //con do while podemos hacer que se repregunte o que el usuario siga insertando datos hasta que inserte algo valido.
        /*String genero = "";
        do{
            genero = JOptionPane.showInputDialog("Introduce tu genero (H o M)");

        }while (genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") == false);
        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
        int pesoIdeal = 0;
        if(genero.equalsIgnoreCase("H")){
            //supuestamente pasa sacar el peso ideal es la altura - 110 para hombres y - 120 para mujeres
            pesoIdeal= altura-110;
        }else if (genero.equalsIgnoreCase("M")){
            pesoIdeal = altura-120;
        }
        System.out.println("Tu peso ideal es " + pesoIdeal);*/




        // --------------------------------------------------------------------

        /*int arroba = 0;
        int punto = 0;
        String mail = JOptionPane.showInputDialog("Introduce tu mail:");

        for(int i = 0; i < mail.length(); i++ ){
            if (mail.charAt(i) == '@'){     //como @ es de tipo char va entre comillas simples.
                arroba++;
            }
            if (mail.charAt(i) == '.'){
                punto++;
            }
        }
        if(arroba == 1 && punto == 1){
            System.out.println("Correcto");
        }else System.out.println("no es correcto");*/

        // --------------------------------------------------------------------

        //sacando el factorial de un numero: el factorial es el resultado de un numero multiplicado por cada numero que lo precede, ej el fact
        // de 4 es: 4*3*3*1
        //si insertamos un numero grande como x ej 20, el tipo int no nos va a alzanzar, si ponemos 50, ni si quiera el tipo Long alcanzaría.
        // Para estos casos se usa una clase BigInteger para manejar numeros muy grandes, pero requieren la construccion de un objeto.
       /* Long resultado = 1L;
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
        for (int i = numero; i>0; i--){
            resultado = resultado*i;
        }
        System.out.println("El factorial de " + numero + " es: " + resultado);
*/


        // --------------------------------------------------------------------



        int[][] matrix = new int [3][4];
        matrix[0][0] = 15;
        matrix[0][1] = 5;
        matrix[0][2] = 1;
        matrix[0][3] = 56;

        matrix[1][0] = 2;
        matrix[1][1] = 3;
        matrix[1][2] = 6;
        matrix[1][3] = 67;

        matrix[2][0] = 65;
        matrix[2][1] = 45;
        matrix[2][2] = 13;
        matrix[2][3] = 53;

        System.out.println(matrix[2][2]);

        //Para recorrer la matriz bidimensional necesitamos 2 bucles for.
        //si tiene 3 dimensiones, 3 bucles.

        //el primer for recorre la primer dimension, y el segundo la 2da, por eso en el primero la condicion es que i < 3 (extencion de la priemr dimencion)
        // y el el segundo, la condicion es j < 4 (extencion de la segunda dimension).

        //por cada primer bucle, se va a ejecutar el segunto tantas veces como longitud tenga la segunda dimension, una vez termina sigue con la
        // segunda iteracion del primer bucle y así sucesivamente.
        /*for (int i = 0; i < 3; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }*/

// --------------------------------------------------------------------


        //Vamos a rellenar una matriz bidimensional de otra forma:

        /*int [][] matrix2 = {
                {10,15,2,34},
                {2,3,6,5},
                {87,54,32,1}
        };

        //lo vamos a recorrer con bucle for each:
        for (int []i:matrix2) {
            System.out.println();
            for(int j: i){
                System.out.print(j + " ");
            }
        }*/
        //i va a ser cada array "externo" y j cada array "interno" dentro de cada i.

        // --------------------------------------------------------------------

        //EJEMPLO PRACTICO con array bidimensional.
        //lo vamos a rellenar de manera automatica con bucles

        double acumulado;
        double interes = 0.10;

        double[][] saldo = new double[6][5];

        for (int i = 0 ; i < 6; i++){       //6 porque es el n° de valores que tiene el array externo.
            saldo[i][0]= 10000; //para todas las posiciones 0 de cada array externo i, tendrán ese mismo valor.
            acumulado = 10000;
            for(int j = 1; j < 5; j++){    //5 porque lo mismo que antes, PERO j empieza en 1, no en 0, ya que la posicion 1 ya esta declarada y será siempre 10.000
                acumulado = acumulado + (acumulado*interes);
                saldo[i][j]=acumulado;
            }
            interes = interes+0.01;
        }
        //leeremos la matriz:
        for (int z=0; z < 6; z++){
            System.out.println();
            for (int h = 0 ; h<5;h++){
                System.out.printf("%1.2f",saldo[z][h]);
                System.out.print(" ");
            }
        }


    }

}
