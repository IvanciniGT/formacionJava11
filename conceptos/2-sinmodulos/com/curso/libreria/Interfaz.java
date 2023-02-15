package com.curso.libreria;

public interface Interfaz{
    
    String dameTexto();
    
    // Java 1.8 - Funciones estáticas PUBLICAS
    // Para que sirven estas funciones?
    // Para que querria meter esta función en una clase? ESTA SERIA LA PREGUNTA
    // Que es una funciones estática?  Cuando no necesito instancia de la clase para su ejecución.
    // Y si no necesito instancia de una clase... para que lo queiro en una clase? 
    // PORQUE  en JAVA habia una cagada en su sintaxis y no podíamos ponerlas en otro sitio. 
    // Ahi no pintaban NADA de NADA
    public static String dameOtroTexto(){
        return Interfaz.dameTextoOtro();
    }
    
    // En Java 1.9 se permiten meter las privadas estáticas en interfaces
    // Y esto pa que vale?
    // Pa lo mismo que las queria en las Clases..
    // Estructurar mejor el código
    // Permitirme reutilizar código
    private static  String dameTextoOtro(){
        return "Hola desde la Interfaz";
    }
    
    // Java 1.8
    // Implementaciones por defecto en interfaces
    // Para que vale esto? 
    // Si hay varias clases que implementan la interfaz y todas usan el mismo 
    // código para esta función lo eto aqui no? NI DE COÑA !!!!!!
    // Para que sirve una interfaz? 
    // Cual es su propósito? Definir un CONTRATO un API...
    // Cuanto códiigo quiero en una INTERFAZ? NADA , CERO, RIEN, NOTHING AT ALL !!!!!!!!
    // Te corto los dedos!
    
    // A no se que sean funciones estáticas. BIEN !
    // Pero entonces no estas usando la Interfaz para definir un API
    // Si no por que JAVA con sus chapuzas no da otro puñetero sitio donde poner funciones pelás!
    
    // Y si tengo 5 clases que van a tener la misma implementación de una función?
    // Que hago??? Para eso tenemos desde Java 1 las clases ABSTRACTAS ! Pa' meter codigo !
    
    // Ahora si que no entiendo na'. Pero PA QUE VALE ESTO !!!?!?!?!?
    // MANTENIBILIDAD !!!!!
    // Facilitar la evolución de componentes sin afectar a otros componentes
    default String dameOtroTextoMas(){
        throw new RuntimeException("Not implemented");
    }

}

// dia 1 .. defino mi interfaz FIGURA_GEOMETRICA
// con la función AREA()

// dia 2-200 Montonones de personas usan mi interfaz para montar sus clases

// dia 201, se me ocurre la brillante idea de añadir una funcionaldiad nueva en la interfaz:
// PERIMETRO

// dia 202: ESTOY MUERTO ! Me matan todos juntos

// Les meto una implementación DUMMY, pa que compile. Que no hace na. No tiene código valido
