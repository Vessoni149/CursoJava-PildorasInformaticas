package poo.PaqueteModAcceso;
import poo.modAccesoPruebas.Clase3;
public class Clase2 {
    public static void main(String[] args) {
        //Clase1 no tiene metodo constructor pero igual se puede instanciar con su constructor x defecto.
        Clase1 miobj= new Clase1();
        //miobj.   si escribimos eso veremos que sale la lista de variables y metodos accesibles. poremos acceder a mivar2, mivar3 y al metodo mimetodo() ya que tienen mod de acceso por defecto y protected. No asi a mivar1 que es private.



        //Esta instancia u objeto podria tener los metodos y variables de la Clase3 y de la Clase1 ya que la 3 hereda a la 1.
        //En este caso solo podra acceder a mivar3 que es la unica protected, porque las otras variables y el metodo de la clase 1 (en Clase2 no hay nada declarado) estan private o por defecto.
        Clase3 miobj2= new Clase3();
        System.out.println(miobj2.mivar3);
    }


}
