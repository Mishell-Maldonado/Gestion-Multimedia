package modelo;
import java.util.ArrayList;

public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private ArrayList<Temporada> listaTemporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }
    
    public void agregarTemporada(Temporada temporada) {
        listaTemporadas.add(temporada);
    }
    
    public ArrayList<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }
    
  
}