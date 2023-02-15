javac -d compilado \
    com/curso/libreria/*.java \
    com/curso/libreria/impl/*.java \
    es/curso/app/*.java


java -cp compilado es.curso.app.App