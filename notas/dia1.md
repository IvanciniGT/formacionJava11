# JAVA

Lenguaje de programación:

- Paradigmas: Forma de uso del lenguaje para exponer o completar ciertas tareas:

  - Programación imperativa: Secuencia de órdenes que se ejecutan de arriba a abajo
    `if`, `else`, `switch`, `for`, `while`
  - Programación procedural: Capacidad que me ofrece el lenguaje para contruir e 
    invocar funciones/métodos/procedimientos.
  - Programación funcional: Capacidad de referenciar a una FUNCION desde una variable.
    Esto cambia todo. Desde el momento que podemos hacer eso:
    - Somos capaces de suministrar a una función, funciones como argumentos.
    - Somos capaces de devolver una función como resultado de otra función.
  - Orientación a objetos: Capacidad para definir mis propios TIPOS de DATOS con sus 
    atributos/propiedades y funciones particulares.

- Interpretados / compilados

  Cuando nostros escribimos un programa, el lenguaje que usamos (el que sea) es entendido por el SO de turno?
  NO, ninguno!
  Los SO solo entienden SU LENGUAJE. Su API a nivel del Kernel.
  Hay que traducir nuestro programa al lenguaje del SO. Y hay 2 estrategias:

  - COMPILACION: Pretraducción y hacer llegas esa pre-traducción al SO destino.
    - Beneficios:
      - Rendimiento suele ser superior
      - **Durante la etapa de compilación podemos hacer unas VALIDACIONES adicionales al código**
    - Contra:
      - Menos portables. He de compilar mi app contra cada SO destino.
      - Más compleja la gestión de los entregables.
      - Más engorroso al trabajar: 2 tareas: 1 compilación + Ejecución
    - Ejemplos: C, C++, C#, ADA

  - INTERPRETACION: Enviar al SO destino un código en un lenguaje que no entiende... 
    y que es TRADUCIDO EN TIEMPO REAL por un interprete.
    - Beneficios:
      - Menos engorroso: Ejecuto. No hay 2 etapas. Al ejecutarse se interpreta (y ahí se traduce)
      - Entregable es sencillo de gestionar. Solo hay 1 entregable, da igual el SO destino.
    - Contras:
      - Rendimiento suele ser inferior
      - Al no haber compilación, no tengo la oportunidad de validar ciertos errores... 
        y me encuentro con ellos al ejecutar mi programa
    - Ejemplos: Js, Python, Bash

    JAVA ES UN LENGUAJE compilado + interpretado

        .java -> compilo -> .class    -> interpretado
                  javac     byte-code        JVM
    
    llevándose por el camino lo mejor de los 2 mundos.
    
