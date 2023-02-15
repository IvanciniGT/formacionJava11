package com.curso.diccionario.ficheros;

import  com.curso.diccionario.Diccionario;

import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DiccionarioDesdeFichero implements Diccionario {

    private Map<String, List<String>> terminos;

    public DiccionarioDesdeFichero(Map<String, List<String>> terminos){
        this.terminos=terminos;
    }

    public boolean existe(String palabra){
        return terminos.containsKey(Utilidades.normalizarPalabra(palabra));
    }

    public Optional<List<String>> getSignificados(String palabra){
        return Optional.ofNullable(terminos.get(Utilidades.normalizarPalabra(palabra)));
    }

    public List<String> getSugerencias(String palabra){
        final String palabraABuscar = Utilidades.normalizarPalabra(palabra);
        
        return   this.terminos.keySet()             // Tomo las claves (las palabras que existen en mi diccionario)
                              .parallelStream()     // Voy a intentar hacer el mejor uso posible de mis Cores (CPU) ~> Hilos
                              .map(     termino    -> new Sugerencia(Utilidades.distancia(termino, palabraABuscar), termino)    )  // Calcular la distancia para todas las claves del diccionario
                              .filter(  sugerencia -> sugerencia.distancia <= Utilidades.DISTANCIA_MAXIMA_PERMITIDA             )  // Filtrar aquellas que la distancia sea menor o igual que un valor dado.   <= 2
                              .sorted(  Comparator.comparing( sugerencia -> sugerencia.distancia )                              )  // Ordenar de menor a mayor puntuación
                              .limit(   Utilidades.MAXIMOS_A_DEVOLVER                                                           )  // Cortamos en 10
                              .map(     sugerencia -> sugerencia.termino                                                        )  // Me deshago de la distancia
                              .collect( Collectors.toList()                                                                     ); // A una lista
        /*
        List<Sugerencia> sugerencias =new ArrayList();
        for (String termino : this.terminos.keySet()){
            int distancia = Utiliudades.distancia(termino,palabraABuscar );
            Sugerencia sugerencia= new Sugerencia(distancia, termino);
            sugerencias.add(sugerencia);
        }
        */
        
    }
    
    private static class Sugerencia {
        public int distancia;
        public String termino;

        Sugerencia(int distancia,String termino){
            this.distancia=distancia;
            this.termino=termino;
        }
    }
}