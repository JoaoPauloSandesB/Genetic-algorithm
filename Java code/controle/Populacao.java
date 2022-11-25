package controle;

import java.util.ArrayList;
import java.util.Collections;

import modelo.Individuo;
import modelo.IndividuoPi;

public class Populacao {
    private ArrayList<Individuo> Individuos = new ArrayList<Individuo>();

    public Populacao(int qtd) { // Start a population randomly
        for (int i = 0; i < qtd; i++) {
            Individuo createIndividuo = new IndividuoPi();
            Individuos.add(createIndividuo);
        }
    }

    public void maxPop(int qtd) { // Reduces the population to a predefined value (uses array order)
        while (true) {
            if (Individuos.size() > qtd)
                Individuos.remove(qtd);
            else
                break;
        }
    }

    public void addIndividuo(Individuo ze) { // Add individual to population
        Individuos.add(ze);
    }

    public Individuo getIndividuo(int num) { // Returns individual from population array
        return Individuos.get(num);
    }

    public double maxFitness() { // Returns the grade of the first individual in the population array
        return Individuos.get(0).fitness();
    }

    public String see_individuo(int id, int gen) { // Returns information for the specified individual in the population
                                                   // array
        return "A: " + Individuos.get(id).getA().getGenesDNA() + "  B: " + Individuos.get(id).getB().getGenesDNA()
                + "  fitness: " + Individuos.get(id).fitness() + "  RG: " + Individuos.get(id).getRG();
    }

    public String see_pop(int gen) { // Returns information for all individuals in the population array
        String pop = new String("");

        for (int L = 0; L < Individuos.size(); L++) {
            pop = pop + "A: " + Individuos.get(L).getA().getGenesDNA() + "  B: "
                    + Individuos.get(L).getB().getGenesDNA() + "  fitness: " + Individuos.get(L).fitness() + "  RG: "
                    + Individuos.get(L).getRG() + "\n";
        }

        return pop;
    }

    public int size_pop() { // Returns the size of the population
        return Individuos.size();
    }

    public void arrange() { // Arranges the array in note order.
        while (true) {
            boolean ok = true;
            for (int l = 0; l < Individuos.size() - 1; l++) {
                if (Individuos.get(l).fitness() < Individuos.get(l + 1).fitness()) {
                    Collections.swap(Individuos, l, l + 1);
                    ok = false;
                }
            }
            if (ok)
                break;
        }
    }
}
