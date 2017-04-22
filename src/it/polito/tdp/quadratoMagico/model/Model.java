package it.polito.tdp.quadratoMagico.model;

import java.util.*;

public class Model {
	
	List <Square> solutions = null;
	
	public List<Square> findMagicSquare(int dim){
		
		solutions = new ArrayList <Square>();
		
		//Creo un oggetto square
		Square square = new Square (dim);
		System.out.println("Square id:" + square.getId());
		
		//Richiamo la funzione ricorsiva
		int step =0;
		recursive(square, step);
	
		// Ritorno tutte le soluzioni trovate
		return solutions;
		
	}
	
	public void recursive(Square square, int step){
		
		//A: condizione di terminazione
		if (step >= square.getN2()){
			// doSomething : valuto la soluzione trovata
			if(square.checkMagicConstant()){
				solutions.add(new Square(square));
			}
			return;
		}
		
		for(int i = 1 ; i <= square.getN2() ; i ++){
			if(!square.contains(i)){
				square.add(i);
				recursive(square, step+1);
				square.remove(i);
			}
		}
	}

}
