package ProgramaionGenerica.ArrayList.ClasesGenericasPropias;


//Los metodos genericos pueden ser construidos en clases genericas o normales.
public class MetodosGenericos3 {
    public static void main(String[] args) {
        String nombres[]= {"Jose", "Maria", "Pepe"};

        System.out.println(MisMatrices.getMenor(nombres));


    }

}

//Esta clase tendra el metodo geenrico que devolvera un array. Podra recibir cualtier tipo de parametro.
class MisMatrices{
    public static <T extends Comparable> T getMenor(T[]a){    //conv <T> antes del tipo de dato indicamos que el metodo es generico, y en los parametros T[] significa que recibira como parametro cualquier tipo de objeto. "a" es solo el nombre del parametro.
       //Para que un metodo implemente (extrañamente con la palabra extends) una interfaz hay que definirlo así. Lo que quiere decir es que todos los argumentos que le pasemos al metodo, tengan que ser objetos que implementen la interfaz Comparable.
        if(a == null || a.length==0){
            return null;
        }
        //esta porcion de codigo comparara el eemento 0 del array con los otros.
        T elementoMenor = a[0];
        for(int i = 1; i<a.length;i++){
            if(elementoMenor.compareTo(a[i]) > 0) {     //CompareTo ocmpara un objeto con otro objeto y devuele un num negativo si es menor, 0 si es igual o un num positivo si es mayor.
                elementoMenor = a[i];
            }
        }
        return  elementoMenor;
    }
}

//La herencia no funciona igual en las clases genericas. El ppio de sustitucion (es un) no funciona.
//Ej hemos visto antes con los ejemplos de Empleado y Jefe que un Jefe es un Empleado pero no al revez, y que podemos en un array de tipo Empleados meter a una instancia e tipo Jefe por este ppio.
//Esto no es asi con clases genericas.
//Esto se soluciona usando tipos genericos.
//a la hora de especificar el argumento que va a recibir un metodo, podemos incluir seguidamente del tipo de dato <? extends Clase>, ej:
//public static void imprimirTrabajador(Pareja<? extends Empleado> p){...
//Así, el metodo podra recibir como parametro un tipo Empleado o una subclase de Empleado.