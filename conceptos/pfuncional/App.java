// javac App.java + java App
// java App.java                    JAVA 11
// Qué tal veis ese cambio? 
// Una gilipollez pa' los de JS y Python

// Nuestras necesidades de compilación 
// van más allá de ejecutar el javac o no ejecutarlo

// Nosotros nos dedicamos al DESARROLLO DE SOFTWARE
// No es compilar... 
// De entrada para compilar necesito 30 dependencias
// Que a su vez tienen 500 dependencias
// Compilar casos de prueba unitaria

// maven / gradle /sbt

import java.util.function.*;        // Java 1.8
import java.util.List;              // Java 1.8

public class App {
 
    public static void main(String[] args){
        
        System.out.println( App.doblar(10) );
        System.out.println( App.mitad( 10) );
        
        //var numero = 3+9;
        var texto  = "hola";                         // JAVA 10
        imprimirResultado( App::doblar, 20);
        
        Function<Double, Double> funcion=(Double numero) -> {
            return numero * 2;
        };
        
        imprimirResultado( funcion , 20);

        imprimirResultado( (Double numero) -> {
                                                    return numero * 3;
                                                } , 20);

        imprimirResultado( numero -> numero * 3 , 20);
        
        // Expresiones lambda: Expresión (que devuelve un resultado) que permite definir 
        // una función anónima
        
        List<String> miLista = List.of("Texto1", "TEXTO2", "texto3"); // Cómodo
            // Java 9, como desde Java 8 podemos meter código estático en las interfaces
            // Nos crearon las funciones .of en todos los interfaces de Collections
            // Todas estas funciones devuelven colecciones INMUTABLES 
        //Arrays.asList()
        //new ArrayList();
        //miLista.add("TExto 1");
        //miLista.append("texto 2");
        //miLista.append("TEXTO 3");
        
        // Cómo la itero?
        // Pre JAVA 1.5
        for (int indice=0; indice < miLista.size(); indice++) {
            System.out.println(miLista.get(indice));
        }
        // Pre JAVA 1.8
        for (String texto2 : miLista) {
            System.out.println(texto2);
        }
        // Post JAVA 1.8
        miLista.stream().forEach(System.out::println); // Siendo esto MUCHO MAS EFICIENTE
        
        // Además los STREAMS nos permiten usar patrones MAP REDUCE de programación para manipular datos
        // Funciones MAP: Devuelven otro Stream
        //     map flatMap sorted filter
        // Funciones Reduce: Ya no devuelven un Stream
        //     collect forEach
        miLista.parallelStream()                                        // Obtengo mis datos para procesamiento en paralelo
                        // .map(    texto -> texto.toUpperCase()   )
                        .map(      String::toUpperCase              )   // Los pongo en mayusculas
                        .filter(   unTexto -> unTexto.endsWith("2") )   // Me quedo con los que acaban en 2
                        .forEach(  System.out::println              );  // Los imprimo
        
        for (String texto2 : miLista) {
            if( texto2.endsWith("2")){
                System.out.println(texto2.toUpperCase());
            }
        }
        
    }
    
    public static void imprimirResultado(Function<Double,Double> operacion, double numero){
        System.out.println( operacion.apply(numero) );
    }
    
    public static double doblar(double numero){
        return numero * 2;
    }
    public static double mitad(double numero){
        return numero / 2;
    }
    
}