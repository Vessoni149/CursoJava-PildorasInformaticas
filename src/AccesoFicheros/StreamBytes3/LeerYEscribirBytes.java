package AccesoFicheros.StreamBytes3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


//Streams de Bytes nos permiten manejar no solo archivos de texto sino cualquier tipo de archivo, ya que cualquier arhivo es suceptible de convertirse en una sucesion de bytes.
//Asi podremos enviar y reibir info de cualquier tipo de archivo.
//Necesitaremos 2 clases: FileInputStream y FileOutputStream, que tienen los metodos read() y write() respectivamente.

public class LeerYEscribirBytes {
    public static void main(String[] args) {
        int cantidadBytes = 0;
        int datos_entrada[] = new int[361361];  //Creare un array onde almacenare la cantidad de bytes que tiene el archivo que lei previamente con archivoLectura.read()
        try {
            FileInputStream archivoLectura = new FileInputStream("C:/Users/agust/OneDrive/Escritorio/yo/yo.jpg"); //Creando la instancia tenemso el flujo de datos abierto.
            boolean final_ar = false;

            while(!final_ar){
                int byte_entrada = archivoLectura.read();   //el metodo lee byte a byte el archivo, y lo almacenara en una variable tipo int.
                if(byte_entrada != -1){     //Esta condicion es para que no meta al array el -1 que deuleve el metodo read cuando llega al final del archivo.
                    datos_entrada[cantidadBytes] = byte_entrada;    //Asingo al array los valores de los bytes que lei con archivoLectura.read()
                }
                else{ //Esto porque al final de leer el archivo cuando no haya nada para leer devuelve -1 el metodo read.
                    final_ar = true;  //Entonces caundo se cumpla la condicion se sale del bucle y deja de leer.
                }
               // System.out.println(byte_entrada);
                System.out.println(datos_entrada[cantidadBytes]);   //Aca podemos ver que el array devuelve la misma cantidad de bytes que los que leyo el metodo read (en el print de la linea de codigo anterior).
                cantidadBytes++;
            }
            archivoLectura.close();
            }catch(IOException e ){
            System.out.println("Error al acceder a la imagen");
        }
        System.out.println(cantidadBytes);
        crea_fichero(datos_entrada);
    }

    //Este metodo creara un nuevo fichero con los datos  del fichero leido anteriormente
    static void crea_fichero(int datos_nuevo_fichero[]){
        try{    //Como el metodo write de la clase FileOutputStream lanza ioEx, usaremos lboque try catch
            //al instanciar la clase FileOutputStream indicamos la direccion donde se creara el nuevo fichero
            FileOutputStream fichero_nuevo = new FileOutputStream("C:/Users/agust/OneDrive/Escritorio/yo/yo_copia.jpg");
           //Con un bucle for iremos recorreindo el arrai con los bytes del archivo que leimos para con el write() crear una copia del mismo.
            for(int i = 0; i<datos_nuevo_fichero.length; i++){
                fichero_nuevo.write(datos_nuevo_fichero[i]);
            }
            fichero_nuevo.close();
        }catch (IOException e){
            System.out.println("Error al crear el archivo");
        }
    }


}
