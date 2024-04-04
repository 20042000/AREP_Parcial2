package edu.eci.arep.ase.app.controller;

import static spark.Spark.port;

import edu.eci.arep.ase.app.service.LoadBalancerService;

import static spark.Spark.get;

public class MyController {

    private LoadBalancerService loadBalancerService;

    public MyController() {
        loadBalancerService = new LoadBalancerService();
    }

    public void inicializar() {
        port(8080);
        get("*", (req, res)->{
            String cons = req.queryString();
            String param = req.pathInfo();
            String route = param + (cons != null ? "?" + cons : "");
            return loadBalancerService.invoker(route);
        });
    }
    
}
