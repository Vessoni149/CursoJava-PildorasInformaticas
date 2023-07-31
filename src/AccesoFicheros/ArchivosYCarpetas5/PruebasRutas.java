package AccesoFicheros.ArchivosYCarpetas5;
/*
Aqui veremos como manipular el sistema de archivos de la maquina donde se ejecuta el programa java, ej: hacer un listado de los archivos o directorios que hay, ver sus propiedades, ver la ruta, crear y borrar arhivos y directorios.
Para todo esto se usa la clase File que tiene 4 constructores y muchos metodos.
*/
//Vamos a usar el segundo constructor que recibe un String pathname para apuntar a un archivo en concreto.

import java.io.File;

public class PruebasRutas {
    public static void main(String[] args) {
        File archivo = new File("src");
        //Aca no estamos poniendo una ruta especifina sino solo nombrano al archivo, cuando hacemos esto, java interpreta que el archivo esta en la carpeta donde esta todo el proyecto java.
        //Para ver donde esta el archivo hay otro metodo:
        System.out.println(archivo.getAbsolutePath());
        //Para ver si existe un archivo o ccarpeta:
        System.out.println(archivo.exists());

        //Para ver una lista de todo lo que hay en una carpeta:
        //Creamos una nueva instancia de File
        File ruta = new File("C:/Users/agust/OneDrive/Escritorio/yo");
        //Y ahora hay qeu usar el metodo list (el que no tiene argumento), que devuelve un array de strings con los nombres de los directorios que hay en la ruta especificada:
        //Entonces vamos a almacenr en un array lo que devuelva el metodo
        String[] nombresArchivos = ruta.list();
        for(int i = 0; i < nombresArchivos.length; i++){
            System.out.println(nombresArchivos[i]);
            //Este metodo list nos va a mostrar todos los archios y carpetas que hay en una carpeta especcificada, pero no lo que hay adentro de esas carpetas, para eso hay una manera:

            //Vamos a tener que usar un metodo que devuelve T o F si algo es una carpeta o no lo es, y en el caso que sea, entrar a esa carpeta y listar los irectorios y archivos nuevamente.
            //Para esto vamos a usar otro Constructor de File que toma como parametro 1 la ruta y 2 el nombre del archivo o carpeta que examinaremos:
            File f = new File(ruta.getAbsolutePath(),nombresArchivos[i]);
            //con getAbsolutePath de ruta estamos refiriendo a la ruta asignada al instanciar "ruta" ya que el metodo devuelve la ruta, y el segundo parametro sera cada archivo de lo que haya en esa ruta.
            if(f.isDirectory()){
                String[] archivosSubcarpeta = f.list();
                for(int j = 0; j < archivosSubcarpeta.length; j++){
                    System.out.println(archivosSubcarpeta[j]);
                }
            }
        }


    }

}


