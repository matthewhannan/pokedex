import java.util.*;
import java.lang.*;

public class Main{

	public static int printOptions(){
		System.out.println("\n1. List Pokemon\n2. Add Pokemon\n3. Check a Pokemon’s Stats\n4. Evolve Pokemon\n5. Sort Pokemon\n6. Exit\n");
		Scanner input = new Scanner(System.in);
		System.out.println("What would you like to do? ");
		int chosenOption = input.nextInt();
		return chosenOption;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to your new PokeDex!");
		Scanner input = new Scanner(System.in);
		System.out.println("How many Pokemon are in your region: ");
		int numOfPokemon = input.nextInt();
		Pokedex myPokedex = new Pokedex(numOfPokemon);
		System.out.println("\nYour new Pokedex can hold " + numOfPokemon + " Pokemon. Let’s start using it!");
		int userOption = 0;
		boolean exit = false;
		while (exit != true){
			userOption = printOptions();
			Scanner inputTwo = new Scanner(System.in);
			switch (userOption) {
	            case 1:  String[] pokeNames = myPokedex.listPokemon();
	            		 for (int i=0;i<pokeNames.length;i++){
	            			 if(pokeNames[i] != null){
	            				 System.out.println((i+1) + ". " + pokeNames[i]);
	            			 }
	            		 }
	                     break;
	            case 2:  System.out.println("Please enter the pokemon's species: ");
	            		 String species = inputTwo.nextLine();
	            		 myPokedex.addPokemon(species);
	                     break;
	            case 3:  System.out.println("Please enter the Pokemon of interest: ");
	            		 Scanner inputThree = new Scanner(System.in);
		    	 		 String pokeOfInterest = inputThree.nextLine();
	            		 int[] statsArr;
	            		 statsArr = myPokedex.checkStats(pokeOfInterest);
	            		 if(statsArr[0] != 0){
		            		 System.out.println("Attack: " + statsArr[0]);
		            		 System.out.println("Defense: " + statsArr[1]);
		            		 System.out.println("Speed: " + statsArr[2]);
	            		 }
	                     break;
	            case 4:  System.out.println("Please enter the Pokemon of interest: ");
	            		 String tempPokemon = inputTwo.nextLine();
	            		 if(myPokedex.evolvePokemon(tempPokemon)){
	            			 System.out.println(tempPokemon + " has evolved!");
	            		 }
	            		 else{
	            			 System.out.println("Missing");
	            		 }
	                     break;
	            case 5:  myPokedex.sortPokedex();
	                     break;
	            case 6:  exit = true;
	            		 break;
	            default: System.out.println("Invalid option, try again!");
	            		 break;
		    }
		}
		
	}

}
