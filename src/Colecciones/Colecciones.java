package Colecciones;

//Son almacenes de objetos dinamicos. La dif con los arrays es la dinamicidad, el array es fijo en su contenido, la coleccion no.
//el array puede almacenar objetos y tipos de dato primitivo, la coleccion solo objetos.
//Para trabajar con colecciones hay un framework que tienen una serie de interfaces:

                                //Collection
// Set              List            Queue                       Map
//SortedSet                                                    SortedMap

//Todo viene de la Interfaz Collection, de la que salen Set, List y Queue. Set tiene una subinterfaz SortedSet.
//por otro lado Map no viene de Collection. Es independiente y tiene una subinterfaz SortedMap.

//Set permite almacenar una coleccion de elementos NO REPETIDOS y SIN ordenar. ej: titulares de una cuenta bancaria.
//List permite elementos repetidos y estan indexados con valores numericos, es el sustituto del array pero para objetos. Se puede acceder al elemento que se necesite. List permite hacer mas cosas pero es menos eficiente que Set
//Queue no permite el acceso a cualquier elemento, solo se puede acceder a elementos que esten al inicio o al final de la cola o a ambos.
//Map permite crear una coleccion de elementos repetibles con una clave. se organiza en clave -> valor. Seria un array asociativo.

//Hay muchas clases de java que implementan estas interfaces. Esas clses son las que usaremos para trabajar los temas.

//List: Para crear colecciones de tipo List debemos usar las sgts clases:
//Arraylist, LinkedList, Vector o CopyOnWriteArrayList.
//La interface List tiene la ventaja de permitir el acceso aleatorio a los datos (se puede acceer a la posicion que querramos),
// Estan ordenadas y podemos usar el metodo sort() para ordenar las colecciones. Podemos añadir y eliminar elementos.
//Tenemos el ListIterator que es capaz de modificar la direccion de la lista.
//Tiene una sintaxis similar a la de un array.
//Inconveniente: bajo rendimiento en ciertas operaciones.
//Ventajas de cada List:
//ArrayList: muy rapida accediendo a elementor, se adapta a muchos escenarios
//LinkedList: son listas enlazadas. Muy eficientes añadiendo y eliminando elementos pero no tanto leyendolos. Ej si solo se va a agregar elementos 1 vez y despues se va a acceder a esos elementos muchas veces conviene ArrayList, en cambio si se van a estar añadiendo y eliminandos muchas veces elementso, es mejor LinkedList.
//Vector: esta obsoleta, se usaba en programacion concurremte.
//CopyOnWriteArrayList: se usa para programacion concurrente. Es eficiente en operaciones de lectura pero no de escritura.

//Sets:
//ventajas: no permiten elementos duplicados. El metodo add es sencillo y asegura elementos no duplicados.
//Desventajas: no tiene acceso aleatorio a sus datos. Poco eficiente para ordenar elementos.
//Clases que implementan la interfaz Set:
//HashSet   LinkedHashSet   TreeSet     EnumSet     CopyOnWriteArraySet     ConcurrentSkipListSet
//HashSet: rapida. no duplicados. no ordenacion. no acc. aleatorio.
//LinkedHashSet: ordenacion por entrada. Eficiente para acceder. No para agregar
//TreeSet: es ordenado. Poco eficinete
//EnumSet: La mejor para tipos enumerados
//CopyOnWriteArraySet: especifico para concurrencia. eficiente lectura. poco eficiente en escritura y en eliminar.
//ConcurrentSkipListSet: esfecifico concurrencia. admite ordenacion. Con muchos elementos no es eficiente.

/*
//Map:
ventajas: asociacion clave- valor. No permite claves iguales
desvneajas: poco eficiente comparada con las demas colecciones.
Clases que implementan la interfaz Map:
HashMap     LinkedHashMap       TreeMap     EnumMap     WeakHashMap     HashTable       CurrentHashMap
HashMap: no ordenacion. Eficiente
LinkedHashMap: ordenado por incersion. Permite ordenacion por uso. Eficiente en lectura, poco ef en escritura
TreeMap: ordenado por clave. Poco ef en todas sus operaciones.
EnumMap: permite enum como claves. Muy eficiente
WeakHashMap: usado para crear elementos que vaya borrando el sistema si no se usan. Muy poco eficiente
HashTable:obsoleto. usado en concurrencia
CurrentHashMap: usado en concurrencia. No permite nulos.

Queue:
entajas: muy rapido p acceder al primer y ultimo elemento. Permite crar colas muy eficientes (lifo/fifo).
desventajas:acceso lento a los elementos intermedios.
Clases que implementan la interfaz Queue:
ArrayDeque      LinkedBlockingDeque     LinkedList      PriorityQueue   PriorityBlockingQueue
ArrayDeque: gran eficiencia. La mas usada.
LinkedBlockingDeque: usado en prog. concurrente.
LinkedList: rendimiento inferior a ArrayDeque
PriorityQueue: Para utilizar un Comparator. El primer elem dependera de propiedad elegida
PriorityBlockingQueue: igual que el anterior pero mas eficiente en prog. concurrente.

















*/





public class Colecciones {


}
