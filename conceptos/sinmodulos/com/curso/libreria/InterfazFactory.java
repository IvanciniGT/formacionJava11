package com.curso.libreria;

import com.curso.libreria.impl.Clase1QueImplementaInterfaz;
import com.curso.libreria.impl.Clase2QueImplementaInterfaz;

public class InterfazFactory{
    
    public static Interfaz dameInstanciaDeTipo1(){
        return new Clase1QueImplementaInterfaz();
    }
    public static Interfaz dameInstanciaDeTipo2(){
        return new Clase2QueImplementaInterfaz();
    }

}