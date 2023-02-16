module diccionarioFicheros {
    
    requires diccionario;
    
    provides com.curso.diccionario.SuministradorDeDiccionarios 
        with com.curso.diccionario.ficheros.SuministradorDeDiccionariosDesdeFicheros ;
        
}