- De tipado estático vs de tipado dinámico

  - TIPADO ESTATICO: NO permite cambiar en tiempo de ejecución el tipo de una variable.
  
    Ejemplos: JAVA, C, C++

    - Beneficios:
        - Detección de errores en tiempo de compilación
        - Al ver un código (la definición de una función) ya sé cómo comunicarme con ella.
          
          ```java
          public String saluda(String nombre);
          Map<String, List<String>> lista = new HashMap<String>,List<String>>();
          ```

    
    - En contra:
        - Es muy verboso.... al menos en JAVA;

          ```java
          Map<String, List<String>> lista = new HashMap<String,List<String>>();
          
          
          Map<String, List<String>> lista;      // Esto tiene sentido? SI
          new HashMap<String,List<String>>();   // Esto tiene sentido? SI.      ESTE EL DATO !!!!
          
          
          Map<String, List<String>> lista = new HashMap<>();                    // Si cabe es PEOR QUE LA ANTERIOR !!!!!
                                                                                // Los tipos del dato se infieren de la variable:
                                                                                // ABERRACION = CAGADA DE LA SINTAXIS !!!!
          
          new HashMap<>();                      // Esto tiene sentido? NO. Ni compila

          Map<> lista = new HashMap<String,List<String>>();                     // Esto si tenía sentido. PENSADO COMO EL CULO !
                                                                                // Pero no funciona
          
          rellenarMapa(new HashMap<>());
          ```
    
    - INFERENCIA DE TIPOS: Tengoun lenguaje con TIPADO ESTATICO, donde los tipos se INFIEREN en base al dato:

          ```java
                Map<String, List<String>> lista = new HashMap<String,List<String>>();
                Map<String, List<String>> lista = new HashMap<>();
                var lista = new HashMap<String,List<String>>();                 // Esto vale en JAVA a día de HOY. J10

                var texto = "hola";
                String texto = "hola";
          ```
    
      Qué aporta? Legibilidad.
      Y la legibilidad es importante? MUCHO !

  - TIPADO DINAMICO: Permite cambiar en tiempo de ejecución el tipo de una variable.
    - Beneficios: (pocos)
      - Es más cómodo

          ```py
          def saluda(nombre);
          lista = []
          ```

          ```js
          var lista = [];
          lista = 3;
          ````
    
    - En contra: No tengo npi de lo que tiene la variable, ni lo que puedo meter, ni lo que se espera ni na'! de na'! = RUINA !
    
        De hecho en los lenguajes de tipado dinámico, cuando se han querido usar para proyectos más grandes,
        se han tenido que inventar ROLLOS BANANEROS para lidiar con este problema:
          ```py
          def saluda(nombre:str ):str ;             Esto en python es un rollo... No se usa para compilar...
                                                    Solo es informacional
            
          numero:int = 7                            # :int solo le da pistas al desarrollador de lo que se "espera" no "requiere"
          numero = "hola"                           # Funcionaría GUAY !
          ```
        Más sangrante es el caso de JS, que han tenido que inventar directamente otro lenguaje de programación para tener 
        TIPADO ESTATICO: TypeScript... Y un proceso para transformar el código TS en JS que en el proceso valide los tipos:
        TRANSPILACION de JS
---

# Qué es una variable?

Variable JAVA: Una referencia a un dato que tengo guardado en la RAM.

Quitaros de la cabeza que una variable es una especie de cajita en la que pongo cosas.

x Un dato que está almacenado en memoria
x Un identificador que contiene un valor
x Un valor de un dato
x El nombre que se da a un dato?

## Ejemplo:

```java
String texto = "HOLA";
Cuadrado c1 = new Cuadrado(5);
```

- Esa linea (statement) cuántas partes tiene? 3
- Cuál es la primera que se ejecuta?

  1. `"HOLA"` | `new Cuadrado(5)`
     Crea un objeto de tipo String y lo guarda en la RAM.
     Crea un objeto de tipo Cuadrado y lo guarda en RAM.

     > El dato tiene su propio TIPO

  2. `String texto`| `Cuadrado c1`
     Crea una variable llamada `texto`que permita referencia a objetos de tipo `String`
     Crea una variable llamada `c1`que permita referencia a objetos de tipo `Cuadrado`

  3. `=`
     Asigna la variable al objeto
     La variable apunta al objeto
     La variable referencia al objeto
     Asigno la variable al objeto

```java
texto = "ADIOS";
```
1. `"ADIOS"` 
   Crea un nuevo texto y lo pone en RAM... donde? donde ponía "HOLA"? NO... en otro sitio.
   En este momento tengo 2 objetos en RAM: el objeto `"HOLA"`y el objeto `"ADIOS"`

2. `texto =`
   Mueve la variable para que apunte al nuevo objeto. 

Y que pasa con el "HOLA"... Se convierte en BASURA ! Garbage
Ya que es un Objeto al que no apunta ninguna variable. Y por tanto es imposible volver acceder a él.

En JAVA existe el recolector de Basura (gc: Garbage Collector) que periodicamente 
elimina este tipo de objetos: LA BASURA

JAVA hace un uso pésimo de la memoria RAM: 
Una app montada en JAVA por tal y como está diseñado JAVA necesita mucha más RAM 
que la misma app montada en C++

## Eso es bueno o malo? NO es ni bueno ni malo => FEATURE, característica de diseño de JAVA.

Por qué? 

Porque gestionar bien la RAM es harto complejo. Y la decisión se traduce al final en?

- Pongo al desarrollador 50 horas a:
  - Hacer reservas de memoria
  - Trabajar con punteros
  - Liberar espacio de memoria 

- O compro una pastilla de memoria más a mi computadora?

Es más sencillo programar en JAVA que en C o en C++. No necesito tampoco de tantos 
conceptos profundos de programación.
   
---

# Lenguajes más usados en el mundo a día de HOY: 

1. Js
2. Py
....
JAVA

---
# Lenguajes más usados en el mundo a día de 2002: 

1. JAVA

Y todo el mundo quería aprender JAVA

Y JAVA era el lenguaje del futuro

Y JAVA se usaba para todo...

- Apps desktop : YA NO 
- App teléfonos: YA NO
- Apps WEB: montonón
  - FrontEnd YA NO !
  - Backend: SOLO ESTO !
- Software embebido? YA NO 

Qué ha pasado en 20 años...? que JAVA ha quedado relegado a un lenguaje de NICHO: Back-end de apps web.

---

# Indefensión aprendida

Elefante que estaba atadito con una cuerdita a un palito?

Los programadores de JAVA padecemos mucho de INDEFENSION APRENDIDA.
Nos hemos acostumbrado a muchas CAGADAS ENORMES que tiene la sintaxis de JAVA.

---

Los setter y los getter = GRAN CAGADA DE JAVA

¿Por qué usamos SETTER y GETTER?

JUSTIFICACION OFICIAL: Encapsulación de código

Es realmente importante la encapsulación de CODIGO? MUCHISIMO, LO MAS IMPORTANTE !
Es buena la forma ne la que en JAVA se consigue esa ENCAPSULACION? LA PEOR !

```java

