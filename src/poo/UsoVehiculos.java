package poo;

public class UsoVehiculos {
    public static void main(String[] args){
        Coche6 miCoche1 = new Coche6();
        miCoche1.setColor("Rojo");
        Furgoneta miFurgoneta1 = new Furgoneta(7, 580);
        miFurgoneta1.setColor("Azul");
        miFurgoneta1.setAsientoCuero("Si");
        miFurgoneta1.setClimatizador(true);

        System.out.println(miCoche1.getDatosGenerales() +" "+ miCoche1.getColor());
        System.out.println(miFurgoneta1.getDatosGenerales() + " " + miFurgoneta1.dimeDatosFurgoneta());
    }

}
