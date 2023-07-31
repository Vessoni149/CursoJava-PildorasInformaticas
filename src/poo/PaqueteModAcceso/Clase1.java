package poo.PaqueteModAcceso;

//MODIFICADORES DE ACCESO:
//modificador     clase       package     subclase    todos
//Public            si          si          si          si
//Protected         si          si          si          no
//Por defecto       si          si          no          no
//Private           si          no          no          no

//clase refiere a si es accesible desde la misma clase donde es declarada.
//determinan donde seran visibles o usables. En la columna todos refiere a que por ej se pordia acceder a la varible o metodo desde otra clase que esté en otro paquete
//Private se usa mucho por la encapsulacion para declarar las variables de clase.
//Por defecto es accesible desde la misma clase, del mismo paquete pero no de una subclase (SALVO que la subclase esté dentro del mismo paquete).
//Protected es similar a por defecto pero tmb es accesible desde una subclase aunque ésta esté en un paquete diferente.
//No será accesible desde una clase (no subclase) que este en un paquete diferente.

public class Clase1 {
    private int mivar=5;
    //Protected puede usarse dentro del mismo paquete o de otro paquete si es importada y heredada. Si está en otro paquete pero no es heredada no se podra usar.
    protected int mivar3=7;
    int mivar2=7;

    String mimetodo(){
        return "El valor de mivar2 es: " + mivar2;
    }
}

//Clase Object:
//Está en la cuspide de toda la jerarquia de clases de java. Todas la clases de java heredan de ella.
