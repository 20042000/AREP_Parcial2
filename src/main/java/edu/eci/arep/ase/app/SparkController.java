package edu.eci.arep.ase.app;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import edu.eci.arep.ase.app.appRoundRobin.service.AppRoundRobin;
import edu.eci.arep.ase.app.mathService.MathService;

import static spark.Spark.get;

public class SparkController {

    public static void main( String[] args){

        AppRoundRobin appRoundRobin = new AppRoundRobin(2, 5000);

        port(5000);
        staticFileLocation("/public");

        get("/factors", (req, res) -> {
            String value = req.queryParams("value");
            return appRoundRobin.invokerFactor(value);
        });

        get("/primes", (req, res) -> {
            String value = req.queryParams("value");
            return appRoundRobin.invokerPrimo(value);
        });




    }
    
}
