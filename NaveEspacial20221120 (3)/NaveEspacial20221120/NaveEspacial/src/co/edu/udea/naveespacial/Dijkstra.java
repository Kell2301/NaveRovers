/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.naveespacial;

import java.util.ArrayList;

/**
 *
 * @author Jeaniel
 */
public class Dijkstra {
    
    public int[][] ruta = new int[][]{
        {0, 1, -1, -1, -1, -1, -1, 2, -1, -1},
        {-1, 0, 4, 1, -1, -1, 3, -1, -1, -1},
        {-1, -1, 0, -1, 3, 3, -1, -1, -1, -1},
        {-1, -1, -1, 0, -1, -1, -1, -1, 3, -1},
        {-1, -1, -1, 6, 0, 2, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, 0, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, 0, 1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, 0, -1, -1},
        {-1, -1, -1, -1, -1, 2, -1, -1, 0, 5},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, 0},
    };
    
    public Dijkstra (){
        
    }
    
    public void calcularRecorrido (Rover rover){
        int Origen = rover.getNodoAterrizaje();
        int posicionActual = Origen - 1;
        
        int nodoAterrizaje = Origen;
        ArrayList<Integer> nodosRecorridos = new ArrayList<>();
        nodosRecorridos.add(nodoAterrizaje);
        int kilometrosRecorridos = 0;
        int sumaBandera1 = 0;
        int bandera = 1;
        int[] adyacentes = this.ruta[posicionActual];

        int miembrosVivos = rover.getTripulantes().getFamilia().size();
        int oxigeno = 0;
        
        while (bandera <= 10){

            if (posicionActual == 5) {
                rover.setKilometrosRecorridos(kilometrosRecorridos);
                rover.setOxigeno(oxigeno);
                break;
            }
            
            int menor = 0;
            
            //Tomamos un nodo adyacente cualquiera, en caso de existir
            
            for (int i = 0; i < adyacentes.length; i++) {
               
                if (adyacentes[i] != -1 && adyacentes[i] != 0){
                    menor = i;
                }
                
            }
            
            //Tomamos el nodo adyacente de menor peso, en caso de existir
            
            for (int i = 0; i < adyacentes.length; i++){

                if (adyacentes[menor] != -1 && adyacentes[menor] != 0) {
                    sumaBandera1 = adyacentes[menor];
                }
                
                if (adyacentes[i] != -1 && adyacentes[i] != 0 && adyacentes[i] < adyacentes[menor]){
                    menor = i;
                }
            }
            
            kilometrosRecorridos +=sumaBandera1  ;
            oxigeno = (kilometrosRecorridos * miembrosVivos) * 2 ;
            
            posicionActual = menor;
            
            if (menor == 0) {
                rover.setEstado(false);
                ArrayList<Persona> personas = new ArrayList<>();
                personas = rover.getTripulantes().getFamilia();
                for (Persona persona : personas) {
                        persona.setEstado(false);
                }
                
                rover.setKilometrosRecorridos(kilometrosRecorridos);
                rover.setOxigeno(oxigeno);
                rover.getTripulantes().setCausaMuerte("Llego a un nodo muerto");
                
                break;
            }
            
            nodoAterrizaje = (menor + 1);
            nodosRecorridos.add(nodoAterrizaje);
            adyacentes = this.ruta[posicionActual];
            bandera++;
            rover.setVerticesRecorridos(nodosRecorridos);

            /**
             * Se comprueba si el oxigeno gastado por todos los miembros de la familia
             * es mayor al limite permitido, en caso de serlo entra al if donde 
             * se muere la familia  y se coloca su causa
             */
            if(oxigeno > rover.getOxigeno()){
                rover.setOxigeno(oxigeno);
                //System.out.println("Muerte por falta de oxigeno");
                rover.setEstado(false);
                rover.getTripulantes().setEstado(false);
                rover.getTripulantes().setCausaMuerte("Falta de  oxigeno el el rover");
                break;
            }
        }
    }
    
}
