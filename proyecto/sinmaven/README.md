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

1. Subproyecto: API de la libreria de DICCIONARIOS
3. Subproyecto: Crear la implementación del diccionario (BBDD, Fichero, Servicios REST)
    Java11 
2. Subproyecto: Crear la app de consola

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
    
    
    
    
    SuministradorDeDiccionariosDesdeFicheros
        ES
        FR
        EN
    
    SuministradorDeDiccionariosDesdeBBDD
        RS
        CH
        




----
# Sugerencias de: manana

distanciaDeLevenstein(palabra1, palabra2) -> int 
Ese entero es la diferencia entre las 2 palabras, medida en el número de 
caracteres que habría que cambiar(añadir o eliminar)de una palabra para llegar a la otra
                    
                    distancia
manana - manzana        1
manana - manzano        2
manana - mañana         1

// Le vamos a meter un diccionario con 650k

Voy a intentar hacer el mejor uso posible de mis Cores (CPU) ~> Hilos

- Calcular la distancia para todas las claves del diccionario
- Filtrar aquellas que la distancia sea mayor que un valor dado.   <= 2
- Ordenar de menor a mayor puntuación
    // Qué tal se le da a un ordenador, ordenar? COMO EL CULO !
- Cortamos en 10
- Devolver las palabras



BUSCAR = manana

claves=palabras
del diccionario
  V                          STREAM                         STREAM                  STREAM                      STREAM
STREAM     - MAP palabra ->  distancia -> filtrar <= 2  ->          -> sorted  ->           --> limit(10). ->           --->   que podría devolver  
                                                                                                                                una lista de numeros
manzana                        S( 1, manzana )              S( 1, manzana )          S( 1, manzana )            S( 1, manzana )  -> manzana
manzano                         2, manzano                    2, manzano.            1                           1
mañana                          1, mañana                     1, mañana              2                           2
federico                        8, federico
....
600k

En la terminal : manana

La palabra manana no existe en el dicionario.
Quizás quisiste decir:
    manzana
    mañana
    manzano


Mete 4 gbs de RAM 
Si el checo llega el dia 1 le cargo y a la memoria
Si el ruso llega el dia 2 le cargo y a la memoria
Si el aleman llega el dia 3 le cargo y NO HAY MEMORIA, me cargo el checo y el ruso y hago hueco
Si el checho llega el dia 5 le cargaré otra vez...
Gracias a dios... si no lo hubviera quitao no habria sistema (OUT OF MEMORY)
