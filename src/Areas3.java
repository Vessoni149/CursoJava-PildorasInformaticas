import javax.swing.*;
import java.util.Scanner;

public class Areas3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Círculo ");
        int figura = entrada.nextInt();

        switch(figura){
            case 1:
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado:"));    //parseInt y ShowInputDialog es un metodo static, x eso se llama asi.
                //lo que indicamos con la linea anterior es pasame a entero lo que el usuario ponga en el jOpionPane. ëste crea el recuadro para poner datos y el metodo escribe en él lo que le pasemos como argumento.
                System.out.println("El área del cuadrado es " + Math.pow(lado,2));
                break;
            case 2:
                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base:"));
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura:"));
                System.out.println("El área del rectángulo es: " + base*altura);
                break;
            case 3:
                base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base:"));
                altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura:"));
                System.out.println("El área de el triángulo es: " + (base * altura) /2);
                break;
            case 4:
                int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio:"));
                System.out.print("El área del círculo es: ");   //aca usamos print solo para que la linea de abajo se escriba al lado de esta.
                System.out.printf("%1.2f", Math.PI * (radio*radio));       //y acá le damos formato al resultado para que no tenga tantos decimales.
                break;
            default:
                System.out.println("La opción no es correcta.");
        }


    }
}
