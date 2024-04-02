package edu.eci.arep.ase.app.mathService;

import java.util.ArrayList;
import java.util.List;

public class MathService {

    private int servicio;

    public MathService(int servicio) {
        this.servicio = servicio;
    }

    public int getServicio() {
        return servicio;
    }

    public String factors(int numero){
        List<Integer> factores = new ArrayList<>();
        for (int i = 1; i <= numero/2; i++) {
            if(numero%i==0){
                factores.add(i);
            }
        }
        factores.add(numero);

        StringBuilder result = new StringBuilder();
        for(int n=0; n<factores.size(); n++){
            result.append(factores.get(n));
            if(n != factores.size()-1){
                result.append(",");
            }
        }
        
        return result.toString();
    }


    public String primes(int numero){
        List<Integer> primos = new ArrayList<>();
        for (int i = 1; i <= numero; i++) {
            if(esPrimo(i)==1){
                primos.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for(int n=1; n<primos.size(); n++){
            result.append(primos.get(n));
            if(n != primos.size()-1){
                result.append(",");
            }
        }
        return result.toString();
    }

    public int esPrimo(int numero){
        for (int i = 2; i < numero; i++) {
            if(numero%i==0){
                return 0;
            }
        }
        return 1;
    }

    public String respuestaFactor(String value){
        return "{" +
                "\"operation\": \"factors\"," +
                "\"input\": \"" + value + "\"," +
                "\"output\": \"" + factors(Integer.parseInt(value)) + "\"," +
                "\"service\": \"" + getServicio() + 
            "}";
    }

    public String respuestaPrimos(String value){
        return "{" +
                "\"operation\": \"primes\"," +
                "\"input\": \"" + value + "\"," +
                "\"output\": \"" + primes(Integer.parseInt(value)) + "\"," +
                "\"service\": \"" + getServicio() + 
            "}";
    }
    
}
