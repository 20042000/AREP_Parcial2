package edu.eci.arep.ase.app.service;

import edu.eci.arep.ase.app.apiExternal.HttpClient;

public class LoadBalancerService {

    private String host1;
    private String host2;

    private Integer portHost1;
    private Integer portHost2;

    private HttpClient httpClient;

    public LoadBalancerService() {
        this.host1 = System.getenv("MATHSERVICE_HOST1");
        this.host2 = System.getenv("MATHSERVICE_HOST2");

        this.portHost1 = Integer.parseInt(System.getenv("PORT_HOST1"));
        this.portHost2 = Integer.parseInt(System.getenv("PORT_HOST2"));

        this.httpClient = new HttpClient();
    }

    public String invoker(String route){
        double randomServicios = Math.random();
        try{
            if(randomServicios > 0.5){
                return httpClient.invoker(host1, portHost1, route);
            }else{
                return httpClient.invoker(host2, portHost2, route);
            }
        }catch(Exception e){
            return "Error";
        }




    }


    //leer las variables de entorno donde estan los 2 host

    //y que se vaya entre uno o el otro a una de las dos peticiones

    
    //distribuidor que tome la peticiones y las distribuya a los dos host

    //cliente hhtp para hacer las llamadas
    //atributo
    //y un metodo que sea llamado desde el controlador que reciba la ruta y ese resuelve a cual host le envia la ruta
    
}
