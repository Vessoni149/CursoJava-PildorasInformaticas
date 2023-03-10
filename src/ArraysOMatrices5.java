public class ArraysOMatrices5 {
    public static void main(String[] args) {

    //sintaxis de una matriz:
    //tipo de dato que almacenara la matriz + nombre de la matriz + = + new + tipo de dato + [n° de valores que almacenara la matriz].
    //int[] miMatriz = new int [10];
    //Al igual que las variles, podemos declararlas e iniciarlas en una linea o hacerlo por separado.
    int[] miMatriz = new int [5];
    miMatriz[0]= 15;
    miMatriz[1]= 25;
    miMatriz[2]= 5;
    miMatriz[3]= 1;
    miMatriz[4]= 13;

    int[] otraMatriz = {13,24,2,-5,34};

    //foreach:
    //bucle que recorre cada elemento del array y hace algo con cada uno, en este caso los imprime en consola.
    //se debe poner entre () el tipo de dato de cada elemento del array y asignar un nombre que represente cada elemento del mismo (en este caso i), seguido de ":" y el nombre  del array a recorrer.
    for (int i: miMatriz) {
        System.out.println(i);
    }

    int[] matrizAleatorios = new int[150];
       for (int i = 0; i < matrizAleatorios.length; i++){
           matrizAleatorios[i] = (int)(Math.random()*100);
       }

        for (int numeros : matrizAleatorios) {
            System.out.print(numeros + " ");
        }


        //Arrays de dos dimensiones: (un array dentro de otro).




    }
}
