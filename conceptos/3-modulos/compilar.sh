javac -d compilado \
    --module-source-path=modulos \
    modulos/libreria/module-info.java \
    modulos/libreria/com/curso/libreria/*.java \
    modulos/libreria/com/curso/libreria/impl/*java \
    modulos/app/module-info.java \
    modulos/app/es/curso/app/*.java 


java --module-path compilado -m app/es.curso.app.App