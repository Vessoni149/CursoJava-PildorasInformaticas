package AccesoFicheros;

import java.io.FileWriter;
import java.io.IOException;

public class LeerFichero {
    public static void main(String[] args) {
        Escribiendo accede = new Escribiendo();
        accede.escribir();
    }
//Usaremos la clase FileWriter que hereda de OutputStreamWriter, que hereda de Writer, del paquete Java.io
    //Tiene varios constructores, vamos a usar el que toma como parametro un archivo.
    //Lanza una excepcion IO asique deberá estar en un try catch.
static class Escribiendo{
        public void escribir(){
            String frase = "Esto es una prueba de escritura";

            try {
                FileWriter escritura = new FileWriter("C:/Users/agust/OneDrive/Escritorio/nuevoArhivo.txt");    //creará un nuevo archivo. Si quisieramos escribir en un archivo ya creado tenemos que agregar otro parametro (para usar otro constructor) que tenga el valor de "true", y tendremos que poner la direccion del fichero existente en el primer parametro.
                //Respecto a la ruta, si queremos que sea multiplataforma hay que usar otro selapador que no sea la "/" ya que ésta es caracteristica de windows. Para hacer una ruta multiplataforma podemos concatenar cada elemento de la ruta + File.separator que es un metodo estatico que atua de separador (video 162).
                for(int i=0; i<frase.length(); i++){
                    escritura.write(frase.charAt(i)); //escribira caracter por caracter en el archivo los caracteres almacenados en la variable "frase"
                }
                escritura.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
