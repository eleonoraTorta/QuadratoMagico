package it.polito.tdp.quadratoMagico.model;

import java.util.*;

public class TestModel {
	
	public static void main (String[] args){
		
		Model model = new Model();
		List <Square > solutions = model.findMagicSquare(3);
		
		if(solutions!= null && solutions.size() >0){
			System.out.println("Trovata almeno una soluzione");
			
			for(Square s : solutions){
				System.out.println(s.toString());
			}
		} else{
			System.out.println("Nessuna soluzione trovata");
		}
	}

}
