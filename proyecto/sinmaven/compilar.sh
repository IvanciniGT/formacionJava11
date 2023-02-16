javac -d compilado \
      --module-source-path modulos \
      modulos/app/*.java \
      modulos/app/com/curso/app/*.java \
      modulos/diccionario/*.java \
      modulos/diccionario/com/curso/diccionario/*.java \
      modulos/diccionarioFicheros/*.java \
      modulos/diccionarioFicheros/com/curso/diccionario/ficheros/*.java

java --module-path compilado \
    -m app/com.curso.app.App ES manzano