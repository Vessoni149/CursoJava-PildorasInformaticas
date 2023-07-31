package poo;
//dentro de esta clase no vamos a crear un metodo main, lo creare en uso_coche6, donde se va a instanciar la clase
public class Coche6 {
    int ruedas;
    private int largo;
    int ancho;
    private int motorCm2;
    int pesoPlataforma;
    //las sgts no están en el constructor:
    //se asignarán con los metodos setters.
    private String color;
    private int pesoTotal;
    private boolean asientoCuero, climatizador;

    public Coche6(int ruedas, int largo, int ancho, int motorCm2) {
        this.ruedas = ruedas;
        this.largo = largo;
        this.ancho = ancho;
        this.motorCm2 = motorCm2;
        //también se puede definir un valor acá mismo antes de instanciar el objeto, no siendo necesario que ésta propiedad esté como parámetro en el constructor.
        pesoPlataforma = 500;

    }

    public Coche6(){
        ruedas =4;
        largo= 2000;
        ancho= 300;
        motorCm2= 1600;
        pesoPlataforma=500;
        pesoTotal= 1000;
    }

//los getters y setters siempre son public, para poder acceder a ellos desde cualquier otra clase en cualquier paquete.


    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    //por defecto el metodo getter va a retornar un tipo de dato = al dato que tiene que devolver. Acá x ej. largo es un int, pero si queremos que se retorne un string lo podemos modificar.
    //el metodo getter si o si debe retornar algo.
    public String getLargo() {
        return "El largo del coche es: " + largo;
    }

    //los metodos setters no llevan return xq no devuelven datos, por eso se usa void. No hay que esecificar el tipo de dato que retorna xq no retorna nada.
    //this sirve para cuando el nombre de la propiedad es igual al nombre del argumento del metodo, para distinguir cual es cual, this hará referenia a la propiead de la clase.
    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getMotorCm2() {
        return motorCm2;
    }

    public void setMotorCm2(int motorCm2) {
        this.motorCm2 = motorCm2;
    }


    public void setPesoPlataforma(int pesoPlatafoma) {
        this.pesoPlataforma = pesoPlatafoma;
    }

    public int getPesoPlataforma() {
        return pesoPlataforma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


//Vamos a crear un metodo que tenga comportamiento de getter y setter a la vez. No es lo mas recomendado en POO pero se puede hacer.
    //Recibira parametros y dependiendo de que reciba, devolverá ciertos datos.
    public String dimePesoTotal(){
        //aca declaramos una nueva variable que tendrá ámbito solo en este metodo.
        int pesoCarrocería = 500;
        pesoTotal = pesoPlataforma + pesoCarrocería;
        if(asientoCuero){
            pesoTotal = pesoTotal+50;
        }
        if (climatizador){
            pesoTotal = pesoTotal + 20;
        }
        return "El peso total del coche es:  " + pesoTotal;
    }

    //metodo para ver precio (no está declarada como propiedad:
    public int precioCoche(){
        int precioFinal=10000;
        if(asientoCuero){
            precioFinal+= 2000;
        }
        if (climatizador){
            precioFinal+=1500;
        }
        return precioFinal;
    }




    //acá modificaremos los tipos de dato de los metodos getter y setter de la variable asientoCuero que es originalmente boolean.
    public void setAsientoCuero(String asientoCuero) {
        //nunca debemos ocmparar strings con ==. Osea asientosCuero == "si"
        if (asientoCuero.equalsIgnoreCase("si")){
            this.asientoCuero = true;
        }else{
            this.asientoCuero = false;
        }
    }
    public String isAsientoCuero() {
        if (asientoCuero == true) {
            return "El coche tiene asientos de cuero";
        } else {
            return "El coche tiene asientos de serire";
        }
    }
    public boolean isClimatizador() {
        return climatizador;
    }

    public void setClimatizador(boolean climatizador) {
        this.climatizador = climatizador;
    }

    //acá creamos un metodo getter manualmente para que nos de varios datos en un solo metodo.
    public String getDatosGenerales(){
        return "La plataforma del auto riene " + ruedas + " ruedas" + ". Mide " + largo + " cms de largo y " + " cms. de ancho. Y tiene un peso total de " + pesoTotal + " kg.";
    }
}
