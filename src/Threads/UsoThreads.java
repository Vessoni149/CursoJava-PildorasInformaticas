package Threads;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
//Este programa abre una ventana que hace mover una pelota.
//Usaremos el metodo sleep para que se renderice la peloca cada x milisegundos para generar la sensacion de movimiento
//Ese metodo viene de la clase Thread, que se usa para manejar varios hilos de ejecucion.

public class UsoThreads {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco=new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}
}
//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota{
	// Mueve la pelota invirtiendo posición si choca con límites
	public void mueve_pelota(Rectangle2D limites){
		x+=dx;
		y+=dy;
		if(x<limites.getMinX()){
			x=limites.getMinX();
			dx=-dx;
		}
		if(x + TAMX>=limites.getMaxX()){
			x=limites.getMaxX() - TAMX;
			dx=-dx;
		}
		if(y<limites.getMinY()){
			y=limites.getMinY();
			dy=-dy;
		}
		if(y + TAMY>=limites.getMaxY()){
			y=limites.getMaxY()-TAMY;
			dy=-dy;
		}
	}
	//Forma de la pelota en su posición inicial
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}
	private static final int TAMX=15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
}
// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel{
	//Añadimos pelota a la lámina
	public void add(Pelota b){
		pelotas.add(b);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Pelota b: pelotas){
			g2.fill(b.getShape());
		}
	}
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}
//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame{
	public MarcoRebote(){
		setBounds(600,300,600,350);
		setTitle ("Rebotes");
		lamina=new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();

		arranca1 = new JButton("Hilo1");
		arranca1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);
			}
		});
		laminaBotones.add(arranca1);

		arranca2 = new JButton("Hilo2");
		arranca2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);
			}
		});
		laminaBotones.add(arranca2);

		arranca3 = new JButton("Hilo3");
		arranca3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);
			}
		});
		laminaBotones.add(arranca3);

		detener1 = new JButton("Detener1");
		detener1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});
		laminaBotones.add(detener1);

		detener2 = new JButton("Detener2");
		detener2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});
		laminaBotones.add(detener2);

		detener3 = new JButton("Detener3");
		detener3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});
		laminaBotones.add(detener3);

		/*ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego();
			}
		});
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				System.exit(0);
			}
		});

		ponerBoton(laminaBotones, "Detener", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				detener();
			}
		});*/
		add(laminaBotones, BorderLayout.SOUTH);
	}
	//Ponemos botones
	/*public void ponerBoton(Container c, String titulo, ActionListener oyente){
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}*/
	//Añade pelota y la bota 1000 veces



	//------------------THREADS---------------------


	//Para crear hilos de ejecucion:
	//1) Crear una clase que implemente la interfaz Runnable (que va a tener que sobreescribir el metodo run()). Otra forma seria crear una clase que herede de Thread.
	//2) Escribir el codigo de la tarea dentro del metodo run()
	//3) Intanciar la clase creada y almacenar la isntancia en variable de tipo Runnable.
	//4) Crear instancia de la clase Thread pasando como parámetro al constructor de Thread el objeto Runnable anterior
	//5) Poner en marcha el hilo de ejecucion con el metodo start() de la clase Thread.

	//Paso 1:
	class PelotaHilos implements Runnable{

		private Pelota pelota;
		private Component componente;
		public PelotaHilos(Pelota unaPelota, Component unComponente){
			pelota = unaPelota;
			componente = unComponente;
		}

		//Paso 2:
		//dentro del metodo run tiene que estar la tarea que querramos que sea simultanea. En este caso será el bucle for:
		@Override
		public void run() {
			for (int i=1; i<=3000; i++){
				pelota.mueve_pelota(componente.getBounds());
				componente.paint(componente.getGraphics());
				try {
					Thread.sleep(4);		//el metodo sleep hace una pausa en la ejecucion del hilo.
					//Sleep bloque el hilo en ese tiempo, lo que quiere decir que no podemos hacer nada con el hilo en ese tiempo, ni si quiera solicitar la interrupcion.
					//Si llegamos a querer interrumpir el hilo se lanzaria la "InterruptedException".
				} catch (InterruptedException e) {
					//throw new RuntimeException(e);	//Así solo mostraria el error
					//System.out.println("Hilo bloqueado, no se puede interrumpir");
					//System.exit(0);	//con esta instruccion saldria de la ventana terminando el proceso.
					Thread.currentThread().interrupt();
				}
				//Esto sigue siendo monotarea, si le damos al boton "dale" se va a ejecutar una vez termine el primer bucle. Tampoco podremos salir hasta que termine el hilo de ejecucion de la pelota.
			}
		}
	}


	//Metodos de interrupcion de la clase Thread:
	//void Interrupt()	Solicita la interrupcion de un hilo en ejecucion.
	//Static boolean interrupted()	retorna si un hilo actual está interrumpido o no. Se puede aplicar a cualquier hilo.
	//boolean isInterrupted()		retorna si este hilo está interrumpido o no. Se aplica a una instancia, a un hilo en concreto
	//stop()						detiene la ejecucion del hilo, pero esta obsoleto. DEPRECATED.
	public void detener(ActionEvent e){
	//t.stop();				//a pesar de la obsolecencia, funciona.
	//t1.interrupt();			//como se comento en el comentario del metodo sleep(), al solicitar la interrupcion de un hilo que esta "durmiendo" sale la InterruptedException.
	//para usar estos metodos de interrupcion no deberiamos usar el merodo sleep,  aca lo usamos solo para que se vea la bola, pero normalmente en un hilo no lo usariamos.
		
	if(e.getSource().equals(detener1)){		//si el origen del evento fuera detener1:
		t1.interrupt();
	}
	if(e.getSource().equals(detener2)){
		t2.interrupt();
	}
	if(e.getSource().equals(detener3)){
		t3.interrupt();
		}
	}




	public void comienza_el_juego (ActionEvent e){
			Pelota pelota=new Pelota();
			lamina.add(pelota);

			//paso 3:
		Runnable r = new PelotaHilos(pelota, lamina);
		//paso 4:
		// t1 = new Thread(r);
		//paso 5:
		//t1.start();
		if(e.getSource().equals(arranca1)){
			t1 = new Thread(r);
			t1.start();
		}
		if(e.getSource().equals(arranca2)){
			t2 = new Thread(r);
			t2.start();
		}
		if(e.getSource().equals(arranca3)){
			t3 = new Thread(r);
			t3.start();
		}
	}
//Variables a nivel de la clase:
	Thread t1,t2,t3;
	JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;

	private LaminaPelota lamina;


	
}


//Estados de los hilos:
//Nuevo: es el primer estado, caundo se intancia el Thread, antes de llamar al metodo start
//Ejecutabe: cuando llamamos al metodo statr y comienza la tarea
//bloqueado: por el metodo sleep
//muerto: cuando el hilo termina la tarea, o cuando ocurre una excepcion y no se captura

//sincronizacion de hilos: