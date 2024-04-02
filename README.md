# Parcial AREP 2T


## Instalación

1.Clonamos el repositorio
```
https://github.com/20042000/AREP_Parcial2.git
```
2.Nos movemos a la carpeta
```
cd AREP_Parcial2
```
3.Costruimos el proyecto
```
mvn package
```

## Ejecución
1.Ejecutamos nuestro proyecto con el siguiente comando:

***Windows***
```
mvn exec:java -"Dexec.mainClass"="edu.eci.arep.ase.app.SparkController"
```

2.Probamos nuestro proyecto ingresando con el siguiente link a nuestro browser, en donde podremos probar la funcionalidad de factores y primos:
```
http://localhost:5000/index.html
```

**Tambien podemos probar las funciones de la siguiente manera:**

***1. Factores***
```
http://localhost:5000/factors?value=15
```

***2. Primos***
```
http://localhost:5000/primes?value=100
```