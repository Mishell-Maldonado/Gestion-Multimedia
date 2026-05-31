package modelo;
import java.util.ArrayList;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private ArrayList<Investigador> investigadores;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }
    
    public void agregarInvestigador(Investigador investigador){
        this.investigadores.add(investigador); 
    }
    
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores; 
    }    
    
    }