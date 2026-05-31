package poo;

//Punto de entrada. Inicia el patrón MVC.

import controlador.ContenidoController;
import vista.ConsolaVista;

public class PruebaAudioVisual {
    public static void main(String[] args) {
 
        ConsolaVista vista = new ConsolaVista();
        

        ContenidoController controlador = new ContenidoController(vista);

        controlador.iniciar();
    }
}