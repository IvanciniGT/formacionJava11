Aplicación de consola, que cuando la llame me permita suministrar una palabra
y un idioma.

La aplicación mirará en un diccionario si la palabra existe o no

Si existe, me dará su(s) significado(s)

Si no existe me ofrecerá sugerencias del tipo: QUISISTE DECIR?????

P. Ejemplo:

Palabra: manzana 
Idioma: ES

Respuesta sería: SI, es el fruto del manzano.

Palabra: manana 
Idioma: ES

Respuesta sería: NO, quizás quisiste decir:
- manzana
- manzano
- mañana

Teneis 3 personas para esto:

- Subproyecto: API de la libreria de DICCIONARIOS
- Subproyecto: Crear la implementación del diccionario (BBDD, Fichero, Servicios REST)
- Subproyecto: Crear la app de consola

Y quiero equipos de trabajo independientes: REPOS DE GIT independientes


----

Necesito definir un API

Interfaz: SuministradorDeDiccionarios

    boolean existeDiccionario(String idioma);

    Optional<Diccionario> getDiccionario(String idioma);
        null                    - Una práctica HORRIBLE
        lanzar una Exception    - Una práctica HORRIBLE

Interfaz: Diccionario

    boolean existe(String palabra);

    Optional<List<String>> getSignificados(String palabra);
    
    // Y si la palabra no existe?
        // null                 Ni se explicita en la definición de la función, me tengo que ir a la DOCU
        // lista vacia          // Si se explicitaría. Pero
        //                      Es lo mismo devolver 5 que 3 que 10 que 1 que ninguna definición a nivel CONCEPTUAL?
        // exception            // No uso excepciones para controlar lógica

    List<String> getSugerencias(string palabra);
    
    default List<String> autoCompletar(String trozoPalabra){
        // Operacion no disponnible todavía... En breve tendrá una nueva versión de esto!
    }

---> Cómo se lo hago llegar a la gente de esos proyectos -> diccionario-1.0.0.jar

NO QUIERO UN UNICO PROYECTO:

    app diccionario
        com
            miempresa
                    app
                    diccionario
                        impl

---
Tengo 3 proyectos:

# API

com.curso.diccionario
                     public interface Diccionario.java
                     public interface SuministradorDeDiccionarios.java
                        getInstance()
                        getDefault()

# IMPLEMENTACION API a FICHEROS

com.curso.diccionario.ficheros
                              .diccionario
                                 public DiccionarioEnFichero.java  implemnents Diccionario
                                    import com.curso.diccionario.Diccionario
                             
                              .suministrador
                                public SuministradorDeDiccionariosDesdeFicheros.java implements SuministradorDeDiccionarios
                                    import com.curso.diccionario.Diccionario
                                    import com.curso.diccionario.SuministradorDeDiccionarios

    Este proyecto, de cuál tiene dependencia? API
    

# APP CONSOLA

com.curso.app
             App.java
             
                import com.curso.diccionario.Diccionario;
                import com.curso.diccionario.SuministradorDeDiccionarios;

                main(String[] args){
                    SuministradorDeDiccionarios sD1 =  ?????; // Que no dependiese de la IMPL
                    Diccionario d = sD1.getDiccionario("ES");
                    new DiccionarioDesdeFichero(); // No estuviera permitido
                }

    Este proyecto , de cuál tiene dependencias? API
    
    