import java.util.Scanner;
public class Java_hw1_problem4 {
	public static void main(String args[]){
		Scanner scn=new Scanner(System.in);
		System.out.println("Please enter five color(in RGB):");
		String input="";
		boolean IsValid=false;
		while(true){ //let user input the valid color
			char LastChar='0'; //判斷是否連續重複，儲存迴圈上一個字用
			if(IsValid==true){ //to determine the color is valid or not
				break;
			}
			input=scn.next(); //let user input color
			input=input.toUpperCase(); //transfer input to upper case
			
			if(input.length()!=5){ //Invalid input case 1: length of input != 5
				System.out.println("Invalid input");
				continue;
			}
			for(int i=0;i<5;i++){ //Invalid input case 2: not with RGB
				if(input.charAt(i)!='R' && input.charAt(i)!='G' && input.charAt(i)!='B'){
					System.out.println("Invalid input");
					continue;
				}
			}
			
			for(int i=0;i<5;i++){ //判斷是否連續重複
				if(LastChar==input.charAt(i)){ //發現重複
					System.out.println("Invalid input");
					IsValid=false;
					break;
				}
				if(i==4){ //完成檢查，合法
					IsValid=true;
				}
				LastChar=input.charAt(i); //儲存迴圈上一個字用
			}
		}
		for(int i=0;i<3;i++){
			System.out.println(input);
		}
	}
}
