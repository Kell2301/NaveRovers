package co.edu.udea.naveespacial;

import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final boolean PROBLEMA_TECNICO = true;
        Nave nave = new Nave();
        LeerArchivo.crearNave(nave);
        Rover rover = new Rover();
        ArrayList<Rover> rovers = new ArrayList<>();
        
        Dijkstra dijkstra = new Dijkstra();

        double probabilidad;

        for (int i = 1; i <= 10; i++) {
            if (i != 10) {
                probabilidad = nave.probabilidadCatastrofe();
                if (probabilidad <= 0.4) {
                    probabilidad = nave.probabilidadCatastrofe();
                    if (probabilidad <= 0.1) {
                        nave.aplicarColision(i);
                    } else if (probabilidad > 0.1 && probabilidad <= 0.5) {
                        nave.aplicarLocura(i);
                    } else if (probabilidad > 0.5) {
                        //aplica fuga bueno
                        nave.aplicarFuga(i);
                    }
                }
            }
            if (i == 10) {
                //En el tick 10 ya se llego a marte 
                if (PROBLEMA_TECNICO) {
                    System.out.println("PROBLEMA AL LLEGAR A MARTE");
                    /*
                     * llamado al metodo eyectarFamiliasDeNave
                     */
                   rovers = nave.eyectarFamiliasDeNave(rovers);

                   for (Rover unRover : rovers){
                        dijkstra.calcularRecorrido(unRover);
                      
                    }
                    System.out.println("\n\n Reporte familias fallecidas \n");
                    rover.consultarRoversConFallecidos(rovers);

                    System.out.println("\n\n Reporte familias vivas \n");
                    rover.consultarRoversConSobrevivientes(rovers);
                    
                } else {
                    nave.consultarMatriz();
                }

            }
        }

    }

}
