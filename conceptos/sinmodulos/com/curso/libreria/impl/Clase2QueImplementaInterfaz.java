package com.curso.libreria.impl;

import com.curso.libreria.Interfaz;

public class Clase2QueImplementaInterfaz implements Interfaz{
    
    public String dameTexto(){
        return "Hola desde la clase 1 que implementa la Interfaz";
    }
    
    public String dameOtroTextoMas(){
        return "Hola también desde la clase 1 que implementa la Interfaz";
    }

}

