//Importaciones: por defecto en java tenemos acceso a todos los métodos de la carpeta java.lang, y no tendremos que importarla. Es donde por ej. están los objetos String, Math, System, y sus metodos, entre otros.
//Ahora, si necesitamos usar objetos o métodos que están en otra carpeta que no sea src, vamos a tener que importar.
//Podemos importar solo la clase que necesitamos dentro de un paquete/carpeta con su dirección:
import javax.swing.*;
import java.util.Scanner;
//O bine, podemos importar todas la clases que estén en una carpeta determinada con .*, como se ve a continuación.
//import java.util.*;

public class ConceptosBasicos1 {
    public static void main(String[] args) {
        byte edad = 28;
        int a = 5;
        int b = 7;
        int c = b/a;
        System.out.println(c);      //1
        //esto va a dar 1 ya que c está declarado como un entero, el verdadero resultado es decimal.
        //Cuando trabajamos con divisiones en java tenemos que hacerlo con double o float. Double como comodín. En todos los tipos de dato que vayan a ser susceptibles de división.
        double d = b/a;             //1.0   ya que a y b son int, no float.
        System.out.println(d);

        double x = 5;
        double y = 7;
        double z = y/x;
        System.out.println(z + "\n");  // dará el resultado exacto, 1.4.

        //Métodos del objeto Math
        //int raiz = Math.sqrt(43);   //esto tira error porque necesita como dato de entrada un double y de salida un double. Acá no va a importar tanto el dato de entrada, sino el de salida, que se está almacenando en un int.
        double raiz = Math.sqrt(9); //si de dato de entrada ponemos un numero entero lo que hace java es considerarlo como 9.0 en este caso. Lo convierte a double automáticamente.
        System.out.println(raiz);

        double num1 = 5.85;
        float resultado = Math.round(num1);   //Hay 2 metodos round, uno toma de dato de entrada un float y devuelve un int; y otro toma un double y devuelve un long. Más alla de cual elijamos, dependiendo del tipo de dato que pongamos de entrada, se va a ejecutar el que funcione para ese tipo automaticamente.
        System.out.println(resultado);

        float num2 = 3.56F;
        float resultado2 = Math.round(num2);    //este round toma una float y debería devolver un entero, pero como lo estamos almacenando en un float el resultado será float. Esto es posible porque el resultado, en ese caso 4, puede ser tanto byte, como float, double, short, o int.
        System.out.println(resultado2);


        double base = 5;
        double exponenete = 3;
        //int resuntado3 = (double)Math.pow(base,exponenete);        esto da error. No puede ser int el resultado.
        // pow recibe 2 parámetros de tipo double (ase,exponente). Y devuelve un double.
        double resuntado3 = Math.pow(base,exponenete);
        System.out.println(resuntado3);
        //otra cosa que se puede hacer es refuncición de tipo de dato, esto es, modificar el tipo de dato que devuelve:
        int resultado4 = (int)Math.pow(base,exponenete);
        System.out.println(resultado4);

        //Manipulación de cadenas:
        //String no es un tipo de dato primitivo, sino que es una clase.
        //Cada vez que declaramos una String estamos instanciando un objeto de la Clase String. Entonces no va a ser una variable en sí, sino un objeto.
        //Lo que se guardará en memoria debe ir entre "" dobles.
        String nombre = "Juan";

        //Métodos de la Clase String:
        //.length();

        System.out.println(nombre.charAt(3)); //devuelve la el caracter que esté en la posición que le indiquemos.
        System.out.println(nombre.substring(1,3)); //recoreta la cadena creando una nueva. Devuelve una subcadena, siendo el 1er argumento el caracter donde comenzará y el 2do en el que terminará- no incluido.
        String nombre2 = "juAn";
        System.out.println(nombre.equals(nombre2));    //compara si 2 cadenas son iguales o no, devuelve T o F. Tiene en cuenta las mayusculas y minusculas.
        System.out.println(nombre.equalsIgnoreCase(nombre2));   //Como lo dice el nombre ignora mayusculas y minusculas.
        System.out.println(nombre.contains("n"));       //retorna T o F segun contanga o no la secuencia especificada de caracteres o caracter.


        //metodo getChars:
        // Descripción de parámetros:
        //srcBegin – índice del primer carácter de la cadena a copiar.
        //srcEnd – índice después del último carácter de la cadena que se va a copiar.
        //dest – Matriz de caracteres de destino en la que se copian los caracteres de cadena.
        //destBegin – El índice de la matriz a partir de donde se insertarán los caracteres en la matriz.
        String oracion = "holacomoestas";
        char[] arrayEjemplo = new char[8];   //el n° de caractenes que va a tener este array debe ser como mínimo de la misma cantidad del array que se va a extraer del string. Si es mas grande, los caracteres que no entren en el nuevo array van a ser null. Si es más chico dará error.
        oracion.getChars(2,7, arrayEjemplo, 0);
        for(char i: arrayEjemplo){
            System.out.println(i);
        }

        System.out.println(oracion.indexOf("o")); //Devuelve el índice dentro de la cadena, de la primera aparición del carácter especificado.
        System.out.println(oracion.indexOf("o", 6)); //devuelve la ubiacion de "o" comenzando a contar desde el indice 6.

        //lastIndexOf(int ch, int fromIndex)
        //Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index.

        //lastIndexOf(String str)
        //Returns the index within this string of the last occurrence of the specified substring.

        //isEmpty()
        //Returns true if, and only if, length() is 0.

        //replace(char oldChar, char newChar)
        //Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar

        //replace(CharSequence target, CharSequence replacement)
        //Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.

        //toCharArray()
        //Converts this string to a new character array. Devuelve una cadena de tipo char: char[]

        //	substring(int beginIndex)
        //Returns a new string that is a substring of this string.

        //Para dividir un string en 2 se usa split:
        //split va a crear 2 arrays con 1 string cada uno que son los que resultaran de la division de la cadena inicial.
        //vamos a tener que instanciarlos como String luego (part1 y part2);
        String string = "123-654321";
        String[] parts = string.split("-");
        String part1 = parts[0]; // 123
        String part2 = parts[1]; // 654321
        System.out.println(part1 + " " + part2);
        //El método toma como parámetro una expresión regular. Si se quiere utilizar un separador textual, se deben escapar los caracteres \ ^ $ . | ? * + ( ) [ { antecediéndolos con una \.
        //String[] parts = string.split("\\|"); // Separar por "|"

        Scanner entrada = new Scanner(System.in);  //el parametro es el origen de donde tomará los datos de entrada, en este caso System.in es la consola, in es para introducir info, out para mostrarla o sacarla.
        //La clase Scanner nos permite insertar información al programa, tiene metodos como: nextLine, nextInt y nextDouble, para introducir texto, numeros enteros o n decimates respectivamente.
        //Tmb existe una clase más antigua JOptionPane, que construye una ventana con un input y botones de aceptar y cancelar. Para crearla usaremos el metodo e esa clase showInputDialog(), que es un método estático, no tendremos que instanciar el ojeto.
        //además, tendremos que usar el nombre de la clase . metodo para utilizarlo, a diferencia de scanner que no es estático.

       /*System.out.println("Intruduce tu nombre: ");

        // nextLine o nextInt son metodos de la clase Scanner para captar el siguiente string o int que se introduzca por consola.
        String nombreUsuario = entrada.nextLine();  //acá, conseguimos que la consola se quede a la espera de que introduzcamos un valor de tipo String, y cuando lo hagamos lo guarda en la variable creada nombreUsuario.
        System.out.println("Introuce tu edad: ");
        int edadUsuario = entrada.nextInt();               //acá lo mismo para un entero.
        System.out.println("Hola " + nombreUsuario + " " + "el año que viene tendrás " + (edadUsuario +1) + " años");

        //JOptionPane. Ésta clase tiene varios métoods, muchos tienen en mismo nombre y reciben diferentes parámetros, y varios son estáticos. Para usar la clase hay que importarla. Se importaron automátiamente todos los metodos del paquete java.swing.
        String nombre_usuario = JOptionPane.showInputDialog("Introduce tu nombre por favor: ");
        //lo que el usuario escriba en el input se almacenará en la variable.

        //ahora le pediremos la edad, pero este metodo devuelve un string, si lo uqeremos sumar tendremos que usar un metodo para pasar el dato de String a int. Lo haremos con parseInt, que es un metodo estatico de la clase Integer.
        String edad2 = JOptionPane.showInputDialog("Intruduce tu edad: ");
        int edad_usuario = Integer.parseInt(edad2);
        System.out.println("hola " + nombre_usuario + " tu edad el año que viene será de " + (edad_usuario + 1) + " años.");
        */


        //entrada de números:
        double num = 10000.0;
        System.out.println(num/3);
        //si queremos que nos de el resultado en otro formato, x ej que nos de el numero entero de resultado con 2 decimales, podemos usar print format.
        //el primer parametro debe ir entre "", tener %, y especificar el formato, en este caso 1 decimal y 2 n° después de la ,.
        //el segundo parametro sería la operación matemarica o número a formatear.
        System.out.printf("%1.2f", num/3);
        System.out.println(" ");
        System.out.printf("%1.4f", num/3);
        System.out.println(" ");
        //ahora haremos lo mismo pero tomando un dato de entrada, y lo pasaremos a double on e metodo estatico de la clase Double "parseDouble()"
        String numb = JOptionPane.showInputDialog("Introduce un número: ");
        double numb2 = Double.parseDouble(numb);
        //(print solo imprime al lado, print ln imprime y hace un salto de linea).
        System.out.print("la raiz de " + numb2 + " es: ");
        System.out.printf("%1.2f", Math.sqrt(numb2));
        //esto nos devolvera la raiz cuadrada con 2 decimales.
    }
}
