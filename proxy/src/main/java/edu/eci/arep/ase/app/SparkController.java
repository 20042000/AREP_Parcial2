package edu.eci.arep.ase.app;

import edu.eci.arep.ase.app.controller.MyController;

/**
 * Hello world!
 *
 */
public class SparkController 
{
    public static void main( String[] args ){
        MyController myController = new MyController();
        myController.inicializar();
    }
}
