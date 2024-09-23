
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Computadora {
    private String codigo, marca, modelo;
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
