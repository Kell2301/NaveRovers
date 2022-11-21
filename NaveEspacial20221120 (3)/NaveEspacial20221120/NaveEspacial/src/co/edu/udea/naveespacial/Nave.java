package co.edu.udea.naveespacial;

import java.util.ArrayList;

public class Nave {

    private Familia[][] nave;
    private Desastre desastres;

    public Nave() {
        this.nave = new Familia[5][5];
    }

    public Nave(Familia[][] nave) {
        this.nave = nave;
    }

    public Familia[][] getNave() {
        return nave;
    }

    public void setNave(Familia[][] nave) {
        this.nave = nave;
    }

    public void agregarFamiliaEnNave(Familia familia, int fila, int columna) {
        this.nave[fila][columna] = familia;
    }

    public void aplicarLocura(int tickMuerte) {
        Desastre desastres1 = new Desastre();
        this.nave = desastres1.aplicarDesastreLocura(nave, tickMuerte);

    }

    public void aplicarColision(int tickMuerte) {

        Desastre desastres1 = new Desastre();
        this.nave = desastres1.ColisionConAsteroide(nave, tickMuerte);
    }

    public void aplicarFuga(int tickMuerte) {
        // se expulsa de la nave a las tres personas mas viejas
        Desastre desastres1 = new Desastre();
        this.nave = desastres1.fugaDeAire(this.nave, tickMuerte);

    }

    public void consultarMatriz() {
        for (int i = 0; i < this.nave.length; i++) {
            for (int j = 0; j < this.nave[i].length; j++) {
                System.out.println(this.nave[i][j]);
            }
        }

    }

    public void registroMuertos() {
        // ArrayList<Persona> muertos = new ArrayList<Persona>();
        System.out.println("REGISTRO DE PERSONAS MUERTAS: " + "\n ");
        for (int i = 0; i < this.nave.length; i++) {
            for (int j = 0; j < this.nave[i].length; j++) {
                ArrayList<Persona> personas = nave[i][j].getFamilia();
                for (Persona persona : personas) {
                    if ((persona.getEstado() == false) && (persona.getCausaMuerte() != null)) {
                        // muertos.add(persona);
                        System.out.println("-Nombre: " + persona.getNombre() + " -Causa de Muerte: "
                                + persona.getCausaMuerte() + " -Tick: " + persona.getTickMuerte());
                    }
                }
            }
        }
    }

    public void registroSobrevivientes() {
        // ArrayList<Persona> sobrevivientes = new ArrayList<Persona>();
        System.out.println("REGISTRO DE SOBREVIVIENTES: " + "\n ");
        for (int i = 0; i < this.nave.length; i++) {
            for (int j = 0; j < this.nave[i].length; j++) {
                ArrayList<Persona> personas = nave[i][j].getFamilia();
                for (Persona persona : personas) {
                    if (persona.getEstado() == true) {
                        System.out.println("-Nombre: " + persona.getNombre());
                    }
                }
            }
        }
    }

    public double probabilidadCatastrofe() {
        double probabilidad = Math.random();
        return probabilidad;
    }

    /**
     * Función que será ejecutada si ocurre un problema tecnico al llegar a marte
     * Valida las familias que aun estan vivas y el estado de cada uno de sus miembros
     * para luego ser asignados a un pod el cual tendrá id de familia, estado, punto de aterrizaje
     * y objeto familias con los miembros vivos
     * @param rovers
     */
    public ArrayList<Rover> eyectarFamiliasDeNave(ArrayList<Rover> rovers) {
        int contador = 0;
        for (int i = 0; i < nave.length; i++) {
            for (int j = 0; j < nave[i].length; j++) {
                ArrayList<Persona> listaFamilia = new ArrayList<>();
                contador++;
                //System.out.println("FAMILIA: " + contador);
                //valida que la familia este viva
                if (nave[i][j].isEstado()) {
                    ArrayList<Persona> personas = new ArrayList<>();
                    personas = nave[i][j].getFamilia();

                    for (Persona persona : personas) {
                        // validad que la persona este viva, es la unica condición para agregar a la lista
                        if (persona.getEstado()) {
                            listaFamilia.add(persona);
                        }
                    }
                   
                   
                    
                    Familia tripulantes = new Familia(listaFamilia);
                    
                    boolean estanVivos = false;
                    
                    for (Persona tripulante : tripulantes.getFamilia()){
                        if (tripulante.getEstado() == true){
                            estanVivos= true;
                        }
                    }
                    
                    if (estanVivos == true){
                        //crea el rover con su respectiva familia
                    Rover rover = new Rover();
                    rover.setIdFamilia(contador);
                    rover.setEstado(true);
                    rover.setNodoAterrizaje(posicionAterrizaje());
                    rover.setTripulantes(tripulantes);

                    rovers.add(rover);
                    } else {
                        //System.out.println("La familia " + contador + " murio antes de llegar a MARTE");
                        if (nave[i][j].getCausaMuerte() == null) {
                            nave[i][j].setCausaMuerte("Diferentes eventos antes de llegar a marte");
                        }
                       // System.out.println("Causa de muerte: " + nave[i][j].getCausaMuerte());
                    }

                } else {
                    System.out.println("La familia " + contador + " murio antes de llegar a MARTE");
                    if (nave[i][j].getCausaMuerte() == null) {
                        nave[i][j].setCausaMuerte("Diferentes eventos antes de llegar a marte");
                    }
                    //System.out.println("Causa de muerte: " + nave[i][j].getCausaMuerte());
                }
            }
        }
        
        
        return rovers;
    }

    public int posicionAterrizaje() {
        int random = (int)(Math.random() * 10);
        
        if (random == 0){
            return 1;
        }
        
        //System.out.println("Random: " + random);
        
        return random;
    }

}
