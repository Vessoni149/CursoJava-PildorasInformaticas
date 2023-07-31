package AccesoFicheros.ArchivosYCarpetas5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {
    public static void main(String[] args) {
        File ruta = new File("C:/Users/agust/OneDrive/Escritorio/yo" + File.separator + "nuevoDirectorio" );
        //El metodo mkdir crea un directorio hay que indicar en el path en nombre del directorio y ejecutar:
        ruta.mkdir();

        //Para crear un archivo tmb hay que especificar el nombre del mismo en la ruta:
        File ruta2 = new File("C:/Users/agust/OneDrive/Escritorio/yo" + File.separator + "nuevoDirectorio" + File.separator + "PruebaTexto.txt");
        //Y seguidamente ejecutar el metodo que lanza una ioExcept:
        try {
            ruta2.createNewFile();
        }catch(IOException e){
            System.out.println(e);
        }

        //Escribir en el archivo creado:
        String archivoDestino = ruta2.getAbsolutePath();
        Escribiendo accede = new Escribiendo();
        accede.escribir(archivoDestino);


    }
}


//Con esta clase escriiremos en el archivo. Los conceptos ya fueron vistos en la primer parte de la seccion en el archivo LeerFichero.
class Escribiendo{
    public void escribir(String rutaArchivo){
        String frase="Esto es un ejemplo de escritura en archivo";
        try{
            FileWriter escritura = new FileWriter(rutaArchivo);
            for(int i = 0; i< frase.length();i++){
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        }catch (IOException e){

        }
    }
}
