package modelo;

public interface Individuo {
    public double fitness();
    public DNA gerate_gamete();
    public DNA getA();
    public DNA getB();   
    public int getRG(); 
}
