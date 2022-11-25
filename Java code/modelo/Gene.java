package modelo;

import java.util.Random;

public class Gene {
    Random rand = new Random();
    private String sequence = new String(); // Nitrogen base sequence

    public Gene (String seq){   // Starts a gene with predefined sequence
        this.sequence=seq;
    }

    public Gene (int size){     // Starts a gene with random sequence
        for(int i=0;i<size;i++){
            double choice = rand.nextDouble();
            if((choice >= 0) && (choice < 0.25))    this.sequence = this.sequence + "A"; // Adenina
            if((choice >= 0.25) && (choice < 0.5))  this.sequence = this.sequence + "C"; // Citosina
            if((choice >= 0.5) && (choice < 0.75))  this.sequence = this.sequence + "G"; // Guanina 
            if((choice >= 0.75) && (choice <= 1))   this.sequence = this.sequence + "T"; // Timina
        }
    }

    public String getGene() {   // Returns sequence of nitrogenous bases
        return this.sequence;
    }

    public void modifyGene(int position,String replacement) {   // Modifies a specific nitrogenous base in the sequence
        sequence = sequence.substring(0, position) + replacement + sequence.substring(position + 1);
    }
}