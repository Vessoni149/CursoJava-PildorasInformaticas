package AccesoFicheros;


//Los Streams o secuencias o flujos de datos sirven para diversas cosas como por ej enviar datos desde un programa java a un sitio remoto en a web, para acceder a ficheros externos dentro de nuestra pc, para escribir en esos ficheros, ect.
//Hata ahora hemos guardado datos temporalmente en la ram(con variables y arrays x ej), acá veremos como almacenar la info
//de forma permanente en la memoria de la pc (disco duro, pen drive...).
//Como se abordan los stream:
//podemos abordarlos como flujos de bytes o como flujos de caracteres.
//Osea a la hora de acceder a un archvo lo podemos hacer usando bytes o caracteres, tanto para leerlos como para escribirlos.
//usaremos una u otra dependiendo de lo que querramos hacer.
//Ej, si queremos almacenar info que vamos a leer, como en un archivo de texto usaremos caracteres.
//Si queremos enviar info que genera el programa jva a un sitio remoto convendrá enviar la info como un flujo de bytes, ya que no lo vamos a leer.
//Veremos la forma de acceder a la info como un flujo de caracteres en principio (en este archivo y el siguiente veremos como leer y escribir respectivamente flujos de caracteres), luego mas adelante en otro archivo, como bytes.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//(Si bine se tratará despues) para acceer como flujo de bytes usariamos las clases de java InputStram y outputStream (lases abstractas del paquete java.io.)
//Para texto usariamos las clases abstractas Reader y Writer  tambien del paquete java.io
//Especificamente de Reader desciente la subclase InputStreamReader, y de ésta, desciende otra subclase llamada FileReader, que es la que vamos a usar en este archivo.

//FileReacer <-- InputStreamReader <-- Reader <-- java.io
public class AccesoFicheros1 {
    public static void main(String[] args) {
        Leer_Fichero accediendo = new Leer_Fichero();
        accediendo.lee();
    }
}


class Leer_Fichero{
    public void lee(){
        try {
            FileReader entrada = new FileReader("C:/Users/agust/OneDrive/Escritorio/asd.txt"); //FileReader abre el flujo de datos que luego habria que cerrar.

            //Una vez guardado el archivo en entrada tenemos que usar el metodo "read" de la clase FileReader para leerlo
            //Hay varios metodos read, usaremos el que hereda  de InputStreamReader
            //Deveulve un dato de tipo int (devuelve los numeros correspondientes a los caracteres unicode, usea que cada letra o simbolo tiene un numero asignado y lo que se devuelve es ese numero) y lanza una excepcion IO, controlada, por lo que debera estar dentro de un try catch
            //retorna el caracter leido del archivo o -1 i llega al final del archivo (de la letra)
            int c = 0;
                while(c != -1) {    //esta condicion indica "hasta que no llegue al ultimo caracter)
                    c= entrada.read();
                    char letra = (char)c;   //aca casteamos ese numero unicode para ocnvertirlo a un char
                    System.out.print(letra);
                }
                entrada.close();    //Se cierra el flujo de datos. Sin esta instruccion funciona igual, y no se marca ningun warning como en el video.
            }
        catch (IOException e) {
            System.out.println("No se encontro el archivo");
        }
    }
}