
package Modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Computadora {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo, marca, modelo;
    
    @OneToMany(mappedBy = "computadora", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Componente> componentes;

    public Computadora() {
        this.componentes = new ArrayList<>();
    }

    public Computadora(String codigo, String marca, String modelo) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.componentes = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
    
    public void addComponente(Componente componente){
        this.componentes.add(componente);
    }
    
    
}
