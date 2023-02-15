package com.curso.diccionario;

import java.util.Optional;

public interface SuministradorDeDiccionarios {

    boolean existeDiccionario(String idioma);

    Optional<Diccionario> getDiccionario(String idioma);
}