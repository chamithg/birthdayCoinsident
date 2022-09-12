
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class simulates the coinsidence of matching birthdays of 23 people.
 * @author chamith
 * @since 09/10/2022
 * 
 */

public class BirthdayCoincidenceAverage {
	
	static Random rand= new Random();
	private final static int NUM_DAYS_PER_YEAR = 365;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter Number of Trails:"); // message to get input from user
		int numOfTrails = scnr.nextInt();  // getting the input
		int[]results = runSpecificTrails(numOfTrails);  // running the get_random_birthdays for given num of trails
		printResults(results, numOfTrails);  // print results
	}
	
	static int get_random_birthdays () {  // returns result from one test
		
		ArrayList <Integer> birthdayOfPeopleInRoom = new ArrayList <Integer>() ; // holds each person's birthday
		
		for(int i = 0 ; i < 23; i++  ) {
			int birthday = 1+ rand.nextInt(NUM_DAYS_PER_YEAR);  // get random value form birthday
			
			if(birthdayOfPeopleInRoom.contains(birthday)) {   // returns the num of people in the room when match found
				
				//System.out.println("Match found at the entrence of person no: "+ ( i));				
				return(i);
			}else {
				birthdayOfPeopleInRoom.add(birthday); // returns 0 if no match found
			}
			
		}
		return 0;
		
		
	}
	
	private static int[] runSpecificTrails (int numOfTrails){  // runs the trail given number of times
		int[] resultArray = new int[23];  // holds the count of times get the same result(num of people)
		
		for(int j = 0; j< numOfTrails; j++) {  // runs the get_random_birthdays method given num of times
			int singleResult = get_random_birthdays ();
			resultArray[singleResult]+=1;		// increase the relevent index of resultArray accodingly
		}
	
		return resultArray;
		
	}
	
	private static void printResults(int[] resultArray, int numOfTrails) {  //print results
		int totalMatchedPeopleCount =0;  // holds the number of people after all trails.
		
		for(int k= 0; k< 23;k++) {   // calculate and return the result
			Double percentage = (Double.valueOf(resultArray[k]))/ numOfTrails *100;
			
			if(k==0) {
				System.out.printf("Not matching birthday percentage is %.2f\n", percentage);// returns non match found percentage.
			}else {
				totalMatchedPeopleCount+=(resultArray[k]* k); // add the num of people to totalMatchedPeopleCount after each test.
				System.out.printf("Percentage of Match found at the entrence of person no: %d is %.2f\n", k,percentage);
			}
		}
		
		Double average = (Double.valueOf(totalMatchedPeopleCount))/ numOfTrails; // calculate average of people
		System.out.printf("Average no people in room when match found is %.0f\n", average); // returns the average
	}  
	

}
