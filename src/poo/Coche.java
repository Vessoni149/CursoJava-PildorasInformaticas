package poo;
//dentro de esta clase no vamos a crear un metodo main.
public class Coche {
    int ruedas;
    private int largo;
    int ancho;
    private int motorCm2;
    int pesoPlataforma;
    //las sgts no están en el constructor:
    //se asignarán con los metodos setters.
    String color;
    int pesoTotal;
    boolean asientoCuero, climatizador;

    public Coche(int ruedas, int largo, int ancho, int motorCm2) {
        this.ruedas = ruedas;
        this.largo = largo;
        this.ancho = ancho;
        this.motorCm2 = motorCm2;
        //también se puede definir un valor acá mismo antes de instanciar el objeto, no siendo necesario que ésta propiedad esté como parámetro en el constructor.
        pesoPlataforma = 500;

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

    public int getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(int peroTotal) {
        this.pesoTotal = peroTotal;
    }

    public boolean isAsientoCuero() {
        return asientoCuero;
    }

    public void setAsientoCuero(boolean asientoCuero) {
        this.asientoCuero = asientoCuero;
    }

    public boolean isClimatizador() {
        return climatizador;
    }

    public void setClimatizador(boolean climatizador) {
        this.climatizador = climatizador;
    }
}
