import java.util.Scanner;

public class Pokedex {

	Pokemon[] pokeArray;
	
	Pokedex(int numberOfPokemon) {
		this.pokeArray = new Pokemon[numberOfPokemon];
	}

		/*
	      * Return all the names of the Pokemon species in the
	      * Pokedex
	      */
	public String[] listPokemon(){
	    	String[] speciesArray = new String[pokeArray.length];
			for(int i = 0; i < pokeArray.length; i++){
				if(pokeArray[i] != null){
					speciesArray[i] = pokeArray[i].getSpecies();
				}
	    	}
	    	return speciesArray; 
	    }
	     /*
	      * Add a Pokemon to the Pokedex and return true if it can
	      * actually be added to the Pokedex. If not, return false.
	      */
	 public boolean addPokemon(String species) {
	         Pokemon newPoke = new Pokemon(species);
	    	 int nextEmptySpace = -1;
	    	 boolean first = true;
	    	 if (pokeArray[0] != null){
		    	 for (int i = 0; i < pokeArray.length; i++){
		    		 if(pokeArray[i] == null){
		    			 nextEmptySpace = i;
		    			 break;
		    		 }
		    		 else{
		    			 for(int x = 0; x < nextEmptySpace + 1; x++){
				    		 if(pokeArray[x].getSpecies().compareToIgnoreCase(newPoke.getSpecies()) == 0){
				    	    			 nextEmptySpace = -2;
				    	     }
				    	 }
		    		 }
		    	 }
	    	 }
	    	 if (pokeArray[0] == null){
	    		 pokeArray[0] = newPoke;
	    		 return true;
	    	 }
	    	 else if (nextEmptySpace == -1){
	    		 System.out.println("Max");
	    		 return false;
	    	 }
	    	 else if (nextEmptySpace == -2){
	    		 System.out.println("Duplicate");
	    		 return false;
	    	 }
	    	 else {
	    		 pokeArray[nextEmptySpace] = newPoke;
	    		 return true;
	    	 }
	     }
	/*
	* Return the stats of a certain Pokemon that you are
	      * searching for.
	      */
	     public int[] checkStats(String species){
	    	 String pokeOfInterest = species;
	    	 int[] statsArray = new int[3];
	    	 for(int i = 0; i < pokeArray.length; i++){
		    	 if(pokeArray[i] != null){	 
		    		 if(pokeArray[i].getSpecies() == pokeOfInterest){
			    			 missing = false;
			    			 statsArray[0] = pokeArray[i].getAttack();
			    			 statsArray[1] = pokeArray[i].getDefense();
			    			 statsArray[2] = pokeArray[i].getSpeed();
			    			 break;
			    	 }
	    	 }
	    	 if (missing){
	    		 System.out.println("Missing");
	    		 statsArray[0] = 0;
	    	 }
	    	 return statsArray;
	     }
	     /*
	      * Sort Pokedex in lexical order according to Java string ordering.
	      */
	     public void sortPokedex(){
	    	 Pokemon[] tempArray = new Pokemon[pokeArray.length];
	    	 tempArray[0] = pokeArray[0];
	    	 int indexOfPrecedence = 0;
	    	 for(int i = 0; i < pokeArray.length; ++i){
	    		 for(int y = i+1; y < pokeArray.length+1; ++i){
	    			 if (pokeArray[i].getSpecies().compareToIgnoreCase(pokeArray[y].getSpecies()) > 0 ){
	    				 Pokemon temp = pokeArray[i];
	                     pokeArray[i] = pokeArray[y];
	                     pokeArray[y] = temp;
	    			 } 
	    		 }
	    	 }
	     }
	     /*
	      * Evolve a certain Pokemon that you are searching for in the
	      * Pokedex and return true if the Pokemon is actually in the
	      * the Pokedex. If not, return false.
	      */
	     public boolean evolvePokemon(String species){
	    	 boolean inPokedex = false;
	    	 for(int i = 0; i < pokeArray.length; ++i){
	    		 if(pokeArray[i].getSpecies() == species){
	    			 pokeArray[i].evolve();
	    			 inPokedex = true;
	    			 break;
	    		 }
	    	 }
	    	 return inPokedex;
	     }
		
}


