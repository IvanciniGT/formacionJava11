package es.curso.app;

import com.curso.libreria.Clase;
import com.curso.libreria.Interfaz;             // Inversión de dependencias
import java.util.ServiceLoader;                 //JAVA 9

public class App{
    
    public static void main(String[] args){
        
        Clase clase = new Clase();
        System.out.println(Clase.dameTexto());
        System.out.println(clase.dameNumero());

        Iterable<Interfaz> interfaces = ServiceLoader.load(Interfaz.class); // Inyección de dependencias
                                        // OJO, NOTA: 
                                        // Esto se comporta como un SINGLETON !
        for ( Interfaz interfaz : interfaces ) {
            System.out.println(interfaz.dameTexto());
            try{
                System.out.println(interfaz.dameOtroTextoMas());
            }catch(Exception e){
                System.out.println("Operación dameOtroTextoMas no implementada en esta interfaz");
            }
        }
    
    }

}