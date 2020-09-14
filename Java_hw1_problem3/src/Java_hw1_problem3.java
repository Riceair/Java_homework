import java.util.Random;
import java.util.Scanner;
public class Java_hw1_problem3 {
	public static void main(String args[]){
		Scanner scn=new Scanner(System.in); //Variable for Scanner
		Random RandomGenerator=new Random(); //Variable to generate random number
		String answer=""; //Variable to store answer
		String input=""; //Variable to store the input for user
		for(int i=0;i<4;i++){
			answer=answer+RandomGenerator.nextInt(10); //Let answer to store four random integer
		}
		System.out.println("Please enter for integers to guess:");
		while(true){
			int A=0; //variable A to record the right number in right place
			int B=0; //variable B to record the right number in wrong place
			int IsCheck[]=new int[4]; //variable to check the answer checked or not
			input=scn.next(); //to store input
			if(input.length()!=4){ //for invalid input
				System.out.println("Invalid Input!!");
				continue;
			}
			for(int i=0;i<4;i++){ //to check A(����P�_A�A�קK�᭱�P�_B�X��)
				if(answer.charAt(i)==input.charAt(i)){
					IsCheck[i]=1; //to record the place is checked
					A++;
					continue;
				}
			}
			for(int i=0;i<4;i++){ //to check B
				if(answer.charAt(i)==input.charAt(i)){ //��A
					continue;
				}
				for(int j=0;j<4;j++){ //�v�@���M��O�_�s�bB
					if(i==j || IsCheck[j]==1){ //the place is already checked
						continue;
					}
					if(input.charAt(i)==answer.charAt(j)){ //���i�ରB
						B++;
						IsCheck[j]=1; //to record the place is checked
						break; //input�Ӧ�m�w�������I
					}
				}
			}
			if(A==4){
				System.out.println("4A,you got the right answer");
				break;
			}
			System.out.println(A+"A "+B+"B");
		}
		System.out.println("Program finished running...");
	}
}
