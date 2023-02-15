package es.curso.app;

import com.curso.libreria.Clase;
import com.curso.libreria.Interfaz;             // Inversión de dependencias
import com.curso.libreria.InterfazFactory;             

// Me meo en el Principio de Inversión de dependencias.
// Ya que YA no dependo de Interfaces, sino de Implementaciones
import com.curso.libreria.impl.Clase1QueImplementaInterfaz;
import com.curso.libreria.impl.Clase2QueImplementaInterfaz;



public class App{
    
    public static void main(String[] args){
        
        Clase clase = new Clase();
        System.out.println(Clase.dameTexto());
        System.out.println(clase.dameNumero());

        //Interfaz interfaz1 = new Clase1QueImplementaInterfaz();
        //Interfaz interfaz2 = new Clase2QueImplementaInterfaz();
        Interfaz interfaz1 = InterfazFactory.dameInstanciaDeTipo1(); // Inyeccion de dependencias!
        Interfaz interfaz2 = InterfazFactory.dameInstanciaDeTipo2(); // Inyeccion de dependencias!
        /*
        En informática, inyección de dependencias es un patrón de diseño orientado a objetos, 
        en el que se suministran objetos a una clase en lugar de ser la propia clase la que 
        cree dichos objetos. 
        
        Esos objetos cumplen contratos que necesitan nuestras clases para poder funcionar
        */

        // App ya no depende de implementaciones... bueno un poco.
        // Sigue importando una clase... no solo una interfaz:
        // InterfazFactory
        System.out.println(interfaz1.dameTexto());
        System.out.println(interfaz2.dameOtroTextoMas());
        System.out.println(interfaz2.dameTexto());
        
        // Problema? IMPORTANTE DE SEGURIDAD y con IMPLICACIONES IMPREVISIBLES 
        Interfaz interfaz3 = new Clase1QueImplementaInterfaz();
        Interfaz interfaz4 = new Clase2QueImplementaInterfaz();
        System.out.println(interfaz3.dameTexto());
        System.out.println(interfaz4.dameOtroTextoMas());
        System.out.println(interfaz4.dameTexto());

    }

}