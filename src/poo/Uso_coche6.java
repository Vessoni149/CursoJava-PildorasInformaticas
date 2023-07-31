package poo;

public class Uso_coche6 {
    public static void main(String[] args) {
        Coche6 rerault = new Coche6(4,380,150,6500);
        System.out.println("El auto tiene un ancho de: " + rerault.ancho + "cm. Y tiene " + rerault.ruedas + " ruedas.");

        //como no encapsulamos nada podría hacer lo siguiente:
        rerault.ruedas = 3;
        System.out.println(rerault.ruedas);
        //no tiene mucho sentido poder cambiar las propiedades aca. Podemos encapsularla para que solo se puedan modificar dentro de la propia clase y no acá.
        //veamos que con el peso no podremos por tener el modificador de acceso private.
        //Rerault.peso = 100;   //si descomentamos lo anterior veremos que marca error xq peso al ser private ya no es visible desde aca, ni modificable.
        //ni si quiera podremos mostrar el dato:
        //System.out.println(Rerault.peso);
        //para poder acceder al dato y modificarlo o verlo tendremos que usar los getters y setters, que es el medio que corresponde para cumplir con el encapsulamiento.
        //las clases de un sistema si o si deben comunicarse, el tema es que lo hagan de la forma correcta, a traves de métodos..

        System.out.println(rerault.pesoPlataforma);
        System.out.println(rerault.getLargo());

        rerault.setColor("Azul");
        System.out.println(rerault.getColor());

        System.out.println(rerault.getDatosGenerales());
        //No se puede pasar un metodo setter dentro de un sout ya que aquél no retorna nada.
        rerault.setAsientoCuero("si");
        System.out.println(rerault.isAsientoCuero());
        rerault.setClimatizador(true);
        System.out.println(rerault.dimePesoTotal());
        System.out.println(rerault.precioCoche());
    }
}
//Si vamos a tener muchas clases en un archivo (cosa que no se aconseja xq no se modulariza), la clase ppal tiene que ser public. las otras no. En el video no le puso modificador de acceso.