// Dia 1
public class Rectangulo{
    
    public int base;
    public int altura;
    
    public Rectangulo (int base, int altura){
        this.base=base;
        this.altura=altura;
    }
    
}

....
Dia 2 - 200
Rectangulo r1 = new Rectangulo(4,5);
System.out.println(r1.base);
r1.altura=8;
System.out.println(r1.altura);

// FUNCIONA: GUAY !!!!!

// Dia 201 se me ocurre querer meter una valdiación a la altura y a la base.
// No se admiten valores menores que 0
```

Si yo hiciera este código, me matan en JAVA.
Y con razón.

Los setter y getter de JAVA no son para encapsular... son para 
facilitar la mantenibilidad del código y poder hacerle cambios a futuro
si que JODA a nadie!!!!!

Y por si acaso el dia de mañana quiero meter una validación,
me obligan al dia de hoy a meter puñeteros setter y getter en todos los sitios!
VAYA CAGADA !!!!!

---
De hecho la sintaxis de JAVA es tán mala y su arquitectura TAN BUENA !!!!
que a día de hoy han surgido muchas alternativas de sintaxis a JAVA

KOTLIN - JetBrains (IntelliJ)

Google dice que IntelliJ es el mejor entorno de desarrollo de JAVA
Hasta el punto de que antiguamente el entorno oficial de desarrollo para Android era: 
Eclipse + 4 librerias de Android y un emulador de telefonos

Y google llego a un acuerto con JetBrains... pagándoles una pasta al año, para que 
hicieran una versión capada de IntelliJ para hacer apps para Android en Java

La gente de JetBrains hace editores para montones de lenguajes de programación.
Saben un huevo de lenguajes.... y crearón una alternativa a JAVA resolviendo las cagadas de sintaxis de JAVA:
KOTLIN -> Android Studio

.kt ~> compilación ~> .class ~> jvm

Y no es la única: SCALA
.scala ~> compilación ~> .class ~> jvm

---

# CAGADA 2... ya resuelta desde versión 8 de JAVA... ya era hora!

Se que devuelve esa función? NO
Puede ser que devuelva un String... o quizás un null.

Y cómo lo averiguo? VETE A LA DOCUMENTACION !
En serio???? Me tengo que ir a la docu para saber qué tengo que pasar y que esperar de una función????
Estamos en el siglo III o como va esto? = CAGADA DE JAVA... ya resuelta

```java
public Optional<String> saluda(@NonNull String nombre);
```

En Java 5 se incluyó una funcionalidad que cambio JAVA para SIEMPRE: ANOTACIONES / GENERICOS 

---

NodeJS

Es el antiguo motor de procesamiento (intérprete) de JS del navegador Chromium -> Chrome
                                                                               -> Edge
                                                                               -> Opera
                                                                               -> Safari
                                                                               
                                                                      Siempre nos quedará Firefox !!!!!!

Ese proyecto lo lidera GOOGLE. Y decidió desgajar el interprete como un programa aparte: NodeJS

Básicamente es el equivalente a la JVM de JAVA en el mundo JS. Me permite ejecutar apps JS fuera de un navegador.

---

Qué usamos para montar un front END WEB ... estándares? 

W3C: HTML, CSS, WEB COMPONENTS ~> Definir mis propias marcas HTML
 |
 V
 Tim Berners Lee
 
Esa página web se muestra y se interactúa con ella dentro de un Navegador de Internet.
Y qué lenguaje dan los navegadores de internet para interactuar con el navegador? JS (nada de JAVA, ni de python)
 
JavaScript cuyo nombre real hoy en día es ECMAScript, su estándar, que lo tiene está en manos de la ECMA !

## Puedo montar un Componente WEB:

```html
<usuario id="2819284897"/>
```

Y esa marca se rendiza con un monton de paneles DV con la foto del tio, que se saca de una query a una BBDD de la empresa
Y sus datos: nombre, email... Con un botón para poder mandarle un email en autom.

Esos componentes WEB antiguamente los montabamos con Java Faces... O bien con los Frameworks de JS: Angular, Vue, React

Hoy en día NATIVAMENTE los navegadores admiten esta funcionalidad.... y la exportan via JS.

JAVA no tiene NADA que hacer ya en este mundo. PERDIO LA GUERRA !
Los JSP, JFCs ... están muertos. TECNOLOGIA TOTALMENTE OBSOLETA !

---

# Versiones de Java

versión 1.0         1996            > Sun microsystems... empresa querida en el mundo del software
versión 1.1         1997
versión 1.2         1998
versión 1.3         2000
versión 1.4         2002
versión 1.5         2004
versión 1.6         2006
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Se produce la PRIMERA MUERTE DE JAVA
                                    Desgraciadamente JAVA cae en manos de una empresa que no es NADA querida en el mundo del software
                                                    Los TO LO QUE TOCO LO JODO de Oracle!
versión 1.7         2011    + 5 años????
versión 1.8         2014    + 3 años????
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Se produce la SEGUNDA MUERTE DE JAVA
                                    Es JAVA GRATUITO A DIA DE HOY ? NO
                                    En 2015 Oracle anunció que JVM desde v 1.9 iba a costar:
                                        25$ para usuarios particulares / año
                                        50$/core para servidores  / año
                                    Esto fue como meter un zorro en un gallinero !!!!
                                    Hubo una emprewsa que plantó CARA a ORACLE !    GOOGLE !
                                    Android... que los usuarios de Android tienen que pagar 25$ al año a Oracle? 
                                    
                                    AQUI GRACIAS A LA PRESION DE GOOGLE se tomaron muchas decisiones:
                                    1º LA JVM pasa a ser una ESPECIFICACION OPENSOURCE!
                                    - OpenJDK
                                    - Eclipse Temurin
                                    - Amazon Correto
                                    
                                    2º Un nuevo modelo de versionado
                                    
                                    3º Oracle libera el J2EE > JEE > Jakarta Enterprise Edition 
                                    
versión 1.9         2017    + 3 años
version 10          2018    + 6 meses
version 11          2018    + 6 meses
version 12          2019    + 6 meses
version 13          2019    + 6 meses
version 14          2020    + 6 meses
version 15          2020    + 6 meses
version 16          2021    + 6 meses
version 17          2021    + 6 meses
version 18          2022    + 6 meses
version 19          2022    + 6 meses
version 20          2023    + 6 meses

La gente de JAVA se fué a otros 2 lenguajes:
- Js (FrontEnd, Desktop)
- C# (Microsoft lo está haciendo muy muy bien)  .net Framework -> .net core (Apache, Opensource compiladores para Linux, MacOS y Windows)
                                                AZURE !

Spark es un API / Libreria para BigData
- Java
- Scala **
- Python *
---
OpenOffice      -> Sun microsystems -> StarOffice

---

Oracle es una empresa gigantesca.
Que tiene un producto IMBATIBLE: Oracle Database. No hay otra BBDD igual. Extraordinaria!
El problema es que a Oracle lo UNICO que le importa es su BBDD y ganar PASTA CON ELLA !!!

Por qué compra Oracle a Sun Microsystems? Se la sudaba JAVA... ni habían oido hablar de eso!

Oracle era la única gran empresa de SOFTWARE que no tenía HARDWARE !

Sun Microsystems no era famosa por JAVA... ni por desarrollar SOFTWARE, era una empresa GIGANTE que vendía HARDWARE

Unos servidores BRUTALES !!!!
Con su propia arquitectura de Microprocesador: sparc.
Con su propio SO, Un SO Certificador UNIX® = SOLARIS

Y salió el EXADATA de Oracle

Y en sus manos cayó:

- OpenOffice: Que como no les importaba no le metieron ni un euro !
  Y al final el proyecto OpenOffice Murió... Y cuando estaba muerto lo donaron a una fundación... Se lo quitaron de enmedio
  Claro que la gente que hacía OpenOffice tomaron la última versión del código y crearon un nuesvo sistema,
  que es la continuación REAL del proyecto OpenOffice = LibreOffice

- MySQL: Y no les importaba una mierda... y la caparon y la pudieron de pago... y la convirtieron en una bbdd de juguete.
         Y los usuarios se fueron a otras BBDD: PostgreSQL
  Hasta que la gente que hacía MySQL, harta, tomaron la última versión de MySQL 
  y montarón la continuación REAL de proyecto MySQL: MariaDB

- Hudson: Era guay... HAsta que lo compró Oracle. y se lo cargaron.
  Y la gente que estaba ahñi se piraron a montar la continuación real del proeycto Hudson.... 
  conocida hoy en día por su nuevo nombre: JENKINS !

- JAVA le valía MIERDA !

---

J2EE: Java Enterprise Edition           ESTO YA NO EXISTE
JEE:  Jakarta Enterprise Edition        Esto ya no es de Oracle. Lo lleva una fundación.


Especificaciones para desarrollo de apps web en entorno empresrial:
- JMS
- JDBC
- ..

---

Servidor de aplicaciones más usados:
- **Apache Tomcat**

- Weblogic (Oracle)             \
- Websphere (IBM)                > Obsoletos !
- JBoss (Redhat) <- Wildfly     /

IBM Ha lanzado un nuevo servidor de apps ultraligero (similar a Tomcat): Liberty

Ya no queremos serv. de apliaciones de clase empresarial. Hoy en día los EJB están OBSOLETOS !!!

Por qué? 

Porque ya no montamos aplicaciones MONOLITICAS !

Por qué ya no queremos aplicaciones monolíticas?
- Los componentes presentan un FUERTE NIVEL DE ACOPLAMIENTO !
- Mucho más dificiles de mantener / entender
- Escalabilidad en entornos de producción: CLUSTER, necesito replciar la app entera... casi nunca tiene sentido.
- Despliegues complejos... necesito REDESPLEGAR TODO cuando he cambiado una cosita!
- Me obligan a una única tecnología (JAVA JEE)

Hoy en día la arquitectura que usamos ES NO ACOPLADA !!!!!

Y que más a triunfado es Arquitectura Orienta a Microservicios <<<<<<< SpringBoot > .jar (tomcat)

---
Hace 20 años, 15 años, estabamos en el mundo WEB (navegador de internet en el PC). Hoy en día YA NO !
Si quiero acceder al banco, la mayor parte de las peticiones se hacen desde una WEB? Aplicaciones de movil!
    
        FRONTENDS                                                               Servicios de BackEND

App 1 - Android                                                                 Programa que consulta el saldo de una cuenta     JAVA + MariaDB

App 2 - iOS                                                                     Programa que autentifica a un usuario            PY + MongoDB

App 3 - Aplicación WEB

App 4 - TV

App 5 - Voz, Asistentes: Alexa, OK Google

App 6 - Sistema de voz interactivo por teléfono

---

No... se intenta recuperar a JAVA
De hecho muchos cambios que os contaré tratan de atraer gente de JS y PYTHON al mundo JAVA.
- El uso de la pabara var
- La no necesidad de compilar un programa previo a su ejecución
- El permitir ejecutar SCRIPTS en JAVA (Sin clases ni metodos) al mas puro estilo python
- La introdudcción de JSHELL una shell interactiva equivalente a la de python

---

Java ha quedado posicionado, MUY BIEN POSICIONADO, para desarrollo BackEnd: SpringBoot
Fuera de eso, na', de na'


---

# Metodologías ágiles

Una forma de trabajar en el mundo del desarrollo de software que viene en reemplazado de las metodologías clasicas: WATERFAL !

Problemas de las metodologías Waterfal:
- Parte de una FALACIA: Que el dia 1 voy a ser capaz de hacer una toma de requisitos PERFECTA e INVARIANTE !
- Poca comunicación con el cliente. Tenía poco feedback
- Cúantas veces instalaba? 1 al final del proyecto (al año)

Para resolver estos y otros problemas, un grupo de desarrolladores muy respetados firman el manifiesto AGIL !

Principios de las metodologías ágiles:
- Entrega continua y temprana.
- Entregar el producto de forma INCREMENTAL desde muy pronto

Un proyecto empieza el día 1 y
- el día 20 hago la primera instalación en producción ! Instalación 100% funcional               5% de la funcionalidad    < SPRINT 1 
                                                                                Aquí pruebo el 5% que entrego?

- el dia 35 hago la segunda instalación en producción ! Instalación 100% funcional              +5% de la funcionalidad    < SPRINT 2
                                                                                Aquí pruebo el 5% que entrego?
                                                                                + 5% que entregué

Antiguamente en Waterfal, se hablaba de HITOs !
Y an la fase de planificación se planificaban TODOS LOS HITOS del proyecto

Y hoy en día en las metodologías ágiles, planifico la siguiente entrega... NO MAS !

¿Cuántas veces instalaba antes un proyecto? 1 al final
Y hoy en día? Tropetantas! Y de donde saco la pasta? NO HAY ESA PASTA !

¿Cuántas veces probaba antes un proyecto? 1 al final
Cada vez que instalo en producción! Y de donde saco la pasta? NO HAY ESA PASTA !

---

DEV--->OPS

Cultura, Filosofía en pro de la AUTOMATIZACION !


---

## CAGADAS DE JAVA. Parte 2

### Modificadores de privacidad en JAVA:
    
                QUIEN PUEDE ACCEDER 
public              To' cristo
protected           clases hijas y paquete
default             paquete
private             La misma clase

## Son suficientes?

No, no son suficientes...
Además, la falta de modificadores ME INVITA A MONTAR CODIGO FUERTEMENTE ACOPLADO
A parte de las 'trampas' y 'trucos'

Y todo eso sin hablar de otro tema... Si una variable esta puesta como PRIVATE puedo acceder a ella desde fuera de la clase? 
Sin problema, por reflection ! -> PROBLEMON DE SEGURIDAD DEL 15
