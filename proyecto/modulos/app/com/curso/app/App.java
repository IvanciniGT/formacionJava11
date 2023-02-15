package com.curso.app;

import com.curso.diccionario.Diccionario;
import com.curso.diccionario.SuministradorDeDiccionarios;
import java.util.ServiceLoader;
import java.util.Iterator;

public class App {
    
    public static void main(String[] args){
        if(args.length != 2){
            System.err.println("No me has pasado idioma y palabra");
            System.err.println("Sintaxis java ... com.curso.app.App <IDIOMA> <PALABRA>");
            System.exit(1);
        }
        
        String idioma  = args[0];
        String palabra = args[1];
        
        Iterator<SuministradorDeDiccionarios> suministradores = ServiceLoader.load(SuministradorDeDiccionarios.class).iterator();
        if(!suministradores.hasNext()){
            System.err.println("No tengo un suministrador de diccionarios cargado");
            System.err.println("Sorry :(");
            System.exit(3);
        }
        
        Diccionario diccionario = null;
        while(suministradores.hasNext()){
            SuministradorDeDiccionarios suministrador = suministradores.next();
            if(suministrador.existeDiccionario(idioma) ){
                diccionario = suministrador.getDiccionario(idioma).get();
                break;
            }
        }
        if(diccionario == null) {
            System.err.println("No tengo un diccionario del idioma: "+ idioma);
            System.err.println("Sorry :(");
            System.exit(2);
        }
        
        if(diccionario.existe(palabra)){
            System.out.println("Si que existe la palabra: "+ palabra);
            System.out.println("Significados:");
            diccionario.getSignificados(palabra).get().stream().forEach(System.out::println);
        }else{
            System.out.println("NO que existe la palabra: "+ palabra);
            System.out.println("Quizas quisiste decir:");
            diccionario.getSugerencias(palabra).stream().forEach(System.out::println);
        }
        
    }
    
}