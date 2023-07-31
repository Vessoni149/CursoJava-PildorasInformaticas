package ProgramaionGenerica.ArrayList.ClasesGenericasPropias;

public class UsoPareja2 {
    public static void main(String[] args) {
        Pareja1<String> una = new Pareja1<String>();
        una.setPrimero("Juan");
        System.out.println(una.getPrimero());
        //Ahora vamos a instanciar un objeto de tipo persona y una Pareja de tipo Persona.
        Persona pers1 = new Persona("Ana");
        Pareja1<Persona> otra = new Pareja1<Persona>();
        otra.setPrimero(pers1);
        System.out.println(otra.getPrimero());//Para ver el nombre hay que sobreescribir el metodo ToString
    }
}

class Persona{
    private String nombre;
    public Persona(String nombre){
        this.nombre = nombre;
    }
    public String toString(){
        return nombre;
    }
}