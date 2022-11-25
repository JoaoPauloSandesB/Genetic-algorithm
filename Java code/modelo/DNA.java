package modelo;

import java.util.ArrayList;
import java.util.Random;

public class DNA {
    private ArrayList<Gene> Genes = new ArrayList<Gene>();  // DNA gene set
    Random rand = new Random();

    public void adicionarGene(int tamanho_Gene) {           // Add random gene to DNA
        Gene novo = new Gene(tamanho_Gene);
        Genes.add(novo);
    }

    public void addGene(Gene C) {                           // Add specific gene to DNA
        Genes.add(C);
    }

    public int getSize() {                                  // Returns number of genes in DNA
        return Genes.size();
    }

    public void crossOver(double prob)                      // Gene change by crossover
    {
        for(int j=0; j<Genes.size(); j++){
            for(int s=0; s<Genes.get(j).getGene().length(); s++){
                Double cross = rand.nextDouble();
                if(cross<prob){
                    if(Genes.get(j).getGene().charAt(s)=='A')    Genes.get(j).modifyGene(s,"T"); //adenina to timina
                    if(Genes.get(j).getGene().charAt(s)=='T')    Genes.get(j).modifyGene(s,"A"); //timina to adenina
                    if(Genes.get(j).getGene().charAt(s)=='C')    Genes.get(j).modifyGene(s,"G"); //citosina to guanina
                    if(Genes.get(j).getGene().charAt(s)=='G')    Genes.get(j).modifyGene(s,"C"); //guanina to citosina
                }
            }
        }
    }

    public String getGeneDNA(int num){                      // Returns a gene from DNA
        try{
            return Genes.get(num).getGene();
        }
        catch (Exception e){
            return "Gene not Found";
        }
    }

    public String getGenesDNA(){                            // Returns all genes from DNA
        try{
            String cromossomo = new String();
            for(int n=0;n<Genes.size();n++){
                cromossomo = cromossomo + Genes.get(n).getGene();
                if(n+1<Genes.size())
                cromossomo = cromossomo + " ";
            }
            return cromossomo;
        }
        catch (Exception e){
            return "Not Found";
        }
    }
}
