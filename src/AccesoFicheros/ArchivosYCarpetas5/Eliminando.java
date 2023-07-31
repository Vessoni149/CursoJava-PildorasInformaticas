package AccesoFicheros.ArchivosYCarpetas5;

import java.io.File;

public class Eliminando {
    public static void main(String[] args) {
        File ruta2 = new File("C:/Users/agust/OneDrive/Escritorio/yo" + File.separator + "nuevoDirectorio" + File.separator + "PruebaTexto.txt");
        ruta2.delete();
        //Delete borra el archivo o directorio especificado en el pathname
    }
}
