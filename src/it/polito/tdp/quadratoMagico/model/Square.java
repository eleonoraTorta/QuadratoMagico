package it.polito.tdp.quadratoMagico.model;

import java.util.*;

public class Square {
	
	private static int next_id =0;
	private final int id;             // final = non e` possibile modificarla dopo l'assegnazione
	
	//Lista come struttura dati per la griglia
	List <Integer> griglia = null;
	int N;
	int N2;
	int magicConst;
	
	public Square (int dimension){
		this.griglia = new ArrayList <Integer>();
		this.N = dimension;
		this.N2 = N *N;
		this.magicConst = N *(N*N +1)/2;
		id = next_id;
		next_id +=1;
	}
	
	public Square (Square square){
		this.griglia = new ArrayList <Integer>(square.getGriglia());
		this.N = square.getN();
		this.N2 = N *N;
		this.magicConst = N *(N*N +1)/2;
		id = next_id;
		next_id +=1;
	}

	public int getId(){
		return id;
	}

	
	public List<Integer> getGriglia() {
		return griglia;
	}

	

	public int getN2() {
		return N2;
	}
	
	public int getN() {
		return N;
	}


	public boolean checkMagicConstant() {
		
		if(griglia.size() !=N2){
			return false;
		}
		//controllare le righe
		if( !checkRows()){
			return false;
		}
		//controllare le colonne
		if(!checkColumns()){
			return false;
		}
		//controllare le diagonali
		if( checkDiagonals()){
			return false;
		}
		return true;
	}


	private boolean checkRows() {
	//	matrice [i][j] 
	//	array[i* n+j];
	
	//	0,0  0,1 0,2
	//	1,0  1,1 1,2
	//	2,0  2,1 2,2
		
	//	0 1 2  3 =(1,0) ..... 8  
		
		for(int i =0; i<N; i++){
			int temp = 0;
			for(int j =0; j< N ; j++){
				temp += griglia.get(i*N +j);
			}
			if(temp != magicConst){
				return false;
			}
		}
		return true;
		
	}
	private boolean checkColumns() {
		
		//	0,0  0,1 0,2
		//	1,0  1,1 1,2
		//	2,0  2,1 2,2
		
		for(int i =0; i<N; i++){
			int temp = 0;
			for(int j =0; j< N ; j++){
				temp += griglia.get(j*N +i);
			}
			if(temp != magicConst){
				return false;
			}
		}
		return true;
		
		
	}
	private boolean checkDiagonals() {
		

		//	0,0  0,1 0,2
		//	1,0  1,1 1,2
		//	2,0  2,1 2,2
		
		int temp=0;
		for(int i =0; i<N; i++){
			temp += griglia.get(i*N +i);
		}
			
		if(temp != magicConst){
				return false;
		}
		
		temp=0;
		for(int i= N-1; i>= 0 ; i--){
			temp += griglia.get((N-1 -i)* N +i);
		}
		
		if(temp != magicConst){
			return false;
		}
		
		return true;
		
		
	}


	public void add(int number) {
		griglia.add(number);	
	}
	
	public void remove(int number) {
	//	griglia.remove(new Integer(number));	
		griglia.remove(Integer.valueOf(number));
		griglia.remove( (Integer) number);
	}


	public boolean contains(int number) {
		return griglia.contains(number);
	}
	
	public String toString(){
		//return this.id +" " +griglia.toString();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("Square id: %d\n", id));
		
		if (griglia.size() > 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					sb.append(String.format("%d ", griglia.get(i * N + j)));
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	

}
