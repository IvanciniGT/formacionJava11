module libreria {

    // Paquetes que otros módulos queiero que puedan usar
    exports com.curso.libreria;
    
    provides com.curso.libreria.Interfaz with com.curso.libreria.impl.Clase1QueImplementaInterfaz,
                                              com.curso.libreria.impl.Clase2QueImplementaInterfaz;
}