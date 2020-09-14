import java.util.Scanner; //import Scanner object
public class Java_hw1_problem2 {
	public static void main(String args[]){
		Scanner scn=new Scanner(System.in); //object to scan
		long input=0; //variable for input
		long Max=0; //variable to store the maximum input
		System.out.println("Please enter positive integer. System will show you the maximum.\n"
				+ "Enter -1 to exit.");
		while(true){ //while loop for input
			input=scn.nextLong(); //to read input
			if(input==-1){ //if -1 then stop
				break;
			}
			else if(input>=Max){ //input取代Max
				Max=input;
				System.out.println("Current maximum integer: "+Max);
			}
			else if(input<0){ //如果輸入負數則報錯
				System.out.println("Please enter positive integer!!\n"
						+ "Current maximum integer: "+Max);
			}
			else{ //如input無超過Max則維持
				System.out.println("Current maximum integer: "+Max);
			}
		}
		System.out.println("Program finished running...");
	}
}
