# Procesar fichero del diccionario

Mapa:
    split(=)
    
    clave: melón [0]
    valor:       [1] .split(|)-> Convertir en una lista
        Fruto del melonero              
        Persona cortita de entendederas
        

## Trabajando con Streams

# Función map()

stream(n elementos) -> stream(n elementos)

donde a cada elemento del conjunto de salida le ponemos como valor el resultado (return) de la función de map aplicada sobre el correspondiente dato de entrada

# Función flatMap()
stream(n elementos) -> stream(m elementos)

Un transformación flapMap toma una funcion F que devuelve un ITERABLE(no un elemento , sino una coleccion de elementos)

MAP 
STREAM      -> split(",") -> List.  -> DESTINO
"1,2,3"                                 List.of(1,2,3)
"1"                                     List.of(1)
"5,6"                                   List.of(5,6)

FLATMAP
STREAM      -> split(",") -> List   -> DESTINO
"1,2,3"                                     1
                                            2
                                            3
"1"                                         1
"5,6"                                       5
                                            6
-----
FlatMap

Definicion1                             String
    List<String>                        String
                                        String
    
Definicion2                             String
    List<String>                        String
    
    
----

# REPASO MODULOS

Hasta Java 8 en Java las clases/interfaces se econtraban en paquetes.

Y los paquetes los teníamos en un proyecto.

proyecto
    paquetes
        clases/interfaces

** En esta estructura me es muy complejo montar paquetes (componentes) NO ACOPLADOS

ESTO NOS LLEVABA A TRABAJAR EN PROYECTOS MONOLITICOS !

Ya no queremos PROYCETOS MONOLITICOS:
- No respetan el principio de INVERSION DE DEPENDENCIAS
- No respetan el principio de INYECCION DE DEPENDENCIAS
- Presentan un problema de seguridad y comportamientos impredecibles al permitir a un componente 
  acceder directamente a implementaciones de otro componente a las que NO DEBERIAN TENER ACCESO

Todo eso:
- dificulta el mantenimiento de un sistema
- su evolución
- la corrección de errores
- NUNCA MAIS !!!!!


Para resolver estos problemas surjen los MODULOS en JAVA 9

Desde este momento tenemos un NUEVO NIVEL EN LA JERARQUIA DE OBJETOS JAVA

proyecto
    modulos
        paquetes
            clases/interfaces
            
** En esta estructura se me impone montar paquetes (componentes) CON UN NIVEL DE ACOPLAMIENTO BAJO
    (que solo dependan de INTERFACES)

Cada modulo es una colección de paquetes que:

- Puede requerir de otros modulos para su funcionamiento                                    requires
  (hacer imports de clases/interfaces que se hayan definido en otros modulos)

- Pueden ofrecer unos determinados paquetes para su uso (importación) por otros modulos     exports

- Los modulos pueden ofrecer IMPLEMENTACIONES DE INTERFACES que otros modulos 
  quieran usar a traves en forma de SINGLETON
                                                                                            provides

- Los modulos puedan solicitar IMPLEMENTACIONES DE UNA INTERFAZ en forma de SINGLETON       uses
  implementaciones ofrecidas por otros modulos... sin saber a quien se la piden.
        INYECCION DE DEPENDENCIAS   







Dia 1 de proyecto de hace 20 años:

1º Requisitos
2º Se oganiza...
3º A currar
    1º Si el proyecto tiene BBDD... qué es lo primero que tengo que hacer?
        El modelo de la BBDD y los scripts de creación de la BBDD
        
        Que tablas creo? 3, 5? TODO lo que voy a usar ahora y el año que viene!
        
---

Hoy en día eso no se hace: 

MONGODB

Empiezo a meter datos... en que modelo? En niguno. Si en Mongo no existe ese concepto. ALMACEN 

A lo mejor cuando acabo el proyecto, que ya tengo claro lo que necesito guardar.
Meto unas validaciones de entrada a los datos.