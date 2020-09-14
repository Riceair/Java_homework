import java.lang.Math;     //to import Math class
import java.util.Scanner;  //to import Scanner class
public class Java_hw1_problem1 {
	public static void main(String args[]){
		Scanner scn=new Scanner(System.in);  //create an object for input
		int r1=(int)(Math.random()*6); //to create first random value between 0 to 5
		int r2=(int)(Math.random()*6); //to create second random value between 0 to 5
		int answer=r1+r2;  //create variable answer to store r1+r2 for question
		System.out.println("Please guess a number between 0 to 10");
		while(true){  //while loop to let user repeat enter an answer
			int input=scn.nextInt();  //let user enter an integer to guess
			if(input!=answer){  //if user input the wrong answer
				System.out.println("Wrong...");
			}
			else{  //if user input the right integer
				System.out.println("Right!");
				break;
			}
		}
	}
}