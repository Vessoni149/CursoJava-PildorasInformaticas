package ConceptosBasicos;

import java.sql.SQLOutput;
import java.util.*;
public class Enum11 {
//Sirve para almacenar en una variable una serie de valores que son constantes, no se pueden modificar.
//Es una variable objeto de tipo enum don de se puede almacenar un grupo de valores.
//Deben ser declarados fuera del metodo main.

    //Ej de creacion de un enum:
    //enum Talla {MINI,MEDIANO,GRANDE,MUY_GRANDE};
    public static void main(String[] args) {
        //Talla s = Talla.MINI;
        //Talla m = Talla.MEDIANO;
        //Talla l = Talla.GRANDE;
        //Talla xl = Talla.MUY_GRANDE;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe una talla: Mini, Mediano, Grande o MUY_GRANDE");
        String entrada_datos = entrada.next().toUpperCase();
        //Valueof devuele el nombre de la cosntante enumerada. Acá detecta el string que se ingreso para buscarlo en el enum. Busca el dato por nombre no por indice, x eso como segundo parametro le pasamos un string.
        Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
        System.out.println("Talla= " + la_talla);
        System.out.println("Abreviatura = " + la_talla.dameAbreviatura());
    }

    //Adicionalmente los tipos enum nos permiten usar cosntructores y metodos getters y setters:
    enum Talla{
        MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
        private Talla(String abreviatura){
            //Debe ser private para no poder crear instancias desde fuera del cosntructor.
            this.abreviatura = abreviatura;
        }
        public String dameAbreviatura(){
            return abreviatura;
        }
        private String abreviatura;
    }
}

