package co.edu.udea.naveespacial;

import java.util.ArrayList;
import java.util.List;

public class Rover {
    private int idFamilia;
    private boolean estado;
    private int nodoAterrizaje;
    private Familia tripulantes;
    private ArrayList<Integer> verticesRecorridos;
    private int kilometrosRecorridos;
    private int oxigeno;

    public Rover() {
        this.oxigeno = 100;
        this.kilometrosRecorridos = 0;
    }

    public Rover(int idFamilia, boolean estado, int nodoAterrizaje, Familia tripulantes) {
        this.idFamilia = idFamilia;
        this.estado = estado;
        this.nodoAterrizaje = nodoAterrizaje;
        this.tripulantes = tripulantes;
        this.oxigeno = 100;
        this.kilometrosRecorridos = 0;
    }
    
    public Rover(int idFamilia, boolean estado, int nodoAterrizaje) {
        this.idFamilia = idFamilia;
        this.estado = estado;
        this.nodoAterrizaje = nodoAterrizaje;
    }
    

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNodoAterrizaje() {
        return nodoAterrizaje;
    }

    public void setNodoAterrizaje(int nodoAterrizaje) {
        this.nodoAterrizaje = nodoAterrizaje;
    }

    public Familia getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(Familia tripulantes) {
        this.tripulantes = tripulantes;
    }

    public void recorridoRover(ArrayList<Rover> rovers){
        System.out.println(rovers);
    }

    public int getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(int oxigeno) {
        this.oxigeno = oxigeno;
    }

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public ArrayList<Integer> getVerticesRecorridos() {
        return verticesRecorridos;
    }

    public void setVerticesRecorridos(ArrayList<Integer> verticesRecorridos) {
        this.verticesRecorridos = verticesRecorridos;
    }

    @Override
    public String toString() {
        return "Rover{" + "idFamilia=" + idFamilia + ", estado=" + estado + ", nodoAterrizaje=" + nodoAterrizaje + ", tripulantes=" + tripulantes + ", verticesRecorridos=" + verticesRecorridos + ", kilometrosRecorridos=" + kilometrosRecorridos + ", oxigeno=" + oxigeno + '}';
    }

    public void recorridoDeRover(ArrayList<Rover> rovers){
        for (int i = 0; i < rovers.size(); i++) {
                System.out.println("Los vertices recorridos por el rover " + (i +1 ) + " son: " + rovers.get(i).verticesRecorridos);
            

            
        }
    }
    
    public void sobrevivientesRovers(Rover rover) {
        ArrayList<Persona> personas = new ArrayList<>();

        personas = rover.getTripulantes().getFamilia();
        for (Persona persona : personas) {
            if (rover.isEstado() == true) {
                if (persona.getEstado() == true) {
                    System.out.println(persona.getNombre());
                }
            }
        }
    }

    
    public void  fallecidosRovers(Rover rover) {
        ArrayList<Persona> personas = new ArrayList<>();

        personas = rover.getTripulantes().getFamilia();

        for (Persona persona : personas) {
            if (rover.isEstado() == false) {
                
                if (persona.getEstado() == false) {
                    System.out.println(persona.getNombre());
                }
            }
        }
    }

    public void consultarRoversConFallecidos(List<Rover> rovers){
        int contador = 0;
        for (int i = 0; i < rovers.size(); i++) {
            if(!rovers.get(i).isEstado()){
                contador++;
                System.out.println("Famila " + rovers.get(i).getIdFamilia());
                System.out.println("Cantidad de miembros " + rovers.get(i).getTripulantes().getFamilia().size());
                System.out.println("Nodo de aterrizaje " + rovers.get(i).getNodoAterrizaje());
                System.out.println("Kilometros recorridos " + rovers.get(i).getKilometrosRecorridos());
                System.out.println("Oxigeno consumido " + rovers.get(i).getOxigeno());
                if (rovers.get(i).getNodoAterrizaje() == 8 || rovers.get(i).getNodoAterrizaje() == 10) {
                    System.out.println("Recorrido realizado " + rovers.get(i).getNodoAterrizaje());
                } else {
                    System.out.println("Recorrido realizado " + rovers.get(i).getVerticesRecorridos());
                }
                System.out.println(rovers.get(i).getTripulantes().getCausaMuerte());
                fallecidosRovers(rovers.get(i));
                System.out.println("****************************************************************");

            }
            
        }

        System.out.println("Total rovers que no llegaron: " + contador);

    }

    public void consultarRoversConSobrevivientes(List<Rover> rovers){
        int contador = 0;
        for (int i = 0; i < rovers.size(); i++) {
            if(rovers.get(i).isEstado()){
                contador++;
                System.out.println("Famila " + rovers.get(i).getIdFamilia());
                System.out.println("Cantidad de miembros " + rovers.get(i).getTripulantes().getFamilia().size());
                System.out.println("Nodo de aterrizaje " + rovers.get(i).getNodoAterrizaje());
                System.out.println("Kilometros recorridos " + rovers.get(i).getKilometrosRecorridos());
                System.out.println("Oxigeno consumido " + rovers.get(i).getOxigeno());
                if (rovers.get(i).getNodoAterrizaje() == 6) {
                    System.out.println("Recorrido realizado " + 6);
                } else {
                    System.out.println("Recorrido realizado " + rovers.get(i).getVerticesRecorridos());
                }
                sobrevivientesRovers(rovers.get(i));
                System.out.println("****************************************************************");

            }
            
        }

        System.out.println("Total rovers que llegaron a base: " + contador);
    }

}
