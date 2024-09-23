
package Modelo;

import jakarta.persistence.*;

@Entity
public class Componente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    private String nombre, nroSerie;
    
    @ManyToOne
    @JoinColumn(name = "idcomputadora")
    private Computadora computadora;

    public Componente() {
    }

    public Componente(String nombre, String nroSerie, Computadora computadora) {
        this.nombre = nombre;
        this.nroSerie = nroSerie;
        this.computadora = computadora;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public Computadora getComputadora() {
        return computadora;
    }

    public void setComputadora(Computadora computadora) {
        this.computadora = computadora;
    }
    
}
