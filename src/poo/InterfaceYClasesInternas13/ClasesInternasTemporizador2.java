package poo.InterfaceYClasesInternas13;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//Aca vamos a usar el ejemplo de "InterfacesPruebaTemporizado1" pero le aplicaremos clases internas.

//Clases internas:
//Basicamente es una clase adentro de otra.
//Se usan para:
//Poder acceder mediante la clase interna a los campos privados de una clase externa sin necesidad de usar metodos de acceso
//Para ocultar la clase interna de otras clases pertenecientes al mismo paquete.
// PAra crear clases internas anonimas (utiles para gestionar eventos y retrollamadas)
//Y cuando solo una clase debe acceder a los campos de esa case.
public class ClasesInternasTemporizador2 {
    public static void main(String[] args) {
        Reloj miReloj = new Reloj(3000, true);
        miReloj.enMarcha();

        JOptionPane.showMessageDialog(null,"Pulsa aceptar para terminar.");

    }
}


class Reloj {
    private int intervalo;
    private boolean sonido;
    public Reloj(int intervalo, boolean sonido){
        this.intervalo = intervalo;
        this.sonido = sonido;
    }
    public void enMarcha(){
        ActionListener oyente = new DameLaHora2();
        Timer miTemporizador = new Timer(intervalo, oyente);
        miTemporizador.start();
    }

    //Acá crearemos la clase interna DameLaHora2:
    //El modificador e acceso private solo lo pueden tener las clases internas.
    private class DameLaHora2 implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            Date ahora = new Date();
            System.out.println("Te doy la hora cada: " + ahora);

            //Acá la clase interna está accediendo a sonido, que es una variable que no está definida dentro de esta clase interna, esta en la clase externa que la engloba.
           //Entonces no necesitamos crear los metodos de acceso.
            if(sonido){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }


}

