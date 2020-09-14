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
			for(int i=0;i<4;i++){ //to check A(先行判斷A，避免後面判斷B出錯)
				if(answer.charAt(i)==input.charAt(i)){
					IsCheck[i]=1; //to record the place is checked
					A++;
					continue;
				}
			}
			for(int i=0;i<4;i++){ //to check B
				if(answer.charAt(i)==input.charAt(i)){ //為A
					continue;
				}
				for(int j=0;j<4;j++){ //逐一比對尋找是否存在B
					if(i==j || IsCheck[j]==1){ //the place is already checked
						continue;
					}
					if(input.charAt(i)==answer.charAt(j)){ //找到可能為B
						B++;
						IsCheck[j]=1; //to record the place is checked
						break; //input該位置已找到對應點
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
