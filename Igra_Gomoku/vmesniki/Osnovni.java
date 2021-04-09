package vmesniki;
import logika.*;
import splosno.Koordinati;

import java.util.LinkedList;
import java.util.Scanner;



// Vmesnik, ki v terminal izpisuje zadeve

public class Osnovni {
	
	public static Igra igra;
	
	public static void main(String[] args) {
		
		igra = new Igra();
		int potezaX;
		int potezaY;
		/**
		 * Mogoče se bi bolj splačalo pogledati samo dolžino odigranePoteze, 
		 * mozne poteze vsakič znova preveri celotno polje
		 * ?
		 * @jaka
		 */
		LinkedList<Koordinati> preostalePoteze = Igra.moznePoteze(); 
		printPlosca();
		Scanner scanner = new Scanner(System.in);
		
		while(preostalePoteze != null) {
			
			System.out.print("Vpiši x koordinato poteze: ");
			potezaX = scanner.nextInt() - 1;
			System.out.print("Vpiši y koordinato poteze: ");
			potezaY = scanner.nextInt() - 1;
			
			Koordinati trenutnaPoteza = new Koordinati(potezaX, potezaY);
			
			if (Igra.poteza(trenutnaPoteza)){
				printPlosca();
			}
			else System.out.print("Neveljavna poteza:");
		}
		scanner.close();
		return;		
	}
	//izpis igralne plošče v terminalu
    public static void printPlosca() {

        for (int i = 0; i < 15; ++i) {
            String out = "[";

         
            Polje[] row = Igra.plosca[i];
            for (int j = 0; j < 15; ++j) {
                Polje v = row[j];
                
                if (v.equals(Polje.O)){
        			out += "O";
                }
                else if (v.equals(Polje.X)){
        			out += "X";
                }
                else out += "_";
        			
                if (j != row.length - 1) {
                    out += "|";
                }
            }
        out += "]";


            System.out.println(out);
        }
    }
}