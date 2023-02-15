javac -d compilado \
      --module-source-path modulos \
      modulos/diccionario/*.java \
      modulos/diccionario/com/curso/diccionario/*.java \
      modulos/app/*.java \
      modulos/app/com/curso/app/*.java

java --module-path compilado \
    -m app/com.curso.app.App ES manzano