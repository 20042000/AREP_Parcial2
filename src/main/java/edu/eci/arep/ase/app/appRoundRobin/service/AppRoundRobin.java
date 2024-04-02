package edu.eci.arep.ase.app.appRoundRobin.service;

import java.util.ArrayList;
import java.util.List;

import edu.eci.arep.ase.app.mathService.MathService;

public class AppRoundRobin {

    private List<MathService> mathServices;
    private int index;

    public AppRoundRobin() {
        this(2, 5000);
    }

    public AppRoundRobin(int cantMathServices, int port) {
        index = 0;
        mathServices = new ArrayList<>();

        int i = 0;

        while (i < cantMathServices) {
            mathServices.add(new MathService(port + i));
            i++;
        }
    }

    public String invokerFactor(String value){
        String result = mathServices.get(index).respuestaFactor(value);
        this.index = (this.index + 1) % mathServices.size();
        return result;
    }

    public String invokerPrimo(String value){
        String result = mathServices.get(index).respuestaPrimos(value);
        this.index = (this.index + 1) % mathServices.size();
        return result;
    }
    
}
