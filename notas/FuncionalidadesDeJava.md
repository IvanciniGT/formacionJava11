JAVA 1.5
    Genericos
    Anotaciones
    Iterables

JAVA 1.8
    Programación funcional
        - libreria nueva: java.util.function
        - Operador ::           Referenciar a una función
        - Expresiones lambda
        - libreria nueva: java.util.stream
        - Cambio en paquete collections
    Introducción de los Optional
    Funciones estáticas Publicas en Interfaces
    Funciones por defecto en Interfaces
    Anotaciones en la definición de argumentos en funciones: Lombok (@NonNull)
    Api nuevo de Time (joda-time)
        Antes:
            - Calendar
            - java.util.Date (millis)
            - java.sql.Date
        Nuevo:
            - LocalDate
            - LocalDateTime
            - ZonedDateTime
            - Instant -> Antiguos -> Nuevos
            
JAVA 9 
    Modulos
        ServiceLoader (provides uses)
    Funciones .of en las interfaces de Collections: List, Map, Set
        Colecciones inmutables
    Capacidad de definir funciones estáticas provadas en interfaces
    JSHELL

JAVA 10
    Palabra var que nos ofrece inferencia de tipos
    Funciones .copyOf en las interfaces de Collections: List, Map, Set
        Copias inmutables
    Optional .orElseThrow()

JAVA 11
    Ejecución de .java directamente en la JVM
    Posibilidad de usar var en los parametros de las lambdas
    Files.writeString
         .readString
    String.lines()
          .isBlank()
    Rediseño del paquete de cliente HTTP. Paquete basado en patron builder
    
    HttpRequest miRequest = HttpRequest.newBuilder()
                                       .POST()
                                       .uri("https://miempresa.com/api/v1/miendpoint")
                                       .header("clave1","valor1")
                                       .header("clave2","valor2")
                                       .build();
                                       
